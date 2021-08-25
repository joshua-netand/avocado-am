package com.netand.avocado.commons.model;

import com.netand.avocado.commons.enums.ApplicationCodes;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class ActorTag {

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
