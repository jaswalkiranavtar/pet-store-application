package com.gaurav.petstore.controller;

import java.security.Principal;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gaurav.petstore.pojo.User;
import com.gaurav.petstore.token.PetStoreAuthenticationToken;

@RestController
public class Controller {

	@GetMapping("/user")
	public User user(Principal user) {
		PetStoreAuthenticationToken token = (PetStoreAuthenticationToken)user;
		return new User(token.getPrincipal().toString(), token.getAuthorities().toString());
    }
	
//	@GetMapping("/admin")
//	public Principal admin(Principal user) {
//    	Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//		return user;
//	}
}
