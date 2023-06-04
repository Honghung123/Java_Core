package com.honghung.JAVA_11;

public class stripMethod {
    public static void main(String[] args) {
        String str = "   Hello World              \n   Hung  ";
        System.out.println(str.length());

        // Trim left 
        String stripLeft = str.stripLeading();
        System.out.println(stripLeft.length());

        // Trim right
        String stripRight = str.stripTrailing();
        System.out.println(stripRight.length());

        // Trim all
        String striped = str.strip();
        System.out.println(striped.length());

        // Trim indents
        String indents = str.stripIndent();
        System.out.println(indents.length());
        System.out.println(indents);
        System.out.println(indents.equals("Hello World\nHung"));


        StringBuilder sb = new StringBuilder("Hoang");
        StringBuilder sbs = new StringBuilder(sb);
    }
}
