package com.ajay.practice.userdomainservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ajay.practice.userdomainservice.beans.ResponseBody;
import com.ajay.practice.userdomainservice.processor.UserDetailsProcessor;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserDetailsProcessor detailsProcessor;
	@ApiOperation(value = "Basic API to get user")
	@GetMapping("/get")
	public ResponseEntity<ResponseBody> getUsers(){
		ResponseBody res= new ResponseBody(detailsProcessor.getUsers());
		return new ResponseEntity<ResponseBody>(res, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Basic API to get users")
	@GetMapping("/get/{userId}")
	public ResponseEntity<ResponseBody> getUsers(@PathVariable String userId){
		ResponseBody res= new ResponseBody(detailsProcessor.getUser(Integer.valueOf(userId)));
		return new ResponseEntity<ResponseBody>(res, HttpStatus.OK);
	}
}
