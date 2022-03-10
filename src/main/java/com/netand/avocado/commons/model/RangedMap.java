package com.netand.avocado.commons.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.*;

import java.util.Map;

@ToString
@JsonInclude( JsonInclude.Include.NON_EMPTY )
@JsonPropertyOrder( { "elements", "range", "totalElements" } )
public class RangedMap< K, V > {

	@Getter
	private final Range range;

	@Getter
	private final Map< K, V > elements;

	@Getter
	@Setter
	private Long totalElements;

	@Builder
	public RangedMap( Range range, @Singular( "element" ) Map< K, V > elements, Long totalElements ) {

		this.range = range;
		this.elements = elements;
		this.totalElements = totalElements;
	}
}
