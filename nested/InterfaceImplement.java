package com.honghung.nested;

public class InterfaceImplement implements InterfaceExtend {
    public static void say() {
        System.out.println("this is static method in InterfaceImplement" + list);
    }

    public static int variable = var1 + 10;

    @Override
    public void superMethod() {
        System.out.println("Override method of super method");
    }

    @Override
    public void interfaceExtend() {
        System.out.println("Override interface Extend method");
    }

    @Override
    public int defaultAsAbstract() {
        return 2;
    }
     
    @Override
    public void defaultMethod() { 
        InterfaceExtend.super.defaultMethod();
        System.out.println("Override interface default method >3 >3 >3");
    }
    
}
