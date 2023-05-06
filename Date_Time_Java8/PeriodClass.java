package com.honghung.Date_Time_Java8;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class PeriodClass {
    public static void main(String[] args) {
        Period period = Period.of(2023, 05, 16);
        System.out.println(period);
        System.out.println(period.isZero());
        System.out.println(period.isNegative());
        System.out.println(period.getUnits());
        System.out.println(period.normalized());
        System.out.println(period.negated());

        System.out.println(period.getChronology());

        // Minus - Plus
        System.out.println(period.minus(Period.ofDays(10)));
        System.out.println(period.plus(Period.ofMonths(2)));

        System.out.println(Period.between(LocalDate.of(2023, 12, 10),
                LocalDate.of(2023, 7, 15)));
                                          
        System.out.println(period.multipliedBy(2));
 
        System.out.println((LocalDate)Period.ofDays(14).subtractFrom(LocalDate.of(2023, 8, 1)));
        System.out.println((LocalDate)Period.ofMonths(2).addTo(LocalDate.of(2023, 8, 1)));

    }
}
