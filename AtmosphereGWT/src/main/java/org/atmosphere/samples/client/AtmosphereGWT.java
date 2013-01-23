package org.atmosphere.samples.client;

import org.atmosphere.samples.client.gin.ClientGinjector;
import org.atmosphere.samples.client.place.NameTokens;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.gwtplatform.mvp.client.DelayedBindRegistry;
import com.gwtplatform.mvp.client.proxy.PlaceRequest;

public class AtmosphereGWT implements EntryPoint {

	private final ClientGinjector ginjector = GWT.create(ClientGinjector.class);

	@Override
	public void onModuleLoad() {
		// This is required for Gwt-Platform proxy's generator
		DelayedBindRegistry.bind(ginjector);

		ginjector.getPlaceManager().revealPlace(new PlaceRequest(NameTokens.test));
	}

}
