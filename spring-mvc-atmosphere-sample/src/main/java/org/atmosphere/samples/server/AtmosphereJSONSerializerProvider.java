package org.atmosphere.samples.server;

import org.atmosphere.gwt.server.JSONDeserializer;
import org.atmosphere.gwt.server.JSONSerializer;
import org.atmosphere.gwt.server.spi.JSONSerializerProvider;

public class AtmosphereJSONSerializerProvider implements JSONSerializerProvider {

	public JSONSerializer getSerializer() {
		return new AtmosphereGWTSerializer();
	}

	public JSONDeserializer getDeserializer() {
		return new AtmosphereGWTDeSerializer();
	}

}
