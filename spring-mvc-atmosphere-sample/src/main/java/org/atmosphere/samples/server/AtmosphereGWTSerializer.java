package org.atmosphere.samples.server;

import org.atmosphere.gwt.server.JSONSerializer;
import org.atmosphere.gwt.server.SerializationException;

public class AtmosphereGWTSerializer implements JSONSerializer {

	CustomObjectMapper objectMapper = new CustomObjectMapper();

	public String serialize(Object data) throws SerializationException {
		try {
			return objectMapper.writeValueAsString(data);
		} catch (Exception e) {
			e.printStackTrace();
			return data.toString();
		}

	}



}
