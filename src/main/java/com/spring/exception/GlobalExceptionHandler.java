package com.spring.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.spring.entity.ErrResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

	
	 @ExceptionHandler(IllegalArgumentException.class)
     public ResponseEntity<ErrResponse> handleIllegalArgumentException(IllegalArgumentException ex) {
         //ErrorResponse errorResponse = new ErrorResponse(HttpStatus.BAD_REQUEST.value(), ex.getMessage());
		 ErrResponse errorResponse = new ErrResponse(HttpStatus.BAD_REQUEST.value(), ex.getMessage());
         return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
     }

     // You can add more @ExceptionHandler methods for different exception types
     @ExceptionHandler(Exception.class)
     public ResponseEntity<ErrResponse> handleGenericException(Exception ex) {
         ErrResponse errResponse = new ErrResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), "An unexpected error occurred.");
         return new ResponseEntity<>(errResponse, HttpStatus.INTERNAL_SERVER_ERROR);
     }
}
