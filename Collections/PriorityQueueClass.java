package com.honghung.Collections;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueueClass {
    public static void main(String[] args) {
        Queue<Integer> queue = new PriorityQueue<>();
        queue.add(12);
        queue.offer(2);
        queue.addAll(Arrays.asList(-3, 5, 9, 23));
        System.out.println(queue);

        System.out.println(queue.remove());
        System.out.println(queue.poll());
        System.out.println(queue);

        System.out.println(queue.element());
        System.out.println(queue.peek());
        System.out.println(queue);
        
        System.out.println(queue.removeIf(a -> a < 0));
        queue.clear();
        System.out.println(queue.isEmpty()); 
    }
}
