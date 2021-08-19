package com.netand.avocado.commons.model.converter.json;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.netand.avocado.commons.enums.ApplicationCodes;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

public class ApplicationCodeDeserializer extends JsonDeserializer< ApplicationCodes > {

	@Override
	public ApplicationCodes deserialize( JsonParser p, DeserializationContext ctxt ) throws IOException {

		return ApplicationCodes.findByCode( p.getText() ).orElse( null );
	}
}
