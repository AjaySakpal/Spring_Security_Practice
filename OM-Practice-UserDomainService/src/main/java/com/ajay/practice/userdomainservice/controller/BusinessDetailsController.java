package com.ajay.practice.userdomainservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ajay.practice.userdomainservice.beans.ResponseBody;
import com.ajay.practice.userdomainservice.processor.BusinessDetailsProcessor;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/business")
public class BusinessDetailsController {

	@Autowired
	BusinessDetailsProcessor businessDetailsProcessor;
	@ApiOperation(value = "Basic API to get business")
	@GetMapping("/get/{userId}")
	public ResponseEntity<ResponseBody> getBusiness(@PathVariable String userId){
		return new ResponseEntity<ResponseBody>(businessDetailsProcessor.getBusiness(Integer.valueOf(userId)), HttpStatus.OK);
	}
	
	@ApiOperation(value = "Basic API to get business")
	@GetMapping("/get")
	public ResponseEntity<ResponseBody> getBusiness(){
		return new ResponseEntity<ResponseBody>(businessDetailsProcessor.getBusiness(), HttpStatus.OK);
	}	
}
