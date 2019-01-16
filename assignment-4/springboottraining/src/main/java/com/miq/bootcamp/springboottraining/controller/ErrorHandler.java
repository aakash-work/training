package com.miq.bootcamp.springboottraining.controller;

import javax.persistence.EntityNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;



@ControllerAdvice
public class ErrorHandler extends ResponseEntityExceptionHandler {
  
  
   @ExceptionHandler(EntityNotFoundException.class)
   protected ResponseEntity<Object> handleEntityNotFound(
           EntityNotFoundException e) {
	   String errorMessage = "Error: " + e.getMessage() + " Not Found :("; 
	   return new ResponseEntity<> (errorMessage, HttpStatus.BAD_REQUEST);
   }
}