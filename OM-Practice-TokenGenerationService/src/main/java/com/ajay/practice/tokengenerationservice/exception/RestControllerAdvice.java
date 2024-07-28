package com.ajay.practice.tokengenerationservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.ajay.practice.tokengenerationservice.beans.ErrorResponse;


@ControllerAdvice
public class RestControllerAdvice extends ResponseEntityExceptionHandler{

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponse> getHttpException(Exception ex){
		ErrorResponse errorResponse=new ErrorResponse();
		errorResponse.setErrorCode("500");
		errorResponse.setErrorResponse(ex.getClass().getSimpleName()+" : "+ ex.getLocalizedMessage());
		return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}
