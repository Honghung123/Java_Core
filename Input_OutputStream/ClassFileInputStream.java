package com.honghung.Input_OutputStream;

import java.io.FileInputStream; 
import java.io.FileOutputStream;
import java.io.IOException;

public class ClassFileInputStream {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream("FileIOStream.txt");
        String hello = "Hello world\nHoang de thuong";
        byte[] bytes = hello.getBytes();
        fos.write(bytes);
        fos.flush();
        fos.close();
        {
            FileInputStream fout = new FileInputStream("FileIOStream.txt");
            System.out.println("The size of the file: " + fout.available()); // Total byte of the file
            int getChar = 0;
            fout.skip(6); // Discard 6 bytes -> "Hello " is not read
            while ((getChar = fout.read()) != -1) {
                System.out.print((char) getChar);
            }
            fout.close();
        }
        System.out.println();
        {
            FileInputStream fout = new FileInputStream("FileIOStream.txt");
            byte[] readByte = new byte[21];
            //fout.read(readByte);  // Doc readByte.length vao mang readByte
            fout.read(readByte,0,18);  // Doc 12 byte tu vi tri byte thu 6 cua file
            System.out.println("-" + new String(readByte)+"-");
            fout.close();
        }
     }
}
