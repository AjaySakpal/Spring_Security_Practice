package com.ajay.practice.userdomainservice.util;

import org.springframework.stereotype.Component;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class JsonParsingUtil {

	public String getJsonString(Object obj) {
		ObjectMapper mapper=new ObjectMapper();
		String objStr=null;
		try {
			objStr=mapper.writeValueAsString(obj);
			
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e.getLocalizedMessage());
		}
		return objStr;
	}
}
