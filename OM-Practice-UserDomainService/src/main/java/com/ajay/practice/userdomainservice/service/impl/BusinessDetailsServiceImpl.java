package com.ajay.practice.userdomainservice.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ajay.practice.userdomainservice.entity.BusinessDetails;
import com.ajay.practice.userdomainservice.repository.BusinessDetailsRepository;
import com.ajay.practice.userdomainservice.repository.UserDetailsRepository;
import com.ajay.practice.userdomainservice.service.BusinessDetailsService;

@Service
public class BusinessDetailsServiceImpl implements BusinessDetailsService {

	@Autowired
	BusinessDetailsRepository businessDetailsRepository;
	
	@Override
	public List<BusinessDetails> getBusinesses() {

		return businessDetailsRepository.findAll();
	}

	@Override
	public BusinessDetails getBusiness(int userId) {

		return businessDetailsRepository.findByUserId(userId).get(0);
	}

}
