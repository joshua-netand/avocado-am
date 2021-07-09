package com.netand.avocado.commons.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.Map;

@Data
@ToString
@RequiredArgsConstructor
public class Tag implements Map.Entry< String, String > {

	private String name;
	private String value;

	public Tag( String name, String value ) {

		this.name = name;
		this.value = value;
	}

	@Override
	public String getKey() {

		return name;
	}

	public void setKey( String key ) {

		this.name = key;
	}

	@Override
	public String setValue( String value ) {

		this.value = value;
		return value;
	}
}
