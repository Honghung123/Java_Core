package com.honghung.Date_Time_Java8;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

public class InstantClass {
    public static void main(String[] args) { 
        Instant instant = Instant.from(OffsetDateTime.now(ZoneId.of("+7")));
        System.out.println(instant);
        System.out.println(Instant.from(ZonedDateTime.now()));
        System.out.println(instant.truncatedTo(ChronoUnit.DAYS));

        // Minus - Plus
        System.out.println(instant.plus(45, ChronoUnit.MINUTES));
        System.out.println(instant.minus(22, ChronoUnit.HOURS));

        // Get instance
        // System.out.println(instant.with(ChronoField.HOUR_OF_DAY, 21));
        System.out.println(instant.atOffset(ZoneOffset.of("+7"))); 
        System.out.println(instant.atZone(ZoneId.of("+7"))); 
        System.out.println(Instant.parse("2023-05-23T10:15:30.00Z"));
        System.out.println(instant.adjustInto(ZonedDateTime.now())); 
    }
}
