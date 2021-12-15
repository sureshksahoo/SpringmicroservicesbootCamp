package com.ibm.controller.advice;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.ibm.exception.UserNotFoundException;

@RestControllerAdvice
public class UserControllerAdvice{
	@ExceptionHandler(UserNotFoundException.class)
	@ResponseStatus(code=HttpStatus.UNAUTHORIZED)
	public ResponseEntity<ErrorResponse> handleUserNotFoundException(UserNotFoundException e){
		ErrorResponse response=new ErrorResponse("User Validation Failed","User Not Found!",new Date());
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
	}
	
	


}
