package com.example.exercise.domain.exceptions;

public class InvalidDateException extends RuntimeException {
    
    public InvalidDateException(String msg) {
        super(msg);
    }

}
