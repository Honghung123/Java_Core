package com.honghung.OOP_Method_Class;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class Student {
    private String name;
    private int age;

    private Student() {
    }

    private Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    private void callHisSecret() {
        System.out.println("This is his secret: " + name  );
    }

    private void callHisAge(String message, int age) {
        System.out.println(message + age);
    }
}

public class InvokePrivateMethod {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException, NoSuchMethodException,
            SecurityException, IllegalArgumentException, InvocationTargetException {
        Constructor<Student> constructor = Student.class
                                                .getDeclaredConstructor(String.class,
                                                                                        int.class);
        constructor.setAccessible(true);
        Class<Student> c = Student.class; 
        Student student = constructor.newInstance("Hong Hung", 22);
        Method method = c.getDeclaredMethod("callHisSecret");
        method.setAccessible(true);
        method.invoke(student);
        method = c.getDeclaredMethod("callHisAge", new Class[]{String.class, int.class});
        method.setAccessible(true);
        method.invoke(student, "Here is his age: ", 20);

    }
}
