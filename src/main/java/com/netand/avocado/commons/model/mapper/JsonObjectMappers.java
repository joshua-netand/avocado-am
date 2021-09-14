package com.netand.avocado.commons.model.mapper;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

public abstract class JsonObjectMappers {

	 public static final ObjectMapper SIMPLE = Jackson2ObjectMapperBuilder.json()
			 .featuresToDisable( SerializationFeature.FAIL_ON_EMPTY_BEANS )
			 .featuresToDisable( SerializationFeature.WRITE_DATES_AS_TIMESTAMPS )
			 .modules( new JavaTimeModule() )
			 .build();
}
