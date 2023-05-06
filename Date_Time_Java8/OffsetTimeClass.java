package com.honghung.Date_Time_Java8;

import java.time.LocalTime;
import java.time.OffsetTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;

public class OffsetTimeClass {
    public static void main(String[] args) {
        OffsetTime currentOffsetTime = OffsetTime.now();
        System.out.println(currentOffsetTime.toString());
        OffsetTime offsetTime = OffsetTime.of(19, 0,
                0, 100, ZoneOffset.of("+7"));
        OffsetTime offsetOtherTime = OffsetTime.of(LocalTime.now(), ZoneOffset.of("+4"));
        System.out.println(offsetTime);
        System.out.println(offsetOtherTime);

        // get hour, minute, second
        System.out.println(currentOffsetTime.getHour());
        System.out.println(currentOffsetTime.getMinute());
        System.out.println(currentOffsetTime.getSecond());
        System.out.println(currentOffsetTime.getOffset());

        // get LocalTime instance
        System.out.println(currentOffsetTime.toLocalTime());
        System.out.println(currentOffsetTime.format(DateTimeFormatter.ofPattern("HH:mm:ss.SSSXXX")));

        // get OffsetTime instance
        OffsetTime offsetTimes = OffsetTime.parse("20-20-10.101+07:00",
                DateTimeFormatter.ofPattern("HH-mm-ss.SSSXXX"));                
        System.out.println(offsetTimes);

        // get Range value
        System.out.println(currentOffsetTime.range(ChronoField.HOUR_OF_DAY));
        System.out.println(currentOffsetTime.range(ChronoField.MINUTE_OF_DAY));
        System.out.println(currentOffsetTime.range(ChronoField.MINUTE_OF_HOUR)); 
    }
}
