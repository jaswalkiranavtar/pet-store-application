package com.gaurav.petstore.configuration.pojo;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix="user")
public class EndUserCredentials extends UserCredentials {
	
}
