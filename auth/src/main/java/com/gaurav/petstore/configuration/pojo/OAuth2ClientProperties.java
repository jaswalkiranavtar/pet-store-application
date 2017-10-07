package com.gaurav.petstore.configuration.pojo;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix="security.oauth2.client")
public class OAuth2ClientProperties {
	private String clientId;
	private String clientSecret;
	private String[] authorizedGrantTypes;
	private String scope;
	private String[] autoApproveScopes;

	public String getClientId() {
		return clientId;
	}
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	public String getClientSecret() {
		return clientSecret;
	}
	public void setClientSecret(String clientSecret) {
		this.clientSecret = clientSecret;
	}
	public String[] getAuthorizedGrantTypes() {
		return authorizedGrantTypes;
	}
	public void setAuthorizedGrantTypes(String[] authorizedGrantTypes) {
		this.authorizedGrantTypes = authorizedGrantTypes;
	}
	public String getScope() {
		return scope;
	}
	public void setScope(String scope) {
		this.scope = scope;
	}
	public String[] getAutoApproveScopes() {
		return autoApproveScopes;
	}
	public void setAutoApproveScopes(String[] autoApproveScopes) {
		this.autoApproveScopes = autoApproveScopes;
	}
}
