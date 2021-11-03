package com.netand.avocado.commons.mq;

public interface MQNames {

	interface IdentityAndAccessManagement {

		interface Request {

			String Auth = "iam-request-auth";
			String Resource = "iam-request-resource";
		}

		interface Response {

			String Auth = "iam-response-to_auth";
			String OpenApi = "iam-response-to_open_api";
		}
	}

	interface PrivilegedAccessManagement {

		String Request = "pam-request";
		String Response = "pam-response";
	}

	interface RemoteResourceManagement {

		String Request = "rrm-request";
		String Response = "rrm-rpc-response";
	}

	interface CloudAPIGateWay {

		String Exchange = "cloud-api-gw-exchange";

		interface Request {

			String Connector = "cloud_api_gw-request-connector";
			String Resource = "cloud_api_gw-request-resource";
		}
	}
}
