package com.ajay.practice.userdomainservice.processor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ajay.practice.userdomainservice.beans.ResponseBody;
import com.ajay.practice.userdomainservice.entity.UserDetails;
import com.ajay.practice.userdomainservice.service.UserDetailsService;
import com.ajay.practice.userdomainservice.util.JsonParsingUtil;

@Component
public class UserDetailsProcessor {

	@Autowired
	private UserDetailsService detailsService;
	
	@Autowired
	private JsonParsingUtil jsonParsingUtil;
	public ResponseBody getUsers() {
		List<UserDetails>users=detailsService.getUsers();
		return new ResponseBody(users);
	}

	public ResponseBody getUser(int userId) {
		UserDetails user=detailsService.getUser(userId);
		return new ResponseBody(user);
	}

}
