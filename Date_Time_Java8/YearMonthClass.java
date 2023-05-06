package com.honghung.Date_Time_Java8;

import java.time.LocalDate;
import java.time.Month;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class YearMonthClass {
    public static void main(String[] args) {
        YearMonth yearMonth = YearMonth.now();
        System.out.println(yearMonth);
        YearMonth adjustYearMonth = YearMonth.of(2024, 2);
        
        System.out.println(adjustYearMonth);
        System.out.println(adjustYearMonth.isLeapYear());
        System.out.println(adjustYearMonth.isAfter(yearMonth));

        YearMonth anotherYearMonth = yearMonth.withYear(2023).withMonth(7);
        System.out.println(anotherYearMonth.isBefore(yearMonth));
        System.out.println(yearMonth.atEndOfMonth());
        System.out.println(yearMonth.plus(4, ChronoUnit.MONTHS));
        
        System.out.println(yearMonth.format(DateTimeFormatter.ofPattern("MM/yyyy")));

        System.out.println(yearMonth.until(adjustYearMonth, ChronoUnit.MONTHS));


        LocalDate localDate = LocalDate.of(2022, Month.MARCH, 11);
        LocalDate adjustedDate = (LocalDate)yearMonth.adjustInto(localDate);
        System.out.println("Adjusted date: " + adjustedDate);
    }
}
