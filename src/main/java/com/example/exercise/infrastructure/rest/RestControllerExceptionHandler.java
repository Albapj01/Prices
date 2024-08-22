package com.example.exercise.infrastructure.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.exercise.domain.exceptions.InvalidDateException;
import com.example.exercise.domain.exceptions.PriceNotFoundException;

@RestControllerAdvice
public class RestControllerExceptionHandler {
    
    @ExceptionHandler(PriceNotFoundException.class)
    protected ResponseEntity<String> handlePriceNotFoundException(PriceNotFoundException ex) {
        return new ResponseEntity<>("Price not found", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity<String> handleMissingParams(MissingServletRequestParameterException ex) {
        String parameterName = ex.getParameterName();
        String message = "Missing required parameter: " + parameterName;
        return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InvalidDateException.class)
    protected ResponseEntity<String> handleInvalidDateException(InvalidDateException ex) {
        return new ResponseEntity<>("Invalid date format", HttpStatus.BAD_REQUEST);
    }
    
}
