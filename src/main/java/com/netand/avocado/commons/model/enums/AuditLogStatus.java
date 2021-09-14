package com.netand.avocado.commons.model.enums;

import lombok.Getter;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

@Getter
public enum AuditLogStatus implements CodeEnums< Integer > {

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//@formatter:off
	Opened              ( 10 ),
	//------------------------------------------------------------------------------------------------------------------
	Closed              ( 20 ),
	Closed_Timeout      ( 21 ),
	//------------------------------------------------------------------------------------------------------------------
	Creating            ( 30 ),
	Created             ( 31 ),
	CreateFailed        ( 32 ),
	//------------------------------------------------------------------------------------------------------------------
	Deleting            ( 40 ),
	Deleted             ( 41 ),
	DeleteFailed        ( 42 ),
	;
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//@formatter:on

	private static final Map< Integer, AuditLogStatus > INDEX_FOR_CODE = new LinkedHashMap<>();

	private final Integer code;

	AuditLogStatus( Integer code ) {

		this.code = code;
	}

	static {

		Arrays.stream( AuditLogStatus.values() ).forEach( item -> INDEX_FOR_CODE.put( item.getCode(), item ) );
	}

	public static Optional< AuditLogStatus > findByCode( Integer code ) {

		return Optional.ofNullable( INDEX_FOR_CODE.get( code ) );
	}
}