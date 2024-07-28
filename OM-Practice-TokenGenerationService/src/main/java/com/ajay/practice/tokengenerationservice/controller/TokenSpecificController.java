package com.ajay.practice.tokengenerationservice.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ajay.practice.tokengenerationservice.beans.ResponseBody;
import com.ajay.practice.tokengenerationservice.beans.TokenRequest;
import com.ajay.practice.tokengenerationservice.beans.TokenValidationRequest;
import com.ajay.practice.tokengenerationservice.tokenreqprocessor.TokenRequestProcessor;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.Authorization;

@RestController
@RequestMapping("/token")
public class TokenSpecificController {

	@Autowired
	TokenRequestProcessor processor;
	
	@ApiOperation(value = "Basic API to generate JwtToken")
	@PostMapping("/create")
	public ResponseEntity<ResponseBody> getToken(
			@RequestBody @ApiParam(required = true)
			TokenRequest tokeRequest){
		
		return new ResponseEntity<ResponseBody>(processor.getToken(tokeRequest), HttpStatus.CREATED);
	}
	
	@ApiOperation(value = "Basic API to validate JwtToken")
	@GetMapping("/validate/{userId}")
	public ResponseEntity<ResponseBody> validateToken(@PathVariable String userId,@RequestParam String token){
		
		return new ResponseEntity<ResponseBody>(processor.validateToken(token,userId), HttpStatus.CREATED);
	}
}
