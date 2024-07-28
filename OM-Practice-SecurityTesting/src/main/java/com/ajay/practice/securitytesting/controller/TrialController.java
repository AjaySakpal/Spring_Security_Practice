package com.ajay.practice.securitytesting.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/trial")
public class TrialController {

	@ApiOperation(value = "Basic API to verify security")
	@ApiImplicitParam(name = "authtoken", value = "AuthToken", required = true, paramType = "header", dataType = "String", example = "Auth - accessToken")
	@GetMapping("/dev")
	@Secured("ROLE_DEV")
	public ResponseEntity<String> getDevResp(){
		return new ResponseEntity<String>("DEV Login", HttpStatus.OK);
	}
	
	@ApiOperation(value = "Basic API to verify security")
	@ApiImplicitParam(name = "authtoken", value = "AuthToken", required = true, paramType = "header", dataType = "String", example = "Auth - accessToken")
	@GetMapping("/admin")
	@Secured("ROLE_ADMIN")
	public ResponseEntity<String> getAdminResp(){
		return new ResponseEntity<String>("Admin Login", HttpStatus.OK);
	}
}
