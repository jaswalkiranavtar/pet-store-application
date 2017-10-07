package com.gaurav.petstore.auth.filter;

import java.util.Base64;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.gaurav.petstore.auth.client.OAuth2ClientProperties;
import com.gaurav.petstore.token.PetStoreAuthenticationToken;

@Component
@EnableConfigurationProperties(OAuth2ClientProperties.class)
public class PetStoreOAuthFilter  extends UsernamePasswordAuthenticationFilter
  {
	
	private static Logger log = LoggerFactory.getLogger(PetStoreOAuthFilter.class);
	
	RestTemplate restTemplate = new RestTemplate();
	
	@Autowired
	OAuth2ClientProperties clientProperties;
	
	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {

		String username = obtainUsername(request);
		String password = obtainPassword(request);
		if (username == null) {
			username = "";
		}
		if (password == null) {
			password = "";
		}
		username = username.trim();
		
		String creds = clientProperties.getClientId() + ":" + clientProperties.getClientSecret();
		String encodedAuth = Base64.getEncoder().encodeToString(creds.getBytes());
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Authorization", "Basic " + encodedAuth);
		HttpEntity<Object> entity = new HttpEntity<Object>(null, httpHeaders);
        String url = clientProperties.getAccessTokenUri() 
        		+ "?grant_type=password&username=" + username 
        		+ "&password=" + password 
        		+ "&scope=" + clientProperties.getScope() 
        		+ "&client_id=" + clientProperties.getClientId();
        
        ResponseEntity<Map> re = null;
        try {
        	re = restTemplate.exchange(url, HttpMethod.POST, entity, Map.class);
        } catch (Exception e) {
			log.info(e.getMessage());
			throw e;
		}

        PetStoreAuthenticationToken token = new PetStoreAuthenticationToken(username, password);
        token.setAccessToken(re.getBody().get("access_token").toString());
        token.setTokenType(re.getBody().get("token_type").toString());
        token.setRefreshToken(re.getBody().get("refresh_token").toString());
        token.setExpiresIn(Long.parseLong(re.getBody().get("expires_in").toString()));
        token.setScope(re.getBody().get("scope").toString());
        setDetails(request, token);
        
		return this.getAuthenticationManager().authenticate(token);
	}
}