package com.example.demo.filter;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.RequestMatcher;

import com.example.demo.common.ApplicationContextProvider;
import com.example.demo.model.UserAuthentication;
import com.example.demo.services.TokenAuthenticationService;


public class LoginFilter extends AbstractAuthenticationProcessingFilter{

	@Autowired
	@Qualifier("tokenAuthenticationServiceImpl")
	private TokenAuthenticationService tokenAuthenticationService;
	
	public LoginFilter(RequestMatcher requiresAuthenticationRequestMatcher) {
		super(requiresAuthenticationRequestMatcher);
		// TODO Auto-generated constructor stub
		tokenAuthenticationService = (TokenAuthenticationService) ApplicationContextProvider.getApplicationContext()
				.getBean("tokenAuthenticationServiceImpl");
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException, IOException, ServletException {
		// TODO Auto-generated method stub
		UserAuthentication auth = new UserAuthentication(null);
		return auth;
	}

}
