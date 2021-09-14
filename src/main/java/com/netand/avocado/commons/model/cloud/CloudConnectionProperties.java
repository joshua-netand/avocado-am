package com.netand.avocado.commons.model.cloud;

import com.netand.avocado.commons.model.enums.CloudTypes;
import lombok.*;

@Data
@EqualsAndHashCode
@RequiredArgsConstructor
@ToString
public abstract class CloudConnectionProperties {

	protected CloudTypes cloudType;

	public CloudConnectionProperties( CloudTypes cloudType ) {

		this.cloudType = cloudType;
	}

	@Data
	@EqualsAndHashCode( callSuper = true )
	@ToString
	public static class Aws extends CloudConnectionProperties {

		private String accessKey;
		private String secretKey;
		private String region;

		public Aws() {

			super( CloudTypes.AWS );
		}

		@Builder
		public Aws( String accessKey, String secretKey, String region ) {

			super( CloudTypes.AWS );

			this.accessKey = accessKey;
			this.secretKey = secretKey;
			this.region = region;
		}
	}

	@Data
	@EqualsAndHashCode( callSuper = true )
	@ToString
	public static class Azure extends CloudConnectionProperties {

		private String clientId;
		private String domain;
		private String secret;
		private String region;

		public Azure() {

			super( CloudTypes.AZURE );
		}

		public Azure( String clientId, String domain, String secret, String region ) {

			super( CloudTypes.AZURE );

			this.clientId = clientId;
			this.domain = domain;
			this.secret = secret;
			this.region = region;
		}
	}

	@Data
	@EqualsAndHashCode( callSuper = true )
	@ToString
	public static class Gcp extends CloudConnectionProperties {

		private String type;
		private String projectId;
		private String privateKeyId;
		private String privateKey;
		private String clientEmail;
		private String clientId;
		private String authUri;
		private String tokenUri;
		private String authProviderX509CertUrl;
		private String clientX509CertUrl;
		private String region;

		public Gcp() {

			super( CloudTypes.GCP );
		}

		public Gcp( String type,
		            String projectId,
		            String privateKeyId,
		            String privateKey,
		            String clientEmail,
		            String clientId,
		            String authUri,
		            String tokenUri,
		            String authProviderX509CertUrl,
		            String clientX509CertUrl,
		            String region ) {

			super( CloudTypes.GCP );

			this.type = type;
			this.projectId = projectId;
			this.privateKeyId = privateKeyId;
			this.privateKey = privateKey;
			this.clientEmail = clientEmail;
			this.clientId = clientId;
			this.authUri = authUri;
			this.tokenUri = tokenUri;
			this.authProviderX509CertUrl = authProviderX509CertUrl;
			this.clientX509CertUrl = clientX509CertUrl;
			this.region = region;
		}
	}

	@Data
	@EqualsAndHashCode( callSuper = true )
	@ToString
	public static class Oci extends CloudConnectionProperties {

		private String tenancyId;
		private String privateKey;
		private String tenantId;
		private String userId;
		private String fingerPrint;
		private String region;

		public Oci() {

			super( CloudTypes.OCI );
		}

		public Oci( String tenancyId, String privateKey, String tenantId, String userId, String fingerPrint, String region ) {

			super( CloudTypes.OCI );

			this.tenancyId = tenancyId;
			this.privateKey = privateKey;
			this.tenantId = tenantId;
			this.userId = userId;
			this.fingerPrint = fingerPrint;
			this.region = region;
		}
	}
}
