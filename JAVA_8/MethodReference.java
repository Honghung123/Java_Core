package com.honghung.JAVA_8;

@FunctionalInterface
interface Sayable {
    // default method
    default void say() {
        System.out.println("Hello, this is default method");
    }
    // static method
    static void sayLouder(String msg) {
        System.out.println(msg);
    }
    // Abstract method
    MethodReference getInstance(String name);
}

public class MethodReference {
    MethodReference() {
        System.out.println("Constructor MethodReference called");
    }
    MethodReference(String name) {
        System.out.println("Constructor MethodReference called with name: " + name);
    }
    @Override
    public String toString() {
        return "MethodReference overrided toString method";
    }
    public static void main(String[] args) {
        Sayable sayable = MethodReference::new;
        MethodReference methodReference = sayable.getInstance("Hung");
        System.out.println(methodReference);
        
    }
}
