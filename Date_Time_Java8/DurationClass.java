package com.honghung.Date_Time_Java8;

import java.time.Duration;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class DurationClass {

    public static void main(String[] args) {
        Duration duration = Duration.ofMinutes(-41);
        System.out.println(duration.toString());
        Duration duration2 = duration.minus(3, ChronoUnit.HOURS);
        System.out.println(duration2);

        System.out.println(duration2.getSeconds());
        System.out.println(duration.abs());

        System.out.println(Duration.between(LocalTime.of(12, 40, 15),
                LocalTime.of(9, 55, 45)));
            
        System.out.println((LocalTime)duration.addTo(LocalTime.of(13,23,01)));
    }
}
