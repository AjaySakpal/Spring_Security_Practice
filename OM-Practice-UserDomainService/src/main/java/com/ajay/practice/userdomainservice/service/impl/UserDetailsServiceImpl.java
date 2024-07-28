package com.ajay.practice.userdomainservice.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.ajay.practice.userdomainservice.entity.UserDetails;
import com.ajay.practice.userdomainservice.repository.UserDetailsRepository;
import com.ajay.practice.userdomainservice.service.UserDetailsService;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserDetailsRepository detailsRepository;

	@Override
	public List<UserDetails> getUsers() {
		
		return detailsRepository.findAll();
	}

	@Override
	public UserDetails getUser(int userId) {

		return detailsRepository.findById(userId).orElseGet(null);
	}

}
