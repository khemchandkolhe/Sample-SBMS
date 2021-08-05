package com.ashokit.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class StockPriceExceptionHandlerController {

	@ExceptionHandler(value = CompanyNameNotFoundException.class)
	public ResponseEntity<String> exceptionHandler(CompanyNameNotFoundException exception) {
		String message = exception.getMessage();
		return new ResponseEntity<String>(message, HttpStatus.BAD_REQUEST);
	}
}
