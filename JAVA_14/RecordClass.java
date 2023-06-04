package com.honghung.JAVA_14;

import java.util.Objects;

// - record is a final class that have private final fields and constructor having all fields, 
// getters, equals and toString method 
// - record can have static methods and fields, not static fields are not permitted 
// - We can define other constructors you want, but must call the full args constructor
// - We can define a compact constructor(constructor that not allow null for specific fields)
// - A record can have full arguments constructor or compact constructor , but bot are not allowed
record Student(String id, String name, String address) {

    // public Student() {
    //     this("UnknownId","UnknownName","UnknownAddress");
    // }

    public Student(String id) {
        this(id, "UnknownName", "UnknownAddress");
    }

    public Student {
        Objects.requireNonNull(id);
        Objects.requireNonNull(name);
        Objects.requireNonNull(address);
    }

    //// compact constructor above declared, so we can't define full args constructor
    // public Student(String id, String name, String address) {
    //     this.id = id;
    //     this.name = name;
    //     this.address = address;
    // }

    public static String className = "21CTT4";

    public static void notice() {
        System.out.println("A student in class " + className);
    }

    @Override
    public String toString() {
        return "Student has ID = " + id + " and name = " + name + " address = " + address;
    }

    public void sayHello() {
        System.out.println("Hello, this is instance method");
    }
}

public class RecordClass {
    public static void main(String[] args) {
        Student student = new Student("21120461", "Dam Hong Hung", "Binh Thuan");
        System.out.println("" + Student.className);
        Student.className = "21CTT4C";
        System.out.println("" + Student.className);
        System.out.println(student);
        Student anotherStudent = new Student("21120461", "Dam Hong Hung", "Binh Thuan");
        System.out.println(anotherStudent);
        System.out.println("Is equals: " + student.equals(anotherStudent));
        System.out.println(student.address());
        student.sayHello();
    }
}
