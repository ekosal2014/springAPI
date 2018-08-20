package com.example.demo.services.impl;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.UserAuthentication;
import com.example.demo.model.UserToken;
import com.example.demo.services.TokenAuthenticationService;

@Service
@Transactional
public class TokenAuthenticationServiceImpl implements TokenAuthenticationService {

	@Override
	public Authentication getAuthenticationForLogin(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {
		// TODO Auto-generated method stub
		UserAuthentication auth = new UserAuthentication(null);
		return auth;
		
	}

	@Override
	public Authentication getAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		// TODO Auto-generated method stub
		UserAuthentication auth = new UserAuthentication(null);
		return auth;
	}

	@Override
	public UserToken addAuthentication(HttpServletResponse response, UserAuthentication userResutl) {
		// TODO Auto-generated method stub
		UserToken utoken = new UserToken();
		return utoken;
	}

}
