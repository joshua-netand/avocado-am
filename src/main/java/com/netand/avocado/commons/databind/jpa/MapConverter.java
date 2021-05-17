package com.netand.avocado.commons.databind.jpa;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.persistence.AttributeConverter;
import java.io.IOException;
import java.util.Map;

public class MapConverter implements AttributeConverter< Map< String, Object >, String > {

	private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

	@Override
	public String convertToDatabaseColumn( Map< String, Object > map ) {

		try {

			return OBJECT_MAPPER.writerWithDefaultPrettyPrinter().writeValueAsString( map );

		} catch ( JsonProcessingException e ) {

			throw new RuntimeException( e );
		}
	}

	@Override
	@SuppressWarnings( "unchecked" )
	public Map< String, Object > convertToEntityAttribute( String json ) {

		try {

			return OBJECT_MAPPER.readValue( json, Map.class );

		} catch ( IOException e ) {

			throw new RuntimeException( e );
		}
	}
}