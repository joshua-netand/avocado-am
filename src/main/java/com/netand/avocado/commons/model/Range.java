package com.netand.avocado.commons.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.apache.commons.lang3.StringUtils;

import java.text.ParseException;

@JsonInclude( JsonInclude.Include.NON_EMPTY )
@Getter
@ToString
public class Range {

	private static final String DEFAULT_UNIT = "elements";

	private final String unit;
	private final long from;
	private final long to;

	@Builder
	public Range( String unit, long from, long to ) {

		if ( from < 0 || to < 0 ) {

			throw new IllegalArgumentException( "The from or to is negative." );
		}

		if ( from > to ) {

			throw new IllegalArgumentException( String.format( "The from value is greater than to value. (from=%s, to=%s)", from, to ) );
		}

		this.unit = StringUtils.isBlank( unit ) ? DEFAULT_UNIT : unit;
		this.from = from;
		this.to = to;
	}

	@JsonIgnore
	public long getOffset() {

		return from;
	}

	@JsonIgnore
	public long getLimit() {

		return to - from + 1;
	}

	@JsonIgnore
	public long getSize() {

		return to - from + 1;
	}

	public static Range parse( String rangeHeader ) throws ParseException {

		String[] tokens = rangeHeader.split( "=" );

		if ( tokens.length != 2 ) {

			throw new ParseException( "Invalid Range header pattern.", -1 );
		}

		String unit = tokens[ 0 ].trim();
		String[] rangeTokens = tokens[ 1 ].split( "-" );

		if ( rangeTokens.length != 2 ) {

			throw new ParseException( "Invalid Range header pattern.", -1 );
		}

		long from = Long.parseLong( rangeTokens[ 0 ].trim() );
		long to = Long.parseLong( rangeTokens[ 1 ].trim() );

		if ( from > to ) {

			String message = String.format( "Incorrect range setting. (from=%s, to=%s)", from, to );
			throw new ParseException( message, -1 );
		}

		return Range.builder()
				.unit( unit )
				.from( from )
				.to( to )
				.build();
	}
}