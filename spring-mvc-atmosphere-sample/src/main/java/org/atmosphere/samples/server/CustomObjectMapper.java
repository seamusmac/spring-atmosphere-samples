package org.atmosphere.samples.server;

import org.codehaus.jackson.annotate.JsonTypeInfo;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

@Component("jacksonObjectMapper")
public class CustomObjectMapper extends ObjectMapper {

	// Initialiser block
	{
		this.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
		this.disable(SerializationFeature.WRAP_ROOT_VALUE);
		this.setSerializationInclusion(Include.NON_NULL);
		this.enableDefaultTypingAsProperty(DefaultTyping.JAVA_LANG_OBJECT, "class");

	}


}
