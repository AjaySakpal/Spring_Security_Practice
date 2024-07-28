package com.ajay.practice.userdomainservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ajay.practice.userdomainservice.entity.UserDetails;

public interface UserDetailsService {
	public List<UserDetails> getUsers();
	public UserDetails getUser(int userId);
	
}
