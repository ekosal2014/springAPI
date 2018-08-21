package com.example.demo.model;

import org.springframework.security.core.GrantedAuthority;

public class Role implements GrantedAuthority{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String role_name;
	
	
	@Override
	public String getAuthority() {
		// TODO Auto-generated method stub
		return this.role_name;
	}


	public String getRole_name() {
		return role_name;
	}


	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}
	
	

	

}
