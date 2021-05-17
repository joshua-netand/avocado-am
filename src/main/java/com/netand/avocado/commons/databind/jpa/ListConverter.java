package com.netand.avocado.commons.databind.jpa;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.persistence.AttributeConverter;
import java.io.IOException;
import java.util.List;

public class ListConverter implements AttributeConverter< List< String >, String > {

	private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

	@Override
	public String convertToDatabaseColumn( List< String > list ) {

		if ( list == null ) {

			return null;
		}

		try {

			return OBJECT_MAPPER.writeValueAsString( list );

		} catch ( JsonProcessingException e ) {

			throw new RuntimeException( e );
		}
	}

	@Override
	@SuppressWarnings( "unchecked" )
	public List< String > convertToEntityAttribute( String json ) {

		try {

			return OBJECT_MAPPER.readValue( json, List.class );

		} catch ( IOException e ) {

			throw new RuntimeException( e );
		}
	}
}