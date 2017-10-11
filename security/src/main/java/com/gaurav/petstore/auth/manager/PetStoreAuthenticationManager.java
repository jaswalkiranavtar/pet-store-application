package com.gaurav.petstore.auth.manager;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

import com.gaurav.petstore.token.PetStoreAuthenticationToken;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

public class PetStoreAuthenticationManager implements AuthenticationManager{

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		PetStoreAuthenticationToken token = null;
		if(authentication instanceof PetStoreAuthenticationToken && ((PetStoreAuthenticationToken) authentication).getAccessToken()!=null) {
			Jws<Claims> jws = null;
			try {

			    jws = Jwts.parser()
				.setSigningKey("123".getBytes("UTF-8"))
				.parseClaimsJws(((PetStoreAuthenticationToken) authentication).getAccessToken());


			    //OK, we can trust this JWT
			} catch (SignatureException e) {
				e.printStackTrace();
			    //don't trust the JWT!
			} catch (ExpiredJwtException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (UnsupportedJwtException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (MalformedJwtException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			List<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
			authorities.add(new SimpleGrantedAuthority(((List)jws.getBody().get("authorities")).get(0).toString()));
			token = new PetStoreAuthenticationToken(authentication.getPrincipal(), "", authorities);
			token.setAccessToken(((PetStoreAuthenticationToken) authentication).getAccessToken());
			
		}
			
		SecurityContextHolder.getContext().setAuthentication(token);
		return token;
	}

}
