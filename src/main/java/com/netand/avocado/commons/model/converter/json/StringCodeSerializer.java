package com.netand.avocado.commons.model.converter.json;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.netand.avocado.commons.model.CodeEnums;

import java.io.IOException;

public class StringCodeSerializer extends JsonSerializer< CodeEnums< String > > {

	@Override
	public void serialize( CodeEnums< String > value, JsonGenerator gen, SerializerProvider serializers ) throws IOException {

		gen.writeStartObject();
		gen.writeStringField( "code", value.getCode() );
		gen.writeStringField( "name", value.name() );
		gen.writeEndObject();
	}
}