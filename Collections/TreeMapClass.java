package com.honghung.Collections;

import java.time.Month;
import java.util.Map;
import java.util.TreeMap;

public class TreeMapClass {
    public static void main(String[] args) {
        // Declaration and add
        Map<Month, String> maps = new TreeMap<Month, String>();
        maps.put(Month.FEBRUARY, "January");
        System.out.println(maps);
        
        Map<Integer, String> map = new TreeMap<Integer, String>();
        map.put(100, "Amit");
        map.put(102, "Ravi");
        map.put(101, "Vijay");
        map.put(103, "Rahul");
        map.putAll(map);
        TreeMap<Integer, String> treeMap = new TreeMap<Integer, String>(map);
        treeMap.putIfAbsent(105, "Hoang de thuong");
        System.out.println(map);
        System.out.println(treeMap);
        TreeMap<Integer, String> subMap = new TreeMap<>(treeMap.subMap(102, 104));
        System.out.println(subMap);
        TreeMap<Integer, String> subMap2 = new TreeMap<>(treeMap.tailMap( 103));
        System.out.println(subMap2);
        TreeMap<Integer, String> subMap3 = new TreeMap<>(treeMap.tailMap( 103, true));
        System.out.println(subMap3);
        TreeMap<Integer, String> subMap4 = new TreeMap<>(treeMap.headMap( 103));
        System.out.println(subMap4);
        TreeMap<Integer, String> subMap5 = new TreeMap<>(treeMap.headMap( 103, true));
        System.out.println(subMap5);

        // get
        System.out.println("The size of TreeMap is: " + treeMap.size());
        Integer firstKey = treeMap.firstKey();
        System.out.println("The first key of tree map: " + firstKey);
        Integer lastKey = treeMap.lastKey();
        System.out.println("The last key of tree map: " + lastKey);
        System.out.println("Get value of key 103 : " + treeMap.get(103));
        System.out.println("Get greatest key that is lower than specific key 103 : " + treeMap.lowerKey(103));
        System.out.println("Get least key that is greater than specific key 103 : " + treeMap.higherKey(103));

        // get Iterator
        System.out.println("Desending Keys: " + treeMap.descendingKeySet());
        System.out.println("Desending Map: " + treeMap.descendingMap());
        System.out.println("Ascending Keys: " + treeMap.navigableKeySet());
        

        // Get Entry
        Map.Entry<Integer, String> entry = treeMap.firstEntry();
        System.out.println("The first entry: " + entry);
        entry = treeMap.lastEntry();
        System.out.println("The last entry: " + entry);
        entry = treeMap.ceilingEntry(104);
        System.out.println("The ceiling entry of 104 is : " + entry);
        treeMap.forEach((key, value) -> System.out.println("Key: " + key + " Value: " + value));
        map.forEach((key, value) -> System.out.println("Key: " + key + " Value: " + value));
        entry = treeMap.entrySet().iterator().next();
        
        // Check
        System.out.println("102 is exist in TreeMap: " + treeMap.containsKey(102));
        System.out.println("'Hoang de thuong' is exist in TreeMap: " + treeMap.containsValue("Hoang de thuong"));

        // Update
        treeMap.replace(103, "Hoang xinh tuoi");
        System.out.println(treeMap);
        treeMap.replace(102, "Ravi", "Hung Thich Hoang");
        System.out.println(treeMap);
        treeMap.replaceAll((key, value) -> value.toLowerCase());
        System.out.println("Test replaceAll(): " + treeMap);
        
        
        // Remove
        treeMap.remove(103);
        System.out.println(treeMap);
        treeMap.remove(102,"Ravis");
        System.out.println(treeMap);
        System.out.println("Remove the first entry: " + treeMap.pollFirstEntry());
        System.out.println("Remove the last entry: " + treeMap.pollLastEntry());
        System.out.println(treeMap);
        treeMap.clear();
        System.out.println("Tree map is empty: " + treeMap.isEmpty());
    }
}
