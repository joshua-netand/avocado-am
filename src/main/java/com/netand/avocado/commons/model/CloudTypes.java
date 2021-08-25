package com.netand.avocado.commons.model;

import lombok.Getter;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

@Getter
public enum CloudTypes {

	//@formatter:off
	AWS         ( "AWS", "Amazon Web Service" ),
	AZURE       ( "AZU", "Microsoft Azure" ),
	GCP         ( "GCP", "Google Cloud Platform" ),
	OCI         ( "OCI", "Oracle Cloud Infrastructure" ),
	;
	//@formatter:on

	private static final Map< String, CloudTypes > INDEX_FOR_CODE = new LinkedHashMap<>();

	private String code;
	private String description;

	CloudTypes( String code, String description ) {

		this.code = code;
		this.description = description;
	}

	static {

		Arrays.stream( CloudTypes.values() ).forEach( item -> INDEX_FOR_CODE.put( item.getCode(), item ) );
	}

	public static Optional< CloudTypes > findByCode( String code ) {

		return Optional.ofNullable( INDEX_FOR_CODE.get( code ) );
	}
}