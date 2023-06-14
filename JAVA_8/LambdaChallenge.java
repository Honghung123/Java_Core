package com.honghung.JAVA_8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate; 

public class LambdaChallenge {
    public static String firstUpperCase(String object) {
        return object.substring(0, 1).toUpperCase()
                .concat(object.substring(1).toLowerCase());
    }

    public static Comparator<String> getCondition() {
        return (String string1, String string2) -> {
            return string1.compareTo(string2);
        };
    }
    
    public static int compareTwoString(String str1, String str2) {
        return str1.compareTo(str2);
    }

    public static void display(String value) {
        System.out.print(value + " ");
    }

    public static Consumer<String> displayNameStartWithA() {
        return (String name) -> { 
            if(name.startsWith("A")){
                System.out.print(name + "");
             } 
        };
    }

    public static Predicate<String> filterNameStartWithA() {
        return (name) -> { return name.startsWith("A"); };
    }

    public static void main(String[] args) { 
        List<String> list = Arrays.asList("Amelia", "Olivia", "emily", "Isla", "Ava", "olivier",
        "Jack", "Charlie", "harry", "Jacop");
        List<String> capitalLeter = list.stream().map(LambdaChallenge::firstUpperCase)
                .collect(LinkedList::new, LinkedList::add, LinkedList::addAll);
        // Using method references        
        Comparator<String> comparator = getCondition();
        capitalLeter.sort(LambdaChallenge::compareTwoString);
        capitalLeter.sort(comparator);
        capitalLeter.sort(String::compareTo);
        capitalLeter.forEach(LambdaChallenge::display);
        System.out.println();

        // Using stream
        list.stream().map(LambdaChallenge::firstUpperCase).sorted(LambdaChallenge::compareTwoString)
                                    .forEach(LambdaChallenge::display); 
        System.out.println();
        list.stream().map(LambdaChallenge::firstUpperCase).sorted(String::compareTo)
                .forEach(LambdaChallenge::display);
                                    
        // Filter 
        System.out.println();
        Predicate<String> filterCondition = filterNameStartWithA();
        list.stream().map(LambdaChallenge::firstUpperCase).sorted(String::compareTo)
                        .filter(filterCondition)
                     .forEach(LambdaChallenge::display);
        
        System.out.println();
        Consumer<String> displayConsumer = displayNameStartWithA();
         list.stream().map(LambdaChallenge::firstUpperCase).sorted(String::compareTo) 
                 .forEach(displayConsumer);
                 
        // Peek
        System.out.println(); 
        list.stream().map(LambdaChallenge::firstUpperCase)
            .peek(LambdaChallenge::display) 
            .sorted(String::compareTo)
            .collect(ArrayList::new, ArrayList::add,ArrayList::addAll);
        list.stream().map(LambdaChallenge::firstUpperCase)
                .peek(LambdaChallenge::display).count();
                 
    }
} 
