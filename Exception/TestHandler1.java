package com.honghung.Exception;

import java.io.IOException;

class TestExceptionPropagation {
    void m() {
        try {
            throw new IOException("Input/Output exception");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } 
    }

    void n() {
        m();
    } 
}

public class TestHandler1 {
    public static void main(String args[]) {
        System.out.println("First code");
        try {
            new TestExceptionPropagation().n(); 
            
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
            // TODO: handle exception
        }
        System.out.println("Normal flow ...");
    } 
    // public static void main(String[] args) {
    //     try {
    //         int a[] = new int[-1];
    //         a[6] = 30 / 2; // may throw exception 
    //         System.out.println("Orthe code");
    //     } 
    //     // handling the exception
    //     catch (ArithmeticException e) {
    //         System.out.println("* * * ArithmeticException: Devision by zero");
    //     }
    //     catch (ArrayIndexOutOfBoundsException e) {
    //         System.out.println("* * * ArrayIndexOutOfBounds: Index out of bounds");
    //     }
    //     catch (Throwable e) {
    //         System.out.print("* * * Exception: ");
    //         e.printStackTrace();
    //     } 
    //     System.out.println("rest of the code");
    // }

    // public static void validateWithThrows(int age) throws ArithmeticException {
    //     System.out.println(15/0);
    // }

    // public static void validateNoThrows(int age) {
    //     if (age < 18) {
    //         // throw Arithmetic exception if not eligible to vote
    //         throw new ArithmeticException("Person is not eligible to vote");
    //     } else {
    //         System.out.println("Person is eligible to vote!!");
    //     }
    // }
    // public static void main(String args[]) {
    //     try {
    //         validateNoThrows(15);
    //     } catch (ArithmeticException e) {
    //         System.out.println(e.getMessage()); 
    //     } finally {
    //         System.out.println("This code in finally block is always executed");
    //     }
    //     System.out.println("Rest of the code ..."); 
    // }


    

    // Class that uses above MyException
 
}
