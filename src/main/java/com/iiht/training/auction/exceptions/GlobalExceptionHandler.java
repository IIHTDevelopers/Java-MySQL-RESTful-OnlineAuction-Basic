package com.iiht.training.auction.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.iiht.training.auction.model.exception.ExceptionResponse;



@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(InvalidDataException.class)
	public ResponseEntity<ExceptionResponse> handler(InvalidDataException ex) {
		ExceptionResponse exception = new ExceptionResponse(ex.getMessage(), System.currentTimeMillis(),
				HttpStatus.BAD_REQUEST.value());
		ResponseEntity<ExceptionResponse> response = new ResponseEntity<ExceptionResponse>(exception,
				HttpStatus.BAD_REQUEST);
		return response;
	}

	@ExceptionHandler(CustomerNotFoundException.class)
	public ResponseEntity<ExceptionResponse> handler(CustomerNotFoundException ex) {
		ExceptionResponse exception = new ExceptionResponse(ex.getMessage(), System.currentTimeMillis(),
				HttpStatus.BAD_REQUEST.value());
		ResponseEntity<ExceptionResponse> response = new ResponseEntity<ExceptionResponse>(exception,
				HttpStatus.BAD_REQUEST);
		return response;
	}

	@ExceptionHandler(ProductNotFoundException.class)
	public ResponseEntity<ExceptionResponse> handler(ProductNotFoundException ex) {
		ExceptionResponse exception = new ExceptionResponse(ex.getMessage(), System.currentTimeMillis(),
				HttpStatus.BAD_REQUEST.value());
		ResponseEntity<ExceptionResponse> response = new ResponseEntity<ExceptionResponse>(exception,
				HttpStatus.BAD_REQUEST);
		return response;
	}

}
