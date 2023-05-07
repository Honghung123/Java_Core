package com.honghung.Collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection; 
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Spliterator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ArrayListClass {
    public static void main(String[] args) {
        // Declaration
        List<Integer> list = new ArrayList<>();
        System.out.println(list + " " + list.size());
        List<Integer> list2 = new ArrayList<>(5);
        System.out.println(list2 + " " + list2.size());
        List<String> list3 = Arrays.asList("Bananas", "Apple", "Guava", "Pineapple");
        List<String> list4 = new ArrayList<>(list3);
        System.out.println(list4);

        // Manipulation
        list.add(0, 13); // Throw an exception ArrayIndexOutOfBoundsException if index is negative
        boolean isAdded = list.add(3);
        System.out.println("Added: " + isAdded + " " + list);
        boolean isAdded2 = list.addAll(Arrays.asList(-5, 4, 13, 12));
        isAdded2 = list.addAll(1,Arrays.asList(4, 23, 7, -2));
        System.out.println("Added: " + isAdded2 + " " + list);
        System.out.println("Get value at 4: " + list.get(4));
        System.out.println("The index of the last element 13: " + list.lastIndexOf(13));

        System.out.println("Get Object array from ArrayList: ");
        for (Object o : list.toArray()) {
            System.out.print((Integer) o + " ");
        }
        System.out.println();
        System.out.println("Get alone array from ArrayList: ");
        List<String> list5 = List.copyOf(list4); 
        System.out.println(list5);

        System.out.println("Remove the element at index 6 in ArrayList: "+ list.remove(6));
        boolean isRemoved = list.remove(Integer.valueOf(13));
        System.out.println("Remove 13 in the first occurrance in ArrayList: " + isRemoved + list);
        isRemoved = list.removeAll(Arrays.asList(4, 12));
        System.out.println("Remove all 4 and 12 in ArrayList: " + isRemoved + list);
        isRemoved = list.removeIf(a -> a < 5);
        System.out.println("Remove all elements less than 5 in ArrayList: " + isRemoved + list);
        isRemoved = list.retainAll(Arrays.asList(13, 23));
        System.out.println("Remove all elements not in specify list in ArrayList: " + isRemoved + list);
        int changeValue = list.set(1, 20);
        System.out.println("The value has changed: " + changeValue + " " + list);
        System.out.println();

        list.addAll(Arrays.asList(-5, 4, 13, 12));
        list.sort((a, b) -> a - b); // Ascending order
        System.out.println("The ascending order array list: " + list);
        list.sort((a, b) -> b - a); // Descending order
        System.out.println("The descending order array list: " + list);
        System.out.println("Get the sublist from the current list: " + list.subList(1, 5));

        // Check or clear list
        System.out.println("Trim the list (from unnecessary capacity to the current size)");
        
        System.out.println("The size of the list: " + list.size());
        System.out.println("Is 12 is contained in ArrayList: " + list.contains(12)); 
        list.clear();
        System.out.println(list);
        System.out.println("List is empty: " + list.isEmpty());

        // Spliterator Interface
        System.out.println();
        List<Integer> lists = Stream.generate(() -> new Random().nextInt(1000))
                                    .limit(61).collect(Collectors.toList());
        Spliterator<Integer> spliterator = lists.spliterator();
        Spliterator<Integer> spliterator2 = spliterator.trySplit();
        Spliterator<Integer> spliterator3 = spliterator2.trySplit();
        System.out.println(spliterator2.estimateSize());
        System.out.println(spliterator3.estimateSize());
        System.out.println(spliterator.estimateSize());
         
        while (spliterator2.tryAdvance(e -> System.out.print(e + " "))) {
        }
        System.out.println();
        while (spliterator3.tryAdvance(e -> System.out.print(e + " "))) {
        }
        System.out.println();
        while (spliterator.tryAdvance(e -> System.out.print(e + " "))) {
        }
        System.out.println();
        System.out.println(spliterator.characteristics()); 
    }
}
