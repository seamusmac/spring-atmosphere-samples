package org.atmosphere.samples.server;

import org.atmosphere.gwt.server.JSONDeserializer;
import org.atmosphere.gwt.server.SerializationException;
import org.atmosphere.samples.shared.TwitterMessage;

public class AtmosphereGWTDeSerializer implements JSONDeserializer {

	CustomObjectMapper objectMapper = new CustomObjectMapper();

	public Object deserialize(String data) throws SerializationException {

		try {
			return objectMapper.readValue(data, TwitterMessage.class);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

}
