package com.ajay.practice.tokengenerationservice.helper;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Service
public class RestClient {

	private static RestTemplate restTemplate = null;

	public ResponseEntity<?> executeRestCall(String url, HttpMethod method, Object requestObject,
			Map<String, String> queryParams, HttpHeaders headers, Class<?> responseType,
			Map<String, String> pathParams) {
		if (restTemplate == null) {
			restTemplate = new RestTemplate();
		}
		ResponseEntity<?> response = queryParams != null
				? restTemplate.exchange(url, method, new HttpEntity<>(requestObject, headers), responseType,
						queryParams)
				: restTemplate.exchange(getUri(url, pathParams), method, new HttpEntity<>(requestObject, headers),
						responseType);
		return response;
	}

	private URI getUri(String url, Map<String, String> pathParams) {
		URI uri = null;
		if (pathParams != null) {
			for (Map.Entry<String, String> entry : pathParams.entrySet()) {
				url = url.replace("{" + entry.getKey() + "}", entry.getValue());
			}
		}
		try {
			uri = new URI(url);
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return uri;
	}

}
