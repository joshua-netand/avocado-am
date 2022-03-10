package com.netand.avocado.commons.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.netand.avocado.commons.model.converter.json.ApplicationCodeDeserializer;
import com.netand.avocado.commons.model.converter.json.ApplicationCodeSerializer;
import com.netand.avocado.commons.model.enums.ApplicationCodes;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class ActorTag {

	@JsonDeserialize( using = ApplicationCodeDeserializer.class )
	@JsonSerialize( using = ApplicationCodeSerializer.class )
	private final ApplicationCodes applicationCode;

	private final String clientId;

	private final String requestId;

	private final String userUid;

	@Builder
	public ActorTag( ApplicationCodes applicationCode, String clientId, String requestId, String userUid ) {

		this.applicationCode = applicationCode;
		this.clientId = clientId;
		this.requestId = requestId;
		this.userUid = userUid;
	}

}
