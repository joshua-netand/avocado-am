package com.netand.avocado.commons.model.converter.jpa;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.Arrays;
import java.util.Map;

@Converter
public class JsonMapConverter implements AttributeConverter< Map< String, Object >, String > {

	private static final ObjectMapper objectMapper = Jackson2ObjectMapperBuilder.json()
			.featuresToDisable( SerializationFeature.FAIL_ON_EMPTY_BEANS )
			.featuresToDisable( SerializationFeature.WRITE_DATES_AS_TIMESTAMPS )
			.modules( new JavaTimeModule() )
			.build();

	@Override
	public String convertToDatabaseColumn( Map< String, Object > map ) {

		if ( map == null || map.isEmpty() ) {

			return null;
		}

		try {

			return objectMapper.writeValueAsString( map );

		} catch ( JsonProcessingException e ) {

			throw new RuntimeException( e );
		}
	}

	@Override
	public Map< String, Object > convertToEntityAttribute( String jsonArrayString ) {

		if ( StringUtils.isBlank( jsonArrayString ) ) {

			return null;
		}

		try {

			return objectMapper.readValue( jsonArrayString, Map.class );

		} catch ( JsonProcessingException e ) {

			throw new RuntimeException( e );
		}
	}
}
