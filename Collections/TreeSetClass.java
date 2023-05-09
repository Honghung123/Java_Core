package com.honghung.Collections;

import java.util.Arrays;
import java.util.Collections; 
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class TreeSetClass {
    public static void main(String[] args) {
        // Declaration
        TreeSet<Integer> treeSet = new TreeSet<>();
        Set<Integer> syncSet = Collections.synchronizedSet(treeSet);
        syncSet.add(12);
        syncSet.add(-6);
        syncSet.add(1);
        treeSet.add(11);
        treeSet.add(9);
        System.out.println(syncSet);
        System.out.println(treeSet);
        Set<Integer> set2 = new TreeSet<>(Arrays.asList(3, 4, -5, 0));
        System.out.println(set2);
        TreeSet<Integer> set3 = new TreeSet<>(set2);
        System.out.println(set3);
        TreeSet<Integer> set4 = (TreeSet<Integer>) set3.descendingSet();
        System.out.println(set4);
        // Set<String> set5 = new
        // TreeSet<>(Comparator.comparingDouble(String::compareTo));

        // Add
        set3.addAll(syncSet);
        System.out.println(set3);

        // Check
        System.out.println(set3.contains(12));
        System.out.println(set3.containsAll(set2));

        // Get
        System.out.println("Comparator: " + set3.comparator());
        System.out.println("The first element in the set: " + treeSet.first());
        System.out.println("The last element in the set: " + treeSet.last());
        Integer ceilValue = set3.ceiling(3);
        System.out.println("The value is equal or closest greatest of 3 is: " + ceilValue);
        ceilValue = set3.higher(3);
        System.out.println("The value is closest greatest of 3 is: " + ceilValue);
        Integer floorValue = set3.floor(2);
        System.out.println("The value is equal or closest least of 2 is: " + floorValue);
        floorValue = set3.lower(3);
        System.out.println("The value is closest least of 3 is: " + floorValue);
        System.out.println("DesendingSet: " + set3.descendingSet());
        // subset
        System.out.println("Sub set: " + set3.subSet(-1, true, 4, true));
        System.out.println("Sub set: " + set3.subSet(-1, 4));
        System.out.println("Sub set: " + set3.subSet(1, false, 4, false));
        System.out.println("TailSet inclusive is true: " + set3.tailSet(3));
        System.out.println("TailSet inclusive is false: " + set3.tailSet(3, false));
        System.out.println("HeadSet inclusive is false: " + set3.headSet(4));
        System.out.println("HeadSet inclusive is true: " + set3.headSet(4, true));

        // Iterator
        Iterator<Integer> descendingIterator = set3.descendingIterator();
        while (descendingIterator.hasNext()) {
            System.out.print(descendingIterator.next() + " ");
        }
        System.out.println();
        Iterator<Integer> ascendingIterator = set3.iterator();
        while (ascendingIterator.hasNext()) {
            System.out.print(ascendingIterator.next() + " ");
        }
        System.out.println();

        // Remove
        boolean isRemoved = false;
        Integer removedElement = 0;
        isRemoved = set3.remove(12);
        removedElement = set3.pollFirst();
        removedElement = set3.pollLast();
        System.out.println(set3);

    }
}
