package com.ratingservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.ratingservice.exception.ResourceNotFound;
import com.ratingservice.response.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ResourceNotFound.class)
	public ResponseEntity<ApiResponse> handlerResourceNotFound(ResourceNotFound e){
		String msg = e.getMessage();
		ApiResponse res = new ApiResponse(msg, true);
		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
				.body(res);
				
	}
}
