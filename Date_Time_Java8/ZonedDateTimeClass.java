package com.honghung.Date_Time_Java8;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class ZonedDateTimeClass {
    public static void main(String[] args) {
        ZonedDateTime zonedDateTime = ZonedDateTime.now(ZoneId.of("Asia/Shanghai"));
        System.out.println(zonedDateTime);
        System.out.println(ZonedDateTime.now());
        System.out.println(zonedDateTime.getZone());
        System.out.println(zonedDateTime.withZoneSameInstant(ZoneId.of("Asia/Tokyo")));
        System.out.println(zonedDateTime.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss.SSS XXX [VV]")));

        System.out.println(ZonedDateTime.parse("29/04/2003 10:30:10.100 +07:00 Asia/Ho_Chi_Minh",
                                 DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss.SSS XXX [VV]")));

        // Plus / minus time
        System.out.println(zonedDateTime.plus(23, ChronoUnit.MINUTES));
        System.out.println(zonedDateTime.minus(5, ChronoUnit.MONTHS));
        System.out.println(zonedDateTime.isAfter(zonedDateTime.minus(3, ChronoUnit.MICROS)));
        System.out.println(zonedDateTime.truncatedTo(ChronoUnit.DAYS));
        
        // get Instance 
        System.out.println(zonedDateTime.toLocalDateTime());

    }   
}
