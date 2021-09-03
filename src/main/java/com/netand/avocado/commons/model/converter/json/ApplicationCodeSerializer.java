package com.netand.avocado.commons.model.converter.json;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.netand.avocado.commons.model.enums.ApplicationCodes;

import java.io.IOException;

public class ApplicationCodeSerializer extends JsonSerializer< ApplicationCodes > {

	@Override
	public void serialize( ApplicationCodes value, JsonGenerator gen, SerializerProvider serializers ) throws IOException {

		gen.writeStartObject();
		gen.writeStringField( "code", value.getCode() );
		gen.writeStringField( "description", value.getDescription() );
		gen.writeEndObject();
	}
}