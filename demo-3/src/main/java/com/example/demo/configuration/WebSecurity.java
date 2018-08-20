package com.example.demo.configuration;

import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.example.demo.filter.AuthFilter;
import com.example.demo.filter.LoginFilter;



@Configuration
//@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurity extends WebSecurityConfigurerAdapter{

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		//http.csrf().disable();
		http.exceptionHandling()
			.and()
			.anonymous()
			.and()
			.servletApi()
			.and()
			//.headers().cacheControl()
			//.and()
			.authorizeRequests().antMatchers(HttpMethod.OPTIONS,"/api/auth/login").permitAll()
			.anyRequest().authenticated()
			.and()
			.addFilterBefore(new LoginFilter(new AntPathRequestMatcher("/api/auth/login")), UsernamePasswordAuthenticationFilter.class)
			.addFilterBefore(new AuthFilter(), UsernamePasswordAuthenticationFilter.class); 
	
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		super.configure(auth);
	}

	@Override
	public void configure(org.springframework.security.config.annotation.web.builders.WebSecurity web)
			throws Exception {
		// TODO Auto-generated method stub
		super.configure(web);
	}
	
	

}
