package com.honghung.Collections;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

@FunctionalInterface
interface SumValue<T> {
    T sum(Integer value1, Integer value2);
}
@FunctionalInterface
interface getStringWithTwoArgs<T,V> {
    String getString(T str1, V str2);
}

public class ConcurrentHashMapClass {
    public static void main(String[] args) {
        Map<Integer, String> map = new ConcurrentHashMap<>();
        map.put(3, "Hung pro");
        map.put(4, "Hung dep trai");
        map.compute(1, (k, v) -> v == null ? "Hoang de thuong" : v.concat(" rat de thuong"));
        System.out.println(map);
        map.computeIfAbsent(2, k -> "Love Hoang");
        map.computeIfPresent(1, (k, v) -> v == null ? "Hoang Cute" : v.concat(" rat cute"));
        System.out.println(map);
        ConcurrentHashMap<Integer, String> currentMap = new ConcurrentHashMap<>(map);
        System.out.println(currentMap);
         
        Enumeration<String> values = currentMap.elements();
        while (values.hasMoreElements()) {
            System.out.print(values.nextElement() + " ");
        }
        System.out.println();
        for (Map.Entry<Integer, String> entry : currentMap.entrySet()) {
            System.out.print(entry.getKey() + "=" + entry.getValue() + " - ");
        }
        
        currentMap.forEach(2,(key, value)-> System.out.println(key + ": " + value.toUpperCase()));
        
        System.out.println("Mapping count: " + currentMap.mappingCount() + " " + currentMap.size());
        currentMap.clear();

        System.out.println("Key Set: " + currentMap.keySet());
        System.out.println("Key Set: " + ConcurrentHashMap.newKeySet());
        
        // Test functional Interface
        SumValue<Integer> sumValue = (a, b) -> a + b;
        System.out.println("Sum value using Lambda: " + sumValue.sum(12, -5));
       
        getStringWithTwoArgs<Integer, Double> getStrintArgs = ((a, b) -> String.valueOf(a * b));
        System.out.println("Test functional Interface: " + getStrintArgs.getString(3, 5.7));
        System.out.println();

        // Test functional Interface Consumer
        Consumer<String> updateValue = str -> {
            map.replace(1, str);
            System.out.println("Updated value");
        };
        updateValue.andThen((str) -> System.out.println("The value updated: " + str))
                   .accept("Hung Thich Hoang");
        System.out.println("Updated value at key 1: " + map.get(1));

        // Test functional Interface BiConsumer
        BiConsumer<Integer, String> addOrReplaceElement = (key, value)  -> {
            map.putIfAbsent(key, value);
            System.out.println("Updated entry");
        };
        addOrReplaceElement.andThen((key, value) -> 
                                          System.out.println(key + "=" + value + " is added to map"))
                           .accept(5, "Hung Thich Hoang");
        System.out.println("Updated map: " + map);

        // Test functional Interface Supplier
        Supplier<String> getElement = (() -> map.get(3));
        System.out.println("Test supplier: " + getElement.get());

    }
}
