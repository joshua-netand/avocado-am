package com.netand.avocado.commons;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

public interface Consts {

	ObjectMapper JSON_OBJECT_MAPPER = Jackson2ObjectMapperBuilder.json()
			.featuresToDisable( SerializationFeature.FAIL_ON_EMPTY_BEANS )
			.featuresToDisable( SerializationFeature.WRITE_DATES_AS_TIMESTAMPS )
			.modules( new JavaTimeModule() )
			.build();

}