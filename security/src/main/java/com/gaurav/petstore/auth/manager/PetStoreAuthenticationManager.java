package com.gaurav.petstore.auth.manager;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;

import com.gaurav.petstore.token.PetStoreAuthenticationToken;

public class PetStoreAuthenticationManager implements AuthenticationManager{

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		PetStoreAuthenticationToken token = new PetStoreAuthenticationToken(
				authentication.getPrincipal(), 
				"", 
				authentication.getAuthorities());
		if(authentication instanceof PetStoreAuthenticationToken)
			token.setAccessToken(((PetStoreAuthenticationToken) authentication).getAccessToken());
		SecurityContextHolder.getContext().setAuthentication(token);
		return token;
	}

}
