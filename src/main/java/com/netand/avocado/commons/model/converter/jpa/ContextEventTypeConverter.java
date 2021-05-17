package com.netand.avocado.commons.model.converter.jpa;

import com.netand.avocado.commons.model.ContextEventTypes;

import javax.persistence.AttributeConverter;

public class ContextEventTypeConverter implements AttributeConverter< ContextEventTypes, Integer > {

	@Override
	public Integer convertToDatabaseColumn( ContextEventTypes eventType ) {

		return ( eventType == null ) ? null : eventType.getCode();
	}

	@Override
	public ContextEventTypes convertToEntityAttribute( Integer code ) {

		return ( code == null ) ? null : ContextEventTypes.findByCode( code ).orElse( null );
	}
}
