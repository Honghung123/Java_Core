package com.honghung.Exception;

public class OverrideMethod {  
    // main method
    public static void main(String args[]) {
        try {
            throw new InvalidAgeException("No calling constructor");
        } catch (InvalidAgeException ex) {
            System.out.println("Caught the exception"); 
            // printing the message from InvalidAgeException object
            System.out.println("Exception occured: " + ex.getMessage());
        } 
        System.out.println("rest of the code...");
    }
}
 
