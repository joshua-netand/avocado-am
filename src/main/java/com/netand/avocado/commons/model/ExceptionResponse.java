package com.netand.avocado.commons.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Singular;
import lombok.ToString;

import javax.xml.transform.Result;
import java.util.Map;

@Getter
@ToString
public class ExceptionResponse {

	private final String code;
	private final String format;
	private final String message;
	private final ResultStatus status;
	private final Map< String, Object > attributes;

	@Builder
	public ExceptionResponse( String prefix,
	                          int serialNumber,
	                          String format,
	                          String message,
	                          ResultStatus status,
	                          @Singular Map< String, Object > attributes ) {

		this.code = String.format( "%s::%s", prefix, serialNumber );
		this.format = format;
		this.message = message;
		this.status = status;
		this.attributes = attributes;
	}
}