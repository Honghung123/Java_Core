package com.honghung.Collections;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class LinkedHashMapClass {
    public static void main(String[] args) {
        Map<Integer, String> map = new LinkedHashMap<>();

        // Insert
        map.put(1, "Hong");
        map.put(2, "Hung");
        map.put(1, "Hoang");
        Map<Integer, String> map2 = new LinkedHashMap<>(map);
        map2.merge(1, " De Thuong", String::concat);
        map2.merge(2, " Dep trai", String::concat);
        map2.merge(3, "Hoc", String::concat);
        System.out.println(map2);
        String str = map2.computeIfAbsent(Integer.valueOf(2), (key) -> "Hoang De thuong");
        str = map2.computeIfPresent(Integer.valueOf(3), (key, value) -> "Hoang Xinh dep");
        System.out.println(map2);
        map.put(-1, "Yeu");
        map.putIfAbsent(-2, "Thuong");
        map2.putAll(map);
        System.out.println(map);

        // Get
        System.out.println("The size of map: " + map.size());
        System.out.println(map.keySet());
        System.out.println(map.entrySet());
        System.out.println(map.values());
        System.out.println("The values of key 1: " + map.get(1));
        System.out.println("The values of key 0: " + map.getOrDefault(0, "Empty Value"));

        // Check
        System.out.println("Key 2 is exist in Map: " + map.containsKey(2));
        System.out.println("Value 'Hoang' is exist in Map: " + map.containsValue("Hoang"));

        // Update
        boolean isUpdated = map.replace(3, "Thang", "Dai");
        String valueOfUpdatedEntry = map.replace(3, "Yen");
        map.replaceAll((key, value) -> value.toUpperCase());
        System.out.println(map);

        // Test Map.Entry
        map.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEach(System.out::println);
        Iterator<Map.Entry<Integer, String>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, String> mapEntry = iterator.next();
            // mapEntry.setValue("Hoang Cute");
            System.out.println("Key: " + mapEntry.getKey());
            System.out.println("Value: " + mapEntry.getValue());
        }
        
        // remove
        boolean isRemoved = false;
        String valueOfRemovedEntry = map.remove(0);
        isRemoved = map.remove(2, "Hung");
        map.keySet().removeAll(Arrays.asList(1, 2));
        map.forEach((key, value) -> System.out.println(key + "  " + value));
        
        new Scanner(System.in).nextLine();
        map.clear();
        System.out.println("Map is empty: " + map.isEmpty());
    }
}
