package com.honghung.Date_Time_Java8;

import java.time.ZoneOffset; 

public class ZoneOffsetClass {
    public static void main(String[] args) {
        ZoneOffset zoneOffset = ZoneOffset.of("+01"); 
        System.out.println(zoneOffset); 
        System.out.println(ZoneOffset.ofHours(-10));
        System.out.println(ZoneOffset.ofHoursMinutes(2, 15));

        System.out.println(zoneOffset.getId());
        System.out.println(zoneOffset.getRules()); 
    }
}
