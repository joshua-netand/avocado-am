package com.netand.avocado.commons.model.converter.json;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.netand.avocado.commons.model.CloudTypes;
import com.netand.avocado.commons.model.CodeEnums;

import java.io.IOException;

public class CloudTypeSerializer extends JsonSerializer< CloudTypes > {

	@Override
	public void serialize( CloudTypes value, JsonGenerator gen, SerializerProvider serializers ) throws IOException {

		gen.writeStartObject();
		gen.writeStringField( "code", value.getCode() );
		gen.writeStringField( "description", value.getDescription() );
		gen.writeEndObject();
	}
}