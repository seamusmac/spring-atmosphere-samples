package org.atmosphere.samples.client.gin;

import org.atmosphere.samples.client.test.TestPresenter;

import com.google.gwt.inject.client.AsyncProvider;
import com.google.gwt.inject.client.GinModules;
import com.google.gwt.inject.client.Ginjector;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.proxy.PlaceManager;

@GinModules({ ClientModule.class })
public interface ClientGinjector extends Ginjector {

	PlaceManager getPlaceManager();

	EventBus getEventBus();

	AsyncProvider<TestPresenter> getTestPresenter();
}
