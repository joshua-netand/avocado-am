package com.netand.avocado.commons.model.converter.json;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.netand.avocado.commons.model.enums.CodeEnums;

import java.io.IOException;

public class IntegerCodeSerializer extends JsonSerializer< CodeEnums< Integer > > {

	@Override
	public void serialize( CodeEnums< Integer > value, JsonGenerator gen, SerializerProvider serializers ) throws IOException {

		gen.writeStartObject();
		gen.writeNumberField( "code", value.getCode() );
		gen.writeStringField( "name", value.name() );
		gen.writeEndObject();
	}
}