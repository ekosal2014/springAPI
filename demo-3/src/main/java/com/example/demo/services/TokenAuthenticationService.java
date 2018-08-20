package com.example.demo.services;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

import com.example.demo.model.UserAuthentication;
import com.example.demo.model.UserToken;

public interface TokenAuthenticationService {
	
	public Authentication getAuthenticationForLogin(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException;
	public Authentication getAuthentication(HttpServletRequest request, HttpServletResponse response) throws IOException;
	
	public UserToken addAuthentication(HttpServletResponse response, UserAuthentication userResutl);

}
