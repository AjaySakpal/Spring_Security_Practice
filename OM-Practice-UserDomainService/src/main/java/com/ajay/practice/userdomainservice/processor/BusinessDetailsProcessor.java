package com.ajay.practice.userdomainservice.processor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ajay.practice.userdomainservice.beans.ResponseBody;
import com.ajay.practice.userdomainservice.entity.BusinessDetails;
import com.ajay.practice.userdomainservice.service.BusinessDetailsService;

@Component
public class BusinessDetailsProcessor {
	
	@Autowired
	BusinessDetailsService businessDetailsService;
	
	public ResponseBody getBusiness() {

		List<BusinessDetails> res=businessDetailsService.getBusinesses();
		return new ResponseBody(res);
	}

	public ResponseBody getBusiness(int userId) {

		BusinessDetails businessDetails= businessDetailsService.getBusiness(userId);
		return new ResponseBody(businessDetails);
	}
}
