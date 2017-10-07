package com.gaurav.petstore.controller;

import java.security.Principal;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gaurav.petstore.pojo.PetStoreData;

@RestController
public class Controller {
	
//	@PreAuthorize("#oauth2.hasScope('read')")
    @GetMapping("/data")
    public PetStoreData data() {
        return new PetStoreData(1, "Gaurav");
    }
    
}
