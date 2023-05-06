package com.honghung.Date_Time_Java8;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.OffsetDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;

public class OffsetDateTimeClass {
    public static void main(String[] args) {
        OffsetDateTime currentOffsetDateTime = OffsetDateTime.now();
        System.out.println(currentOffsetDateTime);
        OffsetDateTime offsetDateTime = OffsetDateTime.of(LocalDate.now(),
                                                          LocalTime.now(), ZoneOffset.of("+7"));
        System.out.println(offsetDateTime);
        System.out.println(OffsetDateTime.of(LocalDateTime.now(), ZoneOffset.of("+7")));
        System.out.println(OffsetDateTime.parse("2023-04-29T09:30:00.721902+07:00"));
        System.out.println(OffsetDateTime.parse("29/04/2023 09:30:00.721902 +07:00", 
                DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss.SSSSSS XXX")));
                                
        System.out.println(currentOffsetDateTime.atZoneSameInstant(ZoneId.of("Asia/Ho_Chi_Minh")));
        System.out.println(currentOffsetDateTime.atZoneSimilarLocal(ZoneId.of("Asia/Ho_Chi_Minh")));

        // Get time - year, month, day, hour, minute, second
        System.out.println(currentOffsetDateTime.getYear());
        System.out.println(currentOffsetDateTime.getHour());
        System.out.println(currentOffsetDateTime.getMonth() == Month.MAY);
        System.out.println(currentOffsetDateTime.getDayOfWeek() == DayOfWeek.SATURDAY);
        System.out.println(currentOffsetDateTime.getOffset());

        // Minus - plus time
        System.out.println(currentOffsetDateTime.minusDays(10));
        System.out.println(currentOffsetDateTime.minus(5, ChronoUnit.MONTHS));
        Duration durantion = Duration.of(4, ChronoUnit.DAYS);
        System.out.println(durantion.toHours());
        Period period = Period.ofDays( 15);
        System.out.println(period);
        System.out.println(currentOffsetDateTime.minus(durantion));
        System.out.println(currentOffsetDateTime.plus(period));
        System.out.println(currentOffsetDateTime.plusHours(3));

        // Compare time
        System.out.println(currentOffsetDateTime.isAfter(offsetDateTime));
        System.out.println(currentOffsetDateTime.compareTo(offsetDateTime));
        System.out.println(currentOffsetDateTime.isBefore(offsetDateTime));
        System.out.println(offsetDateTime.compareTo(currentOffsetDateTime));
        System.out.println(currentOffsetDateTime.isEqual(offsetDateTime));
        System.out.println(currentOffsetDateTime.isSupported(ChronoField.DAY_OF_WEEK));
        System.out.println(currentOffsetDateTime.isSupported(ChronoUnit.DECADES));

        // get Instance
        System.out.println(currentOffsetDateTime.toZonedDateTime());
        System.out.println(currentOffsetDateTime);
        OffsetDateTime myOffsetDT = OffsetDateTime.of(1970, 01, 01, 1, 30, 1, 0, ZoneOffset.of("+7"));
        
        System.out.println(currentOffsetDateTime.toInstant());
        System.out.println(OffsetDateTime.ofInstant(myOffsetDT.toInstant(), ZoneOffset.of("+7")));

        System.out.println(currentOffsetDateTime.truncatedTo(ChronoUnit.HOURS));
        System.out.println(currentOffsetDateTime.range(ChronoField.HOUR_OF_DAY));
        System.out.println(currentOffsetDateTime.getLong(ChronoField.HOUR_OF_DAY));
        System.out.println(currentOffsetDateTime.getHour());

        System.out.println(currentOffsetDateTime.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss.SSSXXX")));
        System.out.println(currentOffsetDateTime.with(ChronoField.YEAR, 2024));
        System.out.println(currentOffsetDateTime.withYear(2023).withMonth(6).withDayOfMonth(10));
    }
}
