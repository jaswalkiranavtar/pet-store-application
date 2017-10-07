package com.gaurav.petstore.controller;

import java.security.Principal;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

	@GetMapping("/user")
	public Principal user(Principal user) {
    	Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		return user;
	}
}
