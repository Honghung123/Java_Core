package com.honghung.nested;

public class SuperClass {
    private String name;
    private int age;
    protected int salary;

    SuperClass(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void calling() {
        System.out.println("Haha");
    }
}

