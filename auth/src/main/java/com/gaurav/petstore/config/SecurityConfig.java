package com.gaurav.petstore.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.gaurav.petstore.configuration.pojo.AdminUserCredentials;
import com.gaurav.petstore.configuration.pojo.EndUserCredentials;

@Configuration
@EnableConfigurationProperties({AdminUserCredentials.class, EndUserCredentials.class})
public class SecurityConfig extends WebSecurityConfigurerAdapter  {
	
	@Autowired
	AdminUserCredentials admin;
	
	@Autowired
	EndUserCredentials user;
	
	@Autowired
    public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
        auth
        	.inMemoryAuthentication()
        	.withUser(admin.getName())
        	.password(admin.getPassword())
        	.roles(admin.getRole(), "ACTUATOR");
        
        auth
        	.inMemoryAuthentication()
        	.withUser(user.getName())
        	.password(user.getPassword())
        	.roles(user.getRole());
        
    }

}
