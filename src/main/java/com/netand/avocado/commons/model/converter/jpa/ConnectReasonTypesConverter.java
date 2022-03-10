package com.netand.avocado.commons.model.converter.jpa;

import com.netand.avocado.commons.model.enums.ConnectReasonTypes;

import javax.persistence.AttributeConverter;

public class ConnectReasonTypesConverter implements AttributeConverter< ConnectReasonTypes, Integer > {

	@Override
	public Integer convertToDatabaseColumn( ConnectReasonTypes eventType ) {

		return ( eventType == null ) ? null : eventType.getCode();
	}

	@Override
	public ConnectReasonTypes convertToEntityAttribute( Integer code ) {

		return ( code == null ) ? null : ConnectReasonTypes.findByCode( code ).orElse( null );
	}
}