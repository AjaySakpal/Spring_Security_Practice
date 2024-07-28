package com.ajay.practice.userdomainservice.service;

import java.util.List;

import com.ajay.practice.userdomainservice.entity.BusinessDetails;

public interface BusinessDetailsService {

	public List<BusinessDetails> getBusinesses();
	public BusinessDetails getBusiness(int userId);
}
