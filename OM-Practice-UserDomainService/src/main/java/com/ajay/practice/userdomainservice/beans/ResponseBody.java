package com.ajay.practice.userdomainservice.beans;

public class ResponseBody {

private Object response;

	
	public ResponseBody() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ResponseBody(Object response) {
		super();
		this.response = response;
	}

	public Object getResponse() {
		return response;
	}

	public void setResponse(Object response) {
		this.response = response;
	}

	@Override
	public String toString() {
		return "ResponseBody [response=" + response + "]";
	}
}
