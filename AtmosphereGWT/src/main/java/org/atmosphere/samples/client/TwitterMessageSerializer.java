package org.atmosphere.samples.client;

import org.atmosphere.gwt.client.AtmosphereGWTSerializer;
import org.atmosphere.gwt.client.SerialTypes;
import org.atmosphere.gwt.shared.SerialMode;

@SerialTypes(value = { TwitterMessage.class }, mode = SerialMode.JSON, pushMode = SerialMode.JSON)
public abstract class TwitterMessageSerializer extends AtmosphereGWTSerializer {

}
