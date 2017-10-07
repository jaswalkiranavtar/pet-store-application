package com.gaurav.petstore.security;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.context.annotation.Import;

import com.gaurav.petstore.config.MvcConfig;
import com.gaurav.petstore.config.SecurityConfig;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import({SecurityConfig.class, MvcConfig.class})
public @interface EnablePetStoreSecurity {

}
