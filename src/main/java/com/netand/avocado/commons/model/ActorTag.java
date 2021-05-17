package com.netand.avocado.commons.model;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class ActorTag {

	private final String applicationId;

	private final String clientId;

	private final String requestId;

	private final String userUid;

	@Builder
	public ActorTag( String applicationId, String clientId, String requestId, String userUid ) {

		this.applicationId = applicationId;
		this.clientId = clientId;
		this.requestId = requestId;
		this.userUid = userUid;
	}
}
