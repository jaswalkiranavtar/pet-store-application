package com.gaurav.petstore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

import com.gaurav.petstore.security.EnablePetStoreSecurity;

@EnablePetStoreSecurity
@EnableDiscoveryClient
@SpringBootApplication
public class DataApplication {

	public static void main(String[] args) {
		SpringApplication.run(DataApplication.class, args);
	}
	
}
