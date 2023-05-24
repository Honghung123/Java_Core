package com.honghung.JAVA_8;

import java.util.LinkedList;
import java.util.List;

@FunctionalInterface
interface ILambdaExpression {
    LambdaExpression getInstance();
}

public class LambdaExpression {
    LambdaExpression() {
        System.out.println("Construtor LambdaExpression called using functional interface");
    }

    public static <T> void printElement(T value) {
        System.out.print(value + " ");
    }
    @Override
    public String toString() {
        return "LambdaExpression overrided toString method";
    }
    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>(List.of(12, 2, -4, 7, 0, 3, 22, 9, 10, 1));
        list.forEach(LambdaExpression::printElement);
        System.out.println();
        ILambdaExpression iLambda = LambdaExpression::new;
        LambdaExpression lambda = iLambda.getInstance();
        System.out.println(lambda);

    }
}
