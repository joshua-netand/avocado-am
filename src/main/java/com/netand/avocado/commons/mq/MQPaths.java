package com.netand.avocado.commons.mq;

public interface MQPaths {

	interface IdentityAndAccessManagement {

		interface Queues {

			interface Request {

				String Auth = "iam-request-auth";
				String Resource = "iam-request-resource";
			}

			interface Response {

				String Auth = "iam-response-to_auth";
				String OpenApi = "iam-response-to_open_api";
			}
		}
	}

	interface PrivilegedAccessManagement {

		interface Queues {

			String Request = "pam-request";
			String Response = "pam-response";
		}
	}

	interface RemoteResourceManagement {

		interface Queues {

			String Request = "rrm-request";
			String Response = "rrm-rpc-response";
		}
	}

	interface CloudAPIGateWay {

		interface Exchange {

			String name = "cloud-api-gw-exchange";

			interface RoutingKey {

				String Connector = "cloud-api-gw.connector";
				String Resource = "cloud-api-gw.resource";
			}
		}
	}

}