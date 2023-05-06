package com.honghung.Date_Time_Java8;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.Month;

public class DateOfWeekEnum_Month {
    public static void main(String[] args) {
        DayOfWeek dayOfWeek = DayOfWeek.of(6);
        System.out.println(DayOfWeek.of(7));
        System.out.println(dayOfWeek.name());
        System.out.println(dayOfWeek.ordinal());
        System.out.println(DayOfWeek.valueOf("SATURDAY"));
        System.out.println(dayOfWeek.getValue());
        System.out.println(DayOfWeek.values()[3]);

        Month month = Month.of(4);
        System.out.println(month);
        System.out.println(month.firstDayOfYear(false));
        System.out.println(month.firstMonthOfQuarter());
        System.out.println(month.getValue());

        System.out.println(Month.from(LocalDateTime.now()));
    }
}
