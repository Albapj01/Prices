package com.example.exercise.infrastructure.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

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
        return new ResponseEntity<>("Missing required parameter: " + parameterName, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    protected ResponseEntity<String> handleInvalidDateException(MethodArgumentTypeMismatchException ex) {
        String parameterName = ex.getName();
        return new ResponseEntity<>("Invalid " + parameterName + " format", HttpStatus.BAD_REQUEST);
    }
    
}
