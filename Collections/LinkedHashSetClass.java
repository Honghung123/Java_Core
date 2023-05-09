package com.honghung.Collections;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class LinkedHashSetClass {
    public static void main(String[] args) {
        Set<Integer> set = new LinkedHashSet<>();
        set.add(12);
        set.addAll(Arrays.asList(-2, 4, 6, 12, 3, 4));
        System.out.println(set);
        
        Set<String> set3 = new LinkedHashSet<>(Arrays.asList("Hoang", "De", "Thuong", "Lam","Hung","Thuong","Hoang"));
        System.out.println(set3);
        Set<Integer> set2 = new LinkedHashSet<>(set);

        // Get
        System.out.println("The size of the set: " + set.size());
        System.out.println(set.getClass()); // HashSet

        // Check
        System.out.println("12 is in set: " + set.contains(12));
        System.out.println("[4,6,3] is in set: " + set.containsAll(Arrays.asList(4, 6, 3)));
        System.out.println("Set1 is equivalent to set2 " + set.equals(set2));

        // Remove
        boolean isRemoved = false;
        System.out.println(set2);
        isRemoved = set2.remove(6);
        System.out.println(set2);
        isRemoved = set.removeIf(a -> a < 0);
        set2.removeAll(new LinkedHashSet<>(set));
        System.out.println(set2);
        System.out.println(set2.stream().distinct().collect(Collectors.toList()));

        System.out.println(set2.stream().count());
        set.clear();
        System.out.println("Empty set: " + set.isEmpty());
    }
}
