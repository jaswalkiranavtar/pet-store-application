package com.gaurav.petstore.configuration.pojo;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix="admin")
public class AdminUserCredentials extends UserCredentials {
	
}
