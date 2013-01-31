package org.atmosphere.samples.client.test;

import com.github.gwtbootstrap.client.ui.SubmitButton;
import com.github.gwtbootstrap.client.ui.TextBox;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.ViewImpl;

public class TestView extends ViewImpl implements TestPresenter.MyView {

	private final Widget widget;

	public interface Binder extends UiBinder<Widget, TestView> {
	}

	@UiField
	SubmitButton submit;

	@UiField
	TextBox textbox;

	@UiField
	VerticalPanel messageList;

	@Inject
	public TestView(final Binder binder) {
		widget = binder.createAndBindUi(this);
	}

	@Override
	public Widget asWidget() {
		return widget;
	}

	public SubmitButton getSubmit() {
		return submit;
	}

	public TextBox getTextbox() {
		return textbox;
	}

	public VerticalPanel getMessageList() {
		return messageList;
	}
}
