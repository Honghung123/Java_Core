package com.honghung.Date_Time_Java8;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class LocalDateTimeClass {
    public static void main(String[] args) {
        LocalTime localTime = LocalTime.of(20, 10, 30);
        LocalDate localDate = LocalDate.of(2023, 05, 05);
        LocalDateTime localDateTime = LocalDateTime.of(localDate, localTime);
        System.out.println(localDateTime);
        LocalDateTime currentDateTime = LocalDateTime.now();
        System.out.println(currentDateTime);
        
        // get year, month, day, hour, minute, second
        System.out.println(currentDateTime.getYear());
        System.out.println(currentDateTime.getMonth());
        System.out.println(currentDateTime.getMonthValue());
        System.out.println(currentDateTime.getDayOfMonth());
        System.out.println(currentDateTime.getDayOfWeek());
        System.out.println(currentDateTime.getHour());
    }
}
