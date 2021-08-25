package com.netand.avocado.commons.model.converter.jpa;

import com.netand.avocado.commons.enums.ApplicationCodes;
import com.netand.avocado.commons.model.CloudTypes;

import javax.persistence.AttributeConverter;

public class ApplicationCodeConverter implements AttributeConverter< ApplicationCodes, String > {

	@Override
	public String convertToDatabaseColumn( ApplicationCodes eventType ) {

		return ( eventType == null ) ? null : eventType.getCode();
	}

	@Override
	public ApplicationCodes convertToEntityAttribute( String code ) {

		return ( code == null ) ? null : ApplicationCodes.findByCode( code ).orElse( null );
	}
}