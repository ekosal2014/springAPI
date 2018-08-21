package com.example.demo.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.model.User;

@Service("customUserService")
public class CustomUserService implements UserDetailsService {

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
		User user = new User();
		System.out.println("Hello == " + username);
		if (!"admin".equals(username)) {
			throw new UsernameNotFoundException("user name not match.");
		}
		
		user.setPassword("$2a$10$mOzYexnqVmFf374ksgRBCer1Z6RmkdqEevDLRKqDV2ookBHKaX11e");
		user.setUsername("ekosal");
		
		return user;
	}

}
