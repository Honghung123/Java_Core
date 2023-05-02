package com.honghung;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class CreateObject implements Cloneable {
    int value;

    CreateObject() {
        System.out.println("Object created");
        value = 10;
    }

    CreateObject(int value) {
        this.value = value;
    }

    void print() {
        System.out.println("Our value: " + value);
    }

    public static void main(String[] args) throws CloneNotSupportedException,
            InstantiationException, IllegalAccessException,
            IllegalArgumentException, InvocationTargetException, ClassNotFoundException, IOException {
        // Scanner scanner = new Scanner(System.in);
        // System.out.print("Enter a message: ");
        // String message = scanner.nextLine();
        // System.out.println("You entered: " + message);
        // scanner.close();
        // Create an object using the new keyword
        CreateObject app = new CreateObject(5);
        app.print();

        // Create an object using the clone method
        CreateObject clone = (CreateObject) app.clone();
        clone.print();

        // Create an object using newInstance() of Class class - DEPRECATED
        CreateObject newObj = CreateObject.class.newInstance();
        newObj.print();
        CreateObject newObj2 = (CreateObject) Class.forName("com.honghung.CreateObject")
                                                   .newInstance();
        newObj2.print();

        // Create an object using newInstance() of Constructor class
        Constructor[] constructor = CreateObject.class.getConstructors(); 
        // CreateObject obj = (CreateObject) constructor[0]
        //         .newInstance(1);
        // obj.print();

        // Create an object using Deserialization
        // Serialization
        FileOutputStream fout = new FileOutputStream("Serialization.txt");
        ObjectOutputStream out = new ObjectOutputStream(fout);
        out.writeObject(app);
        out.flush();
        out.close();
        // Deserialization
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("Serialization.txt"));
        CreateObject appClone = (CreateObject) in.readObject();
        appClone.print();
    }

}
