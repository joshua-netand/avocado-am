package com.netand.avocado.commons.model;

import lombok.Getter;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

@Getter
public enum OperatingSystems implements CodeEnums< Integer > {

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//@formatter:off
	Unknown         ( 0 ),
	LinuxOrUnix     ( 1 ),
	Windows         ( 2 );
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//@formatter:on

	private static final Map< Integer, OperatingSystems > INDEX_FOR_CODE = new LinkedHashMap<>();

	static {

		Arrays.stream( OperatingSystems.values() ).forEach( item -> INDEX_FOR_CODE.put( item.code, item ) );
	}

	private final Integer code;

	OperatingSystems( int code ) {

		this.code = code;
	}

	public static Optional< OperatingSystems > findByCode( int code ) {

		return Optional.ofNullable( INDEX_FOR_CODE.get( code ) );
	}
}
