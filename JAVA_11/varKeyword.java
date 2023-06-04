package com.honghung.JAVA_11;

import java.util.LinkedList;
import java.util.List;

@FunctionalInterface
interface SumInterface<T> {
    public T sum(T a, T b);
}

public class varKeyword {
    // var can not be used to declare fields at class level
    //private var Name;

    // var can not be used to indicate arguments in the method
    // var can be used to return type
    public static boolean checkVar(String arg1, int arg2) {
        var stringArg = arg1; // we can assign var variables to another variable
        var intArg = arg2;
        var result = stringArg.equals(String.valueOf(intArg));
        return result;
    }
    
    public static String sum(String str1, String str2) {
        return str1 + " " + str2;
    }

    public static void main(String[] args) {
        var varInt = 10;
        System.out.println("Use var to declare an Integer: " + varInt);
        System.out.println(Integer.class.isInstance(varInt)); // Check for primitive types

        var nameString = "Hoang de thuong";
        System.out.println("Use var to declare a String: " + nameString);
        System.out.println(String.class.isInstance(nameString)); // Check for primitive types
        System.out.println(nameString instanceof String); // Check type by object

        var listId = new LinkedList<Double>(List.of(4.1, 6.8, -1.1, 7.5));
        System.out.println("Use var to declare a list of Double numbers: " + listId);
        System.out.println(listId instanceof List); // Check if listId is an instance of List

        for (var element : listId) {
            System.out.print(element + " ");
        }
        System.out.println();
        listId.stream().map(a -> "> " + a).forEach(System.out::println);

        System.out.println("Check if var keyword can be used to return type: " + checkVar("15", 15));

        // Cannot use 'var' on variable without initializer
        // var noInital;

        // Cannot infer type for local variable initialized to 'null'
        // var nullVar = null;

        SumInterface<String> sumInterface = varKeyword::sum;
        System.out.println(sumInterface.sum("Hong", "Hung"));
        sumInterface = (var a, var b) -> a + " " + b;
        System.out.println(sumInterface.sum("Huy", "Hoang"));

    }
}
