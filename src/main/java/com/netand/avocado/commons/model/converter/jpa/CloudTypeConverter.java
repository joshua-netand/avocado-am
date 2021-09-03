package com.netand.avocado.commons.model.converter.jpa;

import com.netand.avocado.commons.model.enums.CloudTypes;

import javax.persistence.AttributeConverter;

public class CloudTypeConverter implements AttributeConverter< CloudTypes, String > {

	@Override
	public String convertToDatabaseColumn( CloudTypes eventType ) {

		return ( eventType == null ) ? null : eventType.getCode();
	}

	@Override
	public CloudTypes convertToEntityAttribute( String code ) {

		return ( code == null ) ? null : CloudTypes.findByCode( code ).orElse( null );
	}
}