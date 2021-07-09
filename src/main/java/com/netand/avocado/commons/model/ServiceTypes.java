package com.netand.avocado.commons.model;

import lombok.Getter;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

@Getter
public enum ServiceTypes implements CodeEnums< Integer > {

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//@formatter:off
	SSH     ( 100 ),
	RDP     ( 200 ),
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//@formatter:on
	;

	private static final Map< Integer, ServiceTypes > INDEX_FOR_CODE = new LinkedHashMap<>();

	static {

		Arrays.stream( ServiceTypes.values() ).forEach( item -> INDEX_FOR_CODE.put( item.code, item ) );
	}

	private final Integer code;

	ServiceTypes( int code ) {

		this.code = code;
	}

	public static Optional< ServiceTypes > findByCode( int code ) {

		return Optional.ofNullable( INDEX_FOR_CODE.get( code ) );
	}
}