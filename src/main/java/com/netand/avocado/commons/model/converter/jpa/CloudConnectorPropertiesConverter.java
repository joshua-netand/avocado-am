package com.netand.avocado.commons.model.converter.jpa;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.netand.avocado.commons.model.cloud.CloudConnectionProperties;
import com.netand.avocado.commons.model.enums.CloudTypes;
import com.netand.avocado.commons.model.mapper.JsonObjectMappers;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.io.IOException;
import java.util.Map;

@Slf4j
@Converter
public class CloudConnectorPropertiesConverter implements AttributeConverter< CloudConnectionProperties, String > {

	@Override
	public String convertToDatabaseColumn( CloudConnectionProperties attribute ) {

		try {

			return JsonObjectMappers.SIMPLE.writeValueAsString( attribute );

		} catch ( JsonProcessingException e ) {

			log.error( "Fail to serialize as object into Json : {}", attribute, e );
			throw new RuntimeException( e );
		}
	}

	@Override
	public CloudConnectionProperties convertToEntityAttribute( String dbData ) {

		if ( StringUtils.isBlank( dbData ) ) return null;
		if ( dbData.equals( "null" ) ) return null;

		try {

			Map< ?, ? > maps = JsonObjectMappers.SIMPLE.readValue( dbData, Map.class );

			CloudTypes cloudType = CloudTypes.valueOf( ( String ) maps.get( "cloudType" ) );

			return switch ( cloudType ) {
				case AWS -> JsonObjectMappers.SIMPLE.readValue( dbData, CloudConnectionProperties.Aws.class );
				case AZURE -> JsonObjectMappers.SIMPLE.readValue( dbData, CloudConnectionProperties.Azure.class );
				case GCP -> JsonObjectMappers.SIMPLE.readValue( dbData, CloudConnectionProperties.Gcp.class );
				case OCI -> JsonObjectMappers.SIMPLE.readValue( dbData, CloudConnectionProperties.Oci.class );
			};

		} catch ( IOException e ) {

			log.error( "Fail to deserialize as Json into Object : {}", dbData, e );
			throw new RuntimeException( e );
		}
	}
}