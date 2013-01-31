package org.atmosphere.samples.client.gin;

import org.atmosphere.samples.client.place.ClientPlaceManager;
import org.atmosphere.samples.client.place.DefaultPlace;
import org.atmosphere.samples.client.place.ErrorPlace;
import org.atmosphere.samples.client.place.NameTokens;
import org.atmosphere.samples.client.test.TestPresenter;
import org.atmosphere.samples.client.test.TestView;

import com.google.inject.name.Names;
import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;
import com.gwtplatform.mvp.client.gin.DefaultModule;

public class ClientModule extends AbstractPresenterModule {

	@Override
	protected void configure() {

		// SINGLETONS -- APP
		install(new DefaultModule(ClientPlaceManager.class));

		// CONSTANTS
		bindConstant().annotatedWith(ErrorPlace.class).to(NameTokens.error);
		bindPresenter(TestPresenter.class, TestPresenter.MyView.class, TestView.class, TestPresenter.MyProxy.class);

		bindConstant().annotatedWith(DefaultPlace.class).to(NameTokens.test);
	}

}
