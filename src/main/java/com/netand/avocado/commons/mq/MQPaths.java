package com.netand.avocado.commons.mq;

public interface MQPaths {

	String AVOCADO_EXCHANGE = "avocado_exchange";

	interface IdentityAndAccessManagement {

		String Prefix               = "iam";

		interface Verify {

			String Queue            = Prefix + "_verify_queue";
			String RoutingKey       = Prefix + ".verify.*";
		}

		interface Resource {

			String Queue            = Prefix + "_resource_queue";
			String RoutingKey       = Prefix + ".resource.*";              // ex) iam.resource.client, iam.resource.user, iam.resource.policy
		}
	}

	interface AuthorizationManagement {

		String Prefix           = "auth";

		String Queue            = Prefix + "_response_queue";
		String RoutingKey       = Prefix + ".response.*";
	}

	interface OpenApiManagement {

		String Prefix           = "openAPi";

		String Queue            = Prefix + "_response_queue";
		String RoutingKey       = Prefix + ".response.*";
	}

	interface PrivilegedAccessManagement {

		String Prefix               = "pam";

		interface Resource {

			String Queue            = Prefix + "_resource_queue";
			String RoutingKey       = Prefix + ".resource.*";
		}

		interface Role {

			String Queue            = Prefix + "_role_queue";
			String RoutingKey       = Prefix + ".role.*";
		}
	}

	interface RemoteResourceManagement {

		String Prefix               = "rrm";

		interface Resource {

			String Queue            = Prefix + "_resource_queue";
			String RoutingKey       = Prefix + ".resource.*";
		}

		interface Response {

			String Queue            = Prefix + "_response_queue";
			String RoutingKey       = Prefix + ".response.*";
		}
	}

	interface CloudApiGateWay {

		String Prefix               = "cloud";

		interface Connector {

			String Queue            = Prefix + "_connector_queue";
			String RoutingKey       = Prefix + ".connector.*";
		}

		interface Resource {

			String Queue            = Prefix + "_resource_queue";
			String RoutingKey       = Prefix + ".resource.*";
		}
	}
}