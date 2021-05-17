package com.netand.avocado.commons.databind.jackson;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public interface ZonedDateTimeDeserializer {

	class Timestamp extends JsonDeserializer< ZonedDateTime > {

		private static final String FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSSZ";
		private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern( FORMAT );

		@Override
		public ZonedDateTime deserialize( JsonParser p, DeserializationContext ctxt ) throws IOException {

			return ZonedDateTime.from( FORMATTER.parse( p.getText() ) );
		}
	}
}


