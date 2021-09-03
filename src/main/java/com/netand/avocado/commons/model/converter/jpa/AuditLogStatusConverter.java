package com.netand.avocado.commons.model.converter.jpa;

import com.netand.avocado.commons.model.enums.AuditLogStatus;
import com.netand.avocado.commons.model.enums.ConnectReasonTypes;

import javax.persistence.AttributeConverter;

public class AuditLogStatusConverter implements AttributeConverter< AuditLogStatus, Integer > {

	@Override
	public Integer convertToDatabaseColumn( AuditLogStatus eventType ) {

		return ( eventType == null ) ? null : eventType.getCode();
	}

	@Override
	public AuditLogStatus convertToEntityAttribute( Integer code ) {

		return ( code == null ) ? null : AuditLogStatus.findByCode( code ).orElse( null );
	}
}