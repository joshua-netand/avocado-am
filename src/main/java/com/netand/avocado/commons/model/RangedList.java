package com.netand.avocado.commons.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.*;
import lombok.experimental.Delegate;

import java.util.List;

@ToString
@JsonInclude( JsonInclude.Include.NON_EMPTY )
@JsonPropertyOrder( { "elements", "range", "totalElements" } )
public class RangedList< E > {

	@Getter
	private final Range range;

	@Getter
	private final List< E > elements;

	@Getter
	@Setter
	private Long totalElements;

	@Builder
	public RangedList( Range range, @Singular( "element" ) List< E > elements, Long totalElements ) {

		this.range = range;
		this.elements = elements;
		this.totalElements = totalElements;
	}
}
