package com.gaurav.petstore.auth.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import com.gaurav.petstore.auth.manager.PetStoreAuthenticationManager;
import com.gaurav.petstore.token.PetStoreAuthenticationToken;

@Component
public class PetStoreTokenFilter extends GenericFilterBean
  {
	
	PetStoreAuthenticationManager authenticationManager = new PetStoreAuthenticationManager();
	
	private static Logger log = LoggerFactory.getLogger(PetStoreTokenFilter.class);

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		final HttpServletRequest httpRequest = (HttpServletRequest)request;
        final String accessToken = httpRequest.getHeader("Authorization");
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication!=null) {
        	this.authenticationManager.authenticate(authentication);
        }
        if (null != accessToken) {
                PetStoreAuthenticationToken authentication1 = new PetStoreAuthenticationToken();
                authentication1.setAccessToken(accessToken);
               	SecurityContextHolder.getContext().setAuthentication(this.authenticationManager.authenticate(authentication1));

       }

       chain.doFilter(request, response);
	}
	
	

}