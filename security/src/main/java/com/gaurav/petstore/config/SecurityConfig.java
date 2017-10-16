package com.gaurav.petstore.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.preauth.AbstractPreAuthenticatedProcessingFilter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import com.gaurav.petstore.auth.filter.PetStoreOAuthFilter;
import com.gaurav.petstore.auth.filter.PetStoreTokenFilter;
import com.gaurav.petstore.auth.manager.PetStoreAuthenticationManager;

import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers("/", "/home").permitAll()
                .antMatchers("/api/v1/data/list-all-pets", "/list-all-pets", "/user").hasAnyRole("ADMIN","USER")
                .antMatchers(HttpMethod.POST, "/api/v1/data/create-a-pet", "/create-a-pet").hasAnyRole("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/api/v1/data/delete-a-pet", "/delete-a-pet").hasAnyRole("ADMIN")
                .anyRequest().authenticated()
                .and()
            .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
            .addFilterBefore(petStoreOAuthFilter(), AbstractPreAuthenticatedProcessingFilter.class)
            .addFilterBefore(petStoreTokenFilter(), BasicAuthenticationFilter.class)
            .logout()
                .permitAll();
        
        http.csrf().disable();
    }

    @Bean
    public PetStoreOAuthFilter petStoreOAuthFilter() {
    	PetStoreOAuthFilter petStoreAuthFilter = new PetStoreOAuthFilter();
    	petStoreAuthFilter.setAuthenticationManager(new PetStoreAuthenticationManager());
    	return petStoreAuthFilter;
    }
    
    @Bean
    public PetStoreTokenFilter petStoreTokenFilter() {
    	PetStoreTokenFilter petStoreTokenFilter = new PetStoreTokenFilter();
    	return petStoreTokenFilter;
    }
    
}
