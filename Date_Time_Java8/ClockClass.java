package com.honghung.Date_Time_Java8;

import java.time.Clock;
import java.time.ZoneId;

class ClockClass {
    public static void main(String[] args) {
        Clock clock = Clock.systemDefaultZone();
        Clock clock2 = Clock.system(ZoneId.of("Asia/Ho_Chi_Minh"));
        System.out.println(clock);
        System.out.println(clock.getZone());
        System.out.println(clock2.getZone());
        System.out.println(clock.getClass());
        System.out.println(clock.instant());
        System.out.println(clock2.instant());

        

    }
}