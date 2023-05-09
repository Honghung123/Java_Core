package com.honghung.Math;
import java.lang.Math;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
public class RandomNumber {
    public static void main(String[] args) {    
        // Using Math.random() from java.lang.Math - formula : Math.random()*(max-min+1)+min
        System.out.println("Math.random(): "+(int)(Math.random()*11 + 10));
        // System.out.println((int)(Math.random()*11 + 10));
        // System.out.println((int)(Math.random()*11 + 10));
        // System.out.println((int)(Math.random()*11 + 10));
        // System.out.println((int)(Math.random()*11 + 10));

        // Using Random class from java.util.Random
        Random r = new Random(); // create a Random object
        System.out.println("Random class: "+r.nextInt(15));
        // System.out.println(r.nextInt(1555));
        // System.out.println(r.nextDouble(15551.456));
        // System.out.println(r.nextLong(1555));
        
        // Using the ThreadLocalRandom  class
        System.out.println(ThreadLocalRandom.current().nextInt()); 
        System.out.println(ThreadLocalRandom.current().nextInt(10)); 
        System.out.println(ThreadLocalRandom.current().nextInt(15,30)); 
        
        // Using the ints() method of Random class
        System.out.println("ints(): ");
        Random rand = new Random(); // create a Random object 
        rand.ints(5, 10, 100).forEach(System.out::println);
        rand.longs(5, 100000000, 1000000000).forEach(System.out::println);
        rand.doubles(5, 1000.5, 10000.9).forEach(System.out::println); 
    }
}
