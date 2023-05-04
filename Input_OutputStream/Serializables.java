package com.honghung.Input_OutputStream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Arrays;

class Address implements Serializable{
    private String roadName;
    private int houseNumber;
    private transient String leftAddress;

    Address() {
        roadName = "Unknown";
        houseNumber = 1;
        leftAddress = "Unknown";
    }

    Address(String roadName, int houseNumber, String leftAddress) {
        this.roadName = roadName;
        this.houseNumber = houseNumber;
        this.leftAddress = leftAddress;
    }

    public void print() {
        System.out.println("Address: " + houseNumber+ " " + roadName + " " + leftAddress);
    }
}

class Student implements Serializable {
    private int id;
    private String name;
    private Address address;
    private int[] birthday = new int[4];

    public Student() {
        id = 0;
        name = "Unknown";
        address = new Address();
    }

    public Student(int id, String name, Address address) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.birthday = Arrays.copyOf(new int[] { 5, 6, 7, 3, 4, 1 }, 4);
    }

    public void print() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println(Arrays.toString(birthday));
        address.print();
    }
}

class SVA extends Student {
    private int GPA = 9;

    public SVA() {
    }
    public SVA(int id, String name, Address address) {
        super(id, name,address);
    }
    @Override
    public void print() {
        // TODO Auto-generated method stub
        super.print();
        System.out.println("GPA: "+ GPA);
    }
}

public class Serializables {
    public static void main(String args[]) throws IOException, ClassNotFoundException{
        try {
            // Creating the object
            Address address = new Address("Cao Thang", 66, "Duc Linh, Binh Thuan");
            Student s1 = new SVA(21120461, "Hoang De Thuong", address);
            // Creating stream and writing the object
            FileOutputStream fout = new FileOutputStream("student.txt");
            ObjectOutputStream out = new ObjectOutputStream(fout);
            out.writeObject(s1);
            out.flush();
            // closing the stream
            out.close();
            System.out.println("success");
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println();
        FileInputStream in = new FileInputStream("student.txt");
        ObjectInputStream out = new ObjectInputStream(in);
        Student obj = new SVA();
        obj.print();
        System.out.println();
        obj = (SVA) out.readObject();
        obj.print();
        out.close();
    }
}
