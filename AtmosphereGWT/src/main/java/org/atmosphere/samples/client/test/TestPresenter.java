package org.atmosphere.samples.client.test;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.atmosphere.gwt.client.AtmosphereClient;
import org.atmosphere.gwt.client.AtmosphereGWTSerializer;
import org.atmosphere.gwt.client.AtmosphereListener;
import org.atmosphere.samples.client.TwitterMessage;
import org.atmosphere.samples.client.TwitterMessageSerializer;
import org.atmosphere.samples.client.place.NameTokens;

import com.github.gwtbootstrap.client.ui.Label;
import com.github.gwtbootstrap.client.ui.SubmitButton;
import com.github.gwtbootstrap.client.ui.TextBox;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.rpc.StatusCodeException;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.inject.Inject;
import com.google.inject.name.Named;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyCodeSplit;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import com.gwtplatform.mvp.client.proxy.RevealRootLayoutContentEvent;

public class TestPresenter extends Presenter<TestPresenter.MyView, TestPresenter.MyProxy> {

	static final Logger logger = Logger.getLogger(TestPresenter.class.getName());

	public interface MyView extends View {
		public SubmitButton getSubmit();

		public TextBox getTextbox();

		public HTMLPanel getMessageList();
	}

	@ProxyCodeSplit
	@NameToken(NameTokens.test)
	public interface MyProxy extends ProxyPlace<TestPresenter> {
	}

	@Inject
	public TestPresenter(final EventBus eventBus, final MyView view, final MyProxy proxy, @Named("restServer") String restServer) {
		super(eventBus, view, proxy);
		this.restServer = restServer;
	}

	@Override
	protected void revealInParent() {
		RevealRootLayoutContentEvent.fire(this, this);
	}

	@Override
	protected void onBind() {
		super.onBind();

		startWebSockets();

		getView().getSubmit().addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				sendMessage(getView().getTextbox().getText());

			}
		});
	}

	AtmosphereClient client;
	MyCometListener cometListener = new MyCometListener();
	AtmosphereGWTSerializer serializer = GWT.create(TwitterMessageSerializer.class);
	String restServer;

	String getUrl() {
		// return
		// "ws://localhost:8080/spring-mvc-atmosphere-sample/websockets/?X-Atmosphere-tracking-id=0&X-Atmosphere-Framework=1.0&X-Atmosphere-Transport=websocket&X-Cache-Date=0&Content-Type=application/json";
		return restServer + "/";// + "/websockets?Content-Type=application/json";
	}

	private void startWebSockets() {
		Scheduler.get().scheduleDeferred(new Scheduler.ScheduledCommand() {
			@Override
			public void execute() {
				client = new AtmosphereClient(getUrl(), serializer, cometListener, true);
				client.start();
			}
		});
	}

	private void sendMessage(String message) {

		TwitterMessage twitterMessage = new TwitterMessage();
		twitterMessage.setId(new Long(100));
		twitterMessage.setText("Message:" + getView().getTextbox().getText());

		client.post(twitterMessage);
	}

	private class MyCometListener implements AtmosphereListener {

		// DateTimeFormat timeFormat = DateTimeFormat.getFormat(DateTimeFormat.PredefinedFormat.TIME_MEDIUM);

		@Override
		public void onConnected(int heartbeat, String connectionUUID) {
			logger.info("onConnected::::::::: comet.connected [" + heartbeat + ", " + connectionUUID + "]");
			// addChatLine(MESSAGE_ROOM_CONNECTED, COLOR_SYSTEM_MESSAGE);
		}

		@Override
		public void onBeforeDisconnected() {
			logger.log(Level.INFO, "onBeforeDisconnected::::::: comet.beforeDisconnected");
			// if (author != null) {
			// client.broadcast(new Event(author, MESSAGE_LEFT_ROOM));
			// }
		}

		@Override
		public void onDisconnected() {
			logger.info("onDisconnected:::::::: comet.disconnected");
			// addChatLine(MESSAGE_ROOM_DISCONNECTED, COLOR_SYSTEM_MESSAGE);
		}

		@Override
		public void onError(Throwable exception, boolean connected) {
			int statuscode = -1;
			if (exception instanceof StatusCodeException) {
				statuscode = ((StatusCodeException) exception).getStatusCode();
			}
			logger.log(Level.SEVERE, "onError::::::::: comet.onError [connected=" + connected + "] (" + statuscode + ")", exception);
			// addChatLine(MESSAGE_ROOM_ERROR + exception.getMessage(), COLOR_SYSTEM_MESSAGE);
		}

		@Override
		public void onHeartbeat() {
			logger.info("onHeartbeat::::: comet.onHeartbeat [" + client.getConnectionUUID() + "]");
		}

		@Override
		public void onRefresh() {
			logger.info("onRefresh::::::: comet.onRefresh [" + client.getConnectionUUID() + "]");
		}

		@Override
		public void onAfterRefresh(String connectionUUID) {
			logger.info("onAfterRefresh::::::: comet.onAfterRefresh [" + client.getConnectionUUID() + "]");
		}

		@Override
		public void onMessage(List<?> messages) {
			logger.info("onMessage::::::: comet.onMessage [" + client.getConnectionUUID() + "]");
			for (Object obj : messages) {
				if (obj instanceof TwitterMessage) {
					TwitterMessage twitterMessage = (TwitterMessage) obj;

					GWT.log(twitterMessage.getText());
					getView().getMessageList().add(new Label(twitterMessage.getText()));

				}
			}
		}
	}
}
