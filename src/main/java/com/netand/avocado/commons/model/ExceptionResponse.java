package com.netand.avocado.commons.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Builder;
import lombok.Getter;
import lombok.Singular;
import lombok.ToString;

import java.util.Map;

@Getter
@ToString
@JsonInclude( JsonInclude.Include.NON_EMPTY )
@JsonPropertyOrder( {
		"code",
		"format",
		"message",
		"status",
		"attributes"
} )
public class ExceptionResponse {

	@JsonIgnore
	private final String prefix;
	@JsonIgnore
	private final int serialNumber;
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

		this.prefix = prefix;
		this.serialNumber = serialNumber;
		this.format = format;
		this.message = message;
		this.status = status;
		this.attributes = attributes;
	}

	public String getCode() {

		return String.format( "%s::%s", prefix, serialNumber );
	}
}