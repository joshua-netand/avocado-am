package com.netand.avocado.commons.model.enums;

import lombok.Getter;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

@Getter
public enum ConnectReasonTypes implements CodeEnums< Integer > {

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//@formatter:off
	// 0 : 기타
	ETC                     ( 0 ),
	// 1 : 점검
	Overhaul                ( 1 ),
	// 2 : 모니터링
	Monitoring              ( 2 ),
	// 3 : 애플리케이션 재시작
	ApplicationRestart      ( 3 ),
	// 4 : 설정 변경
	UpdateConfigurations    ( 4 ),
	;
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//@formatter:on

	private static final Map< Integer, ConnectReasonTypes > INDEX_FOR_CODE = new LinkedHashMap<>();

	static {

		Arrays.stream( ConnectReasonTypes.values() ).forEach( item -> INDEX_FOR_CODE.put( item.code, item ) );
	}

	private final Integer code;

	ConnectReasonTypes( int code ) {

		this.code = code;
	}

	public static Optional< ConnectReasonTypes > findByCode( int code ) {

		return Optional.ofNullable( INDEX_FOR_CODE.get( code ) );
	}
}
