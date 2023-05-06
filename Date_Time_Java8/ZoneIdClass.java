package com.honghung.Date_Time_Java8;

import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.TextStyle;
import java.util.Locale;

public class ZoneIdClass {
    public static void main(String[] args) {
        ZoneId zoneId = ZoneId.of("Asia/Shanghai");
        System.out.println(zoneId);
        System.out.println(zoneId.getDisplayName(TextStyle.FULL, Locale.US));
        System.out.println(zoneId.getId());
        System.out.println(ZoneId.systemDefault());
        System.out.println(ZoneId.ofOffset("GMT", ZoneOffset.of("+5")));
        System.out.println(zoneId.normalized()); 
        System.out.println(zoneId.getRules());
        // System.out.println(ZoneId.getAvailableZoneIds());

        System.out.println(ZoneId.from(OffsetDateTime.now(ZoneId.of("Asia/Tokyo"))));
        System.out.println(ZoneId.from(ZonedDateTime.now(ZoneId.of("+08:00"))));
    }
}
