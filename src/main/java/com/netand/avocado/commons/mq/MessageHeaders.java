package com.netand.avocado.commons.mq;

public interface MessageHeaders {

	String Behavior = "Behavior";

	interface ActorTag {

		String RequestId = "RequestId";
		String ClientId = "ClientId";
		String UserUid = "UserUid";
	}
}
