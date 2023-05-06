package com.honghung.Date_Time_Java8;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class LocalTimeClass {
    public static void main(String[] args) {
        ZoneId zone = ZoneId.of("Asia/Shanghai");
        LocalTime currentTimeZone = LocalTime.now(zone);
        System.out.println(currentTimeZone);

        LocalTime currentTime = LocalTime.now();
        
        System.out.println(ChronoUnit.HOURS.between(currentTime, currentTimeZone));
        System.out.println(ChronoUnit.MINUTES.between(currentTime, currentTimeZone));
        System.out.println(ChronoUnit.SECONDS.between(currentTime, currentTimeZone));

        LocalTime time1 = LocalTime.of(17, 3, 0);
        System.out.println(currentTime);
        System.out.println(time1.compareTo(currentTime));
        System.out.println(currentTime.format(DateTimeFormatter.ofPattern("hh:mm:ss")));
        
        // minus time
        System.out.println(currentTime.minusHours(3));
        System.out.println(currentTime.minusMinutes(3));
        System.out.println(currentTime.minusSeconds(3));

        // plus time
        System.out.println(currentTime.plusHours(3));
        System.out.println(currentTime.plusMinutes(3));
        System.out.println(currentTime.plusSeconds(3));

        // Get hours, minutes, seconds
        System.out.println(currentTime.getHour());
        System.out.println(currentTime.getMinute());
        System.out.println(currentTime.getSecond());

        // get Instance of LocalDateTime
        LocalDateTime getLocalDT = currentTime.atDate(LocalDate.of(2023, 05, 06));
        System.out.println(getLocalDT.toLocalTime());
        System.out.println(getLocalDT.toLocalDate());
    }
}
