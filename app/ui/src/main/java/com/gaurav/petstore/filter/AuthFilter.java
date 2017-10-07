package com.gaurav.petstore.filter;

import com.gaurav.petstore.token.PetStoreAuthenticationToken;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class AuthFilter extends ZuulFilter {
    private static Logger log = LoggerFactory.getLogger(AuthFilter.class);

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return auth != null;
    }

    @Override
    public Object run() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth instanceof PetStoreAuthenticationToken) {
            PetStoreAuthenticationToken token = (PetStoreAuthenticationToken) auth;
            RequestContext.getCurrentContext().addZuulRequestHeader("Authorization", "Bearer " + token.getAccessToken());
            log.debug("Adding authentication token to request");
        }

        return null;
    }
}
