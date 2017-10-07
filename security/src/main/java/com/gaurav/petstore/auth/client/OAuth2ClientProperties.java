package com.gaurav.petstore.auth.client;

import java.util.Set;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix="security.oauth2.client")
public class OAuth2ClientProperties {
	private String clientId;
	private String clientSecret;
	private Set<String> authorizedGrantTypes;
	private String scope;
	private Set<String> autoApproveScopes;
	private String accessTokenUri;
	private String userAuthorizationUri;
	private String tokenInfoUri;
	
	
	public String getAccessTokenUri() {
		return accessTokenUri;
	}
	public void setAccessTokenUri(String accessTokenUri) {
		this.accessTokenUri = accessTokenUri;
	}
	public String getUserAuthorizationUri() {
		return userAuthorizationUri;
	}
	public void setUserAuthorizationUri(String userAuthorizationUri) {
		this.userAuthorizationUri = userAuthorizationUri;
	}
	public String getTokenInfoUri() {
		return tokenInfoUri;
	}
	public void setTokenInfoUri(String tokenInfoUri) {
		this.tokenInfoUri = tokenInfoUri;
	}
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
	public Set<String> getAuthorizedGrantTypes() {
		return authorizedGrantTypes;
	}
	public void setAuthorizedGrantTypes(Set<String> authorizedGrantTypes) {
		this.authorizedGrantTypes = authorizedGrantTypes;
	}
	public String getScope() {
		return scope;
	}
	public void setScope(String scope) {
		this.scope = scope;
	}
	public Set<String> getAutoApproveScopes() {
		return autoApproveScopes;
	}
	public void setAutoApproveScopes(Set<String> autoApproveScopes) {
		this.autoApproveScopes = autoApproveScopes;
	}
}
