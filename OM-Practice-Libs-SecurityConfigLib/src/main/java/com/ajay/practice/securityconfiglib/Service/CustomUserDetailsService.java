package com.ajay.practice.securityconfiglib.Service;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService{

	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		GrantedAuthority authority=new SimpleGrantedAuthority(username.equalsIgnoreCase("ADMIN")?"ROLE_ADMIN": "ROLE_DEV");
		UserDetails details=new User(username, username,Arrays.asList(authority));
		return details;
	}

}
