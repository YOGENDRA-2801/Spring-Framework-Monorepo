package com.yoy.basicwebform.entity;

import org.springframework.stereotype.Component;

@Component
public class User 
{
	private String name ;
	private String email ;
	private String mobile ;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}	
}
