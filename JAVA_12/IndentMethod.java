package com.honghung.JAVA_12;

public class IndentMethod {
    public static void main(String[] args) {
        // System.out.println(indents);
        // String afterIndent = indents.indent(0);
        // System.out.println(afterIndent);
        String indents = "12345\n123\r11\n  33\b22".indent(0);
        String other = "12345\n123\n11\n  33\b22\n";
        System.out.println(indents.equals(other));  // true
    }
}
