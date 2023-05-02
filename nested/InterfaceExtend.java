package com.honghung.nested;

public interface InterfaceExtend extends InterfaceSuper {
    int var1 = 15;
    //String[] list = {};
    void interfaceExtend(); // Ham trong interface chinh no

    @Override
    default void defaultMethod() {
        System.out.println("Default method in superInterface was overridden" + var1); 
    }

    public int defaultAsAbstract(); // Redeclare super interface as abstract method

    public static void staticMethod(){
        System.out.println("Hiding static method of superInterface" + list.length);
    }
}
