package com.honghung.Collections;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class LInkedListClass { 

    public static void main(String[] args) {
        // Declaration 
        List<Integer> list = new LinkedList<>(); 
        System.out.println(list);
        List<Double> list2 = Arrays.asList(5.1, -4.0, .7, 10.3); // -4 or 7 is error
        System.out.println(list2);
        List<String> list3 = new LinkedList<>(Arrays.asList("Bananas", "Strawberry", "Cherry"));
        System.out.println(list3);
        LinkedList<Integer> linkedList = new LinkedList<>(Arrays.asList(4,0,-4,1));
        LinkedList<Integer> linkedListClone = (LinkedList<Integer>) linkedList.clone();
        System.out.println( linkedList.equals(linkedListClone) + " " + linkedListClone); // true
        
        // Manipulation
        // Add for polymorphic variables and instance variables
        boolean isAdded = false;
        isAdded = list.add(23);
        list.add(1, -5);
        isAdded = linkedList.add(0);

        linkedList.addFirst(12);
        linkedList.push(45);
        linkedList.addLast(-4);
        isAdded = linkedList.offer(99);
        isAdded = linkedList.offerFirst(20);
        isAdded = linkedList.offerLast(-20);

        isAdded = list.addAll(Arrays.asList(3, -1, 8));
        isAdded = list.addAll(2, Arrays.asList(13, -1, 1));
        isAdded = linkedList.addAll(2, Arrays.asList(13, -1, 1));
        System.out.println(list);
        System.out.println(linkedList);
        
        // Get value
        System.out.println();
        System.out.println(list.get(2));
        System.out.println(linkedList.element());
        System.out.println(linkedList.peek());
        System.out.println(linkedList.getFirst());
        System.out.println(linkedList.peekFirst());
        System.out.println(linkedList.getLast());
        System.out.println(linkedList.peekLast());
        System.out.println(list.getClass());

        // Get index
        System.out.println();
        System.out.println(list.indexOf(-1));
        System.out.println(linkedList.lastIndexOf(-4));

        // Check 
        System.out.println(list.contains(Integer.valueOf(13)));
        System.out.println(linkedList.containsAll(Arrays.asList(-1, 1, 0)));
        
        // Change value
        list.set(3, 100);
        System.out.println(list); 

        // Remove
        System.out.println();
        boolean isRemoved = false;
        Integer removedElement = 0; 
        removedElement = list.remove(2);
        isRemoved = list.remove(Integer.valueOf(3));
        removedElement = linkedList.remove();
        removedElement = linkedList.pop(); 
        removedElement = linkedList.poll();
        removedElement = linkedList.pollFirst();
        removedElement = linkedList.removeFirst();
        removedElement = linkedList.pollLast();
        removedElement = linkedList.removeLast();
        System.out.println(linkedList);
        isRemoved = linkedList.removeFirstOccurrence(-4);
        System.out.println(linkedList);
        isRemoved = linkedList.removeLastOccurrence(0); 
        System.out.println(linkedList);
        isRemoved = linkedList.removeLastOccurrence(1); 
        System.out.println(linkedList);
        isRemoved = list.removeIf(a -> linkedList.contains(a));
        System.out.println(list);
        isRemoved = list.retainAll(linkedListClone);
        System.out.println(list);

        // Iterate
        Iterator<Integer> iterator = linkedListClone.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();
        iterator = linkedListClone.descendingIterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();
        iterator = linkedListClone.listIterator(2);
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();

        // Get array
        Object[] array = linkedList.toArray(new Object[linkedList.size()+3]);
        for (Object element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }
}
