package com.example.exercise.domain.util;

import java.util.Locale;
import java.text.NumberFormat;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FormatUtil {
    
    private FormatUtil(){
    }

    static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH.mm.ss");

    public static LocalDateTime dateParse(String date) {
        return LocalDateTime.parse(date, dtf);
    }

    public static String toFormat(LocalDateTime date) {
        return date.format(dtf);
    }

    public static String formatDouble(Double num) {
        NumberFormat formatter = NumberFormat.getNumberInstance(Locale.US);
        formatter.setMinimumFractionDigits(2);
        formatter.setMaximumFractionDigits(2);
        return formatter.format(num);  
    }

}
