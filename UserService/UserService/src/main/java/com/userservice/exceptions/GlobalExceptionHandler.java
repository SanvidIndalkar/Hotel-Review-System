package com.userservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.userservice.response.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ResourceNotFound.class)
	public ResponseEntity<ApiResponse> handlerResourceNotFound(ResourceNotFound e){
		String msg = e.getMessage();
		ApiResponse res = ApiResponse.builder().message(msg).status(true).build();
		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
				.body(res);
				
	}
}
