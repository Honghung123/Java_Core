package com.honghung.nested;

public interface InterfaceSuper {
    int var1 = 10; // Viet tat cua public static final int var1 = 10;
    String[] list = { "a", "b", "c", "d", "e" }; // Tuong tu nhu tren, viet tat cua public static final String[] list 
    public void superMethod();

    default void defaultMethod() {
        System.out.println("This is default method in InterfaceSuper "+ var1);
    }

    default int defaultAsAbstract() {
        return 1;
    }

    public static void staticMethod() {
        System.out.println("This is static method in InterfaceSuper");
    }
}
