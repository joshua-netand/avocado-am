package com.netand.avocado.commons.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Singular;
import lombok.ToString;

import java.util.Map;

@Getter
@ToString
public class ExceptionResponse {

	private final String prefix;
	private final int serialNumber;
	private final String format;
	private final String message;
	private final Map< String, Object > attributes;

	@Builder
	public ExceptionResponse( String prefix,
	                          int serialNumber,
	                          String format,
	                          String message,
	                          @Singular Map< String, Object > attributes ) {

		this.prefix = prefix;
		this.serialNumber = serialNumber;
		this.format = format;
		this.message = message;
		this.attributes = attributes;
	}
}