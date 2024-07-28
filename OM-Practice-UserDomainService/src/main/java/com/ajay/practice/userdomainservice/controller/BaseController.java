package com.ajay.practice.userdomainservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ajay.practice.userdomainservice.util.UserDomainConstants;

import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping("/base")
public class BaseController {

	@Autowired
	Environment environment;
	
	@ApiOperation(value = "Basic API to check the server")
	@GetMapping("/hello")
	public ResponseEntity<String> getHello(){
		return new ResponseEntity<String>("Hello World from "+environment.getProperty(UserDomainConstants.SERVICE_NAME), HttpStatus.OK);
	}
	
}
