package com.netand.avocado.commons.enums;

import lombok.Getter;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

@Getter
public enum ApplicationCodes {

	//@formatter:off
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	OPEN_API        ( "open-api",           "Open API Server" ),
	IAM             ( "iam",                "Identity Access Management" ),
	PAM             ( "pam",                "Privileged Access Management" ),
	ADMIN           ( "admin",              "Administrator Server" ),
	BASTION         ( "bastion",            "Bastion" ),
	API_GW          ( "api-gw",             "API Gateway" ),
	;

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//@formatter:on

	private static final Map< String, ApplicationCodes > INDEX_FOR_CODE = new LinkedHashMap<>();

	static {

		Arrays.stream( ApplicationCodes.values() ).forEach( item -> {

					INDEX_FOR_CODE.put( item.code, item );
				}
		);
	}

	private String code;
	private String description;

	ApplicationCodes( String code, String description ) {

		this.code = code;
		this.description = description;
	}

	public static Optional< ApplicationCodes > findByCode( String code ) {

		return Optional.ofNullable( INDEX_FOR_CODE.get( code ) );
	}
}
