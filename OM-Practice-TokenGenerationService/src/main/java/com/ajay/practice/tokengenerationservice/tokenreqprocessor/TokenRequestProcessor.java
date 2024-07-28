package com.ajay.practice.tokengenerationservice.tokenreqprocessor;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;

import com.ajay.practice.securityconfiglib.beans.UserDetails;
import com.ajay.practice.securityconfiglib.util.JwtUtil;
import com.ajay.practice.tokengenerationservice.beans.ResponseBody;
import com.ajay.practice.tokengenerationservice.beans.TokenRequest;
import com.ajay.practice.tokengenerationservice.helper.RestClient;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.jsonwebtoken.security.InvalidKeyException;
import springfox.documentation.schema.Model;
import springfox.documentation.swagger2.mappers.ModelMapper;
import springfox.documentation.swagger2.mappers.ModelMapperImpl;

@Component
public class TokenRequestProcessor {

	@Autowired
	Environment environment;
	
	@Autowired
	RestClient client;
	@Autowired
	JwtUtil jwtUtil;
	public ResponseBody getToken(TokenRequest request) {
		UserDetails details=new UserDetails();
		details.setUserName(request.getUserName());
		details.setMobileNo(request.getUserMobile());
		String token=null;
		try {
			token=jwtUtil.generateToken(details);
		} catch (InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			throw new RuntimeException("Error Due to token creation");
		}
		return new ResponseBody(token);
	}
	
	public ResponseBody validateToken(String token,String userID) {
		UserDetails details=getUser(userID);
		boolean res=true;
		try {
			res=jwtUtil.validateToken(token, details);
		} catch (InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			throw new RuntimeException("Error Due to token creation");
		}
		return new ResponseBody(res);
	}

	private UserDetails getUser(String userId) {
		String url=environment.getProperty("userservice.getUser");
		ResponseBody res=(ResponseBody)client.executeRestCall(url, HttpMethod.GET, null, null, null, ResponseBody.class, Map.of("userId", userId)).getBody();
		LinkedHashMap<String, Object> resMap=(LinkedHashMap<String, Object>)res.getResponse();
		LinkedHashMap<String, String> resObj=(LinkedHashMap<String, String>) resMap.get("response");
		
		UserDetails details=new UserDetails();
		details.setEmailId(resObj.get("emailId"));
		details.setMobileNo(resObj.get("mobileNo"));
		details.setUserName(resObj.get("userName"));
		return details;
	}
}
