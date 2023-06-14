package com.honghung.JAVA_8;

import java.util.ArrayList; 
import java.util.List;
import java.util.Random;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.IntUnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FunctionClass {
    public static void main(String[] args) {
        IntUnaryOperator randInt = number -> new Random().nextInt(number)*3 + 5;
        List<Integer> list = IntStream.range(1, 15)
                .map(randInt)
                .mapToObj(Integer::valueOf)
                .collect(Collectors.toList());
        System.out.println(list);
        Function<Integer, Boolean> isGreaterThan20 = (value) -> value > 20;
        Function<Integer, Boolean> isDivideBy5 = (value) -> value % 5 == 0; 
        Function<Boolean, String> isReachedCondition = isReach -> isReach ? "Greater than 40" : "Less than 40";
        Function<Integer, String> convertIntToString = 
        isGreaterThan20.andThen(isReachedCondition);
        List<String> afterConvert = list.stream().map(convertIntToString).collect(Collectors.toList());
        System.out.println(afterConvert);
        
        BiFunction<Integer, Integer, Boolean> compareTwoInteger = (value1, value2) -> value1.equals(value2);
        System.out.println("Test BiFunction: " + compareTwoInteger.apply(15, 25));
        Function<Boolean, String> conclusion = isEquals 
                -> isEquals ? "Two integers are equal" : "Two integers are not equal";
        System.out.println("Test BiFunction: " + compareTwoInteger.andThen(conclusion).apply(15, 15));
    }
}
