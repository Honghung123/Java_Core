package com.honghung.Collections;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.stream.Collectors;

public class ArrayDequeClass {
    public static void main(String[] args) {
        Deque<String> deque = new ArrayDeque<>();
        boolean isAdded = false;
        isAdded = deque.add("Hoang");
        deque.addFirst("Hung");
        deque.addLast("Huy");
        deque.addAll(Arrays.asList("Hoang", "De", "Thuong"));
        
        isAdded = deque.offer("Duyen");
        isAdded = deque.offerFirst("Thuong");
        isAdded = deque.offerLast("Tram");
        System.out.println(deque);
        
        // Remove
        boolean isRemoved = false;
        String removedElement = "";
        removedElement = deque.element();
        removedElement = deque.peek();
        removedElement = deque.peekFirst();
        removedElement = deque.peekLast();

        removedElement = deque.poll();
        removedElement = deque.pollFirst();
        removedElement = deque.pollLast();
        removedElement = deque.pop();
        removedElement = deque.remove();
        isRemoved = deque.remove("Huy");
        removedElement = deque.removeFirst();
        removedElement = deque.removeLast(); 
        System.out.println(deque);

        System.out.println(deque.stream().distinct().collect(Collectors.toList()));
        deque.clear();
        System.out.println(deque.isEmpty()); 

    }
}
