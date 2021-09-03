package com.netand.avocado.commons.model.enums;

import lombok.Getter;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

@Getter
public enum ContextEventTypes implements EventTypes {

	//@formatter:off
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	Writing     ( 10 ),
	Submit      ( 11 ),
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	Approving   ( 20 ),
	Approved    ( 21 ),
	Rejected    ( 22 ),
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	Created     ( 30 ),
	Updated     ( 31 ),
	Deleted     ( 32 ),
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	Granted     ( 40 ),
	Revoked     ( 41 ),
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//@formatter:on
	;

	private static final Map< Integer, ContextEventTypes > INDEX_FOR_CODE = new LinkedHashMap<>();
	private final Integer code;

	static {

		Arrays.stream( ContextEventTypes.values() ).forEach( item -> INDEX_FOR_CODE.put( item.getCode(), item ) );
	}

	ContextEventTypes( int code ) {

		this.code = code;
	}

	public static Optional< ContextEventTypes > findByCode( int code ) {

		return Optional.ofNullable( INDEX_FOR_CODE.get( code ) );
	}
}
