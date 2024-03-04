package com.ecommerce.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handle(CategoryException categoryException){
        ErrorResponse errorResponse = new ErrorResponse(categoryException.getMessage(), Instant.now());
        return new ResponseEntity<>(errorResponse ,categoryException.getStatus());
    }
    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handle(Exception exception){
        ErrorResponse errorResponse = new ErrorResponse(exception.getMessage(), Instant.now());
        return new ResponseEntity<>(errorResponse , HttpStatus.BAD_REQUEST);
    }
}
