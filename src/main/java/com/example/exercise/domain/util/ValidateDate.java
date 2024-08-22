package com.example.exercise.domain.util;


public class ValidateDate {

    public static boolean isValidDateFormat(String date) {
        String regex = "^\\d{4}-\\d{2}-\\d{2}-\\d{2}\\.\\d{2}\\.\\d{2}$";
        return date.matches(regex);   
    }

}
