package com.hotelservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.hotelservice.dto.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ResourceNotFound.class)
	private ResponseEntity<ApiResponse> handleResourceNotFound(ResourceNotFound ex){
		ApiResponse res = new ApiResponse(ex.getMessage(), true);
		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
				.body(res);
	}
}
