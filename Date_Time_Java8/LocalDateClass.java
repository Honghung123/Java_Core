package com.honghung.Date_Time_Java8;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalField;

public class LocalDateClass {
    
    public static void main(String[] args) {
        LocalDate date = LocalDate.of(2023, 5, 5); // Set specified date to current object
        LocalDate dates = LocalDate.of(2023, 5, 4); // Set specified date to current object
        LocalDate currentDate = LocalDate.now(); // Get current date
        System.out.println(date + " " + currentDate);

        System.out.println(date.compareTo(dates));
        System.out.println(date.equals(currentDate));
        System.out.println(dates.equals(currentDate));

        System.out.println(currentDate.getDayOfWeek() == DayOfWeek.FRIDAY);

        // Minus date
        System.out.println(currentDate.minusDays(15)); 

        // Plus date 
        System.out.println(currentDate.plusWeeks(4));

        // Length date 
        System.out.println(currentDate.plusYears(1).minusMonths(3).lengthOfMonth());
        System.out.println(currentDate.plusYears(1).lengthOfYear());

        // get Instance from day of year 
        System.out.println(LocalDate.ofYearDay(2023, 120));
        
        // parse date
        System.out.println(LocalDate.parse("2023-05-31"));
        System.out.println(LocalDate.parse("31/05/2023", DateTimeFormatter.ofPattern("dd/MM/yyyy")));

        // Get LocalDateTime instance 
        System.out.println(currentDate.atTime(9, 15, 30));
        System.out.println(currentDate.atTime(9,15));
    }
}
