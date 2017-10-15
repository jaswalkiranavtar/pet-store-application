package com.gaurav.petstore.pojo;

import java.util.List;

public class User {
	String name;
	String authorities;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthorities() {
		return authorities;
	}
	public void setAuthorities(String authorities) {
		this.authorities = authorities;
	}
	public User(String name, String authorities) {
		super();
		this.name = name;
		this.authorities = authorities;
	}
}
