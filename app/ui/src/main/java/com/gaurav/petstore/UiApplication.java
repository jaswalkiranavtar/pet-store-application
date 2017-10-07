package com.gaurav.petstore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import com.gaurav.petstore.filter.AuthFilter;
import com.gaurav.petstore.security.EnablePetStoreSecurity;

@EnablePetStoreSecurity
@EnableDiscoveryClient
@SpringBootApplication
@EnableZuulProxy
public class UiApplication {

	public static void main(String[] args) {
		SpringApplication.run(UiApplication.class, args);
	}
	
	@Bean
    public AuthFilter authFilter() {
        return new AuthFilter();
    }
}
