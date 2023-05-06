package com.honghung.Date_Time_Java8;

import java.time.Clock;
import java.time.LocalDate;
import java.time.Month;
import java.time.MonthDay;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;

enum Months {
    JANUARY ,
    FEBRUARY ,
    MARCH ,
    APRIL ,
    MAY ;
}


// Enum has value
enum MonthOfYear {
    JANUARY(1),
    FEBRUARY(2),
    MARCH(3),
    APRIL(4),
    MAY(5),
    JUNE(6),
    JULY(7),
    AUGUST(8),
    SEPTEMBER(9),
    OCTOBER(10),
    NOVEMBER(11),
    DECEMBER(12);

    private final int value;

    MonthOfYear(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}

public class MonthDayClass {
    public static void main(String[] args) {
        MonthDay monthDay = MonthDay.of(2, 29);
        System.out.println(monthDay );
        LocalDate localDate = monthDay.atYear(2023);
        System.out.println(localDate);
        System.out.println(monthDay.format(DateTimeFormatter.ofPattern("dd/MM")));

        // Get month and day
        MonthDay currentMonthDay = MonthDay.now();
        System.out.println(currentMonthDay);
        System.out.println(currentMonthDay.getDayOfMonth());
        System.out.println(currentMonthDay.getMonthValue());
        System.out.println(currentMonthDay.get(ChronoField.DAY_OF_MONTH));
        
        System.out.println(monthDay.isValidYear(2024));
        System.out.println(currentMonthDay.hashCode());
        
        System.out.println(currentMonthDay.isAfter(monthDay));
        MonthDay copyMonthDay = monthDay.with(Month.JULY);
        System.out.println(monthDay);
        System.out.println(copyMonthDay);

        System.out.println(MonthOfYear.JANUARY.getValue());
        MonthDay currentClockMonthDay = MonthDay.now(Clock.systemDefaultZone());
        System.out.println(currentClockMonthDay);
    }
}
