package com.honghung.nested;

public class DerivedClass extends SuperClass implements Cloneable {

    private String className;

    public DerivedClass(String name, int age, String className) {
        super(name, age);
        this.className = className;
    }

    public void print() {
        // System.out.println(name);
        // System.out.println(age);
        System.out.println(salary + 99);
    }

    @Override
    public void calling() { // Khong the override method by static keyword
        System.out.println("Haha");
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        // TODO Auto-generated method stub
        return super.clone();
    }
}
