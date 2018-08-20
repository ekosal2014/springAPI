package com.example.demo.model;

import java.util.Collection;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

public class UserAuthentication  implements Authentication{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private User user;
	private boolean authentication;
	private Info info;
	private String ipAddress;
	private String token;
	//private AuthTy

	public UserAuthentication(User user) {
		this.user = user;
		this.info = new Info();
	}
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return user.getUsername();
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return user.getAuthorities();
	}

	@Override
	public Object getCredentials() {
		// TODO Auto-generated method stub
		return user.getPassword();
	}

	@Override
	public Object getDetails() {
		// TODO Auto-generated method stub
		return user;
	}

	@Override
	public Object getPrincipal() {
		// TODO Auto-generated method stub
		return user.getUsername();
	}

	@Override
	public boolean isAuthenticated() {
		// TODO Auto-generated method stub
		return this.authentication;
	}

	@Override
	public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		this.authentication = isAuthenticated;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public boolean isAuthentication() {
		return authentication;
	}

	public void setAuthentication(boolean authentication) {
		this.authentication = authentication;
	}

	public Info getInfo() {
		return info;
	}

	public void setInfo(Info info) {
		this.info = info;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	
	

}
