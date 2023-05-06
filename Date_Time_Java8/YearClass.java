package com.honghung.Date_Time_Java8;

import java.time.LocalDateTime;
import java.time.Year;
import java.time.ZoneId;
import java.time.temporal.ChronoField;

public class YearClass {
    public static void main(String[] args) {
        Year year = Year.now();
        System.out.println(year);
        System.out.println(Year.now(ZoneId.of("Asia/Manila")));
        System.out.println(year.atDay(30));
        System.out.println(year.isLeap());
        System.out.println(year.isBefore(Year.now()));
        Year adjustYear = Year.from(LocalDateTime.of(2024, 1, 3, 9, 1, 0, 1));
        System.out.println(adjustYear.getLong(ChronoField.YEAR));
    }
}
