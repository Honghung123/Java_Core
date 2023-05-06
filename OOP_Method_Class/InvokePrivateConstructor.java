package com.honghung.OOP_Method_Class;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.lang.reflect.InvocationTargetException;

class Vehicle {

    // private fields of the class Vehicle
    private Integer vId;
    private String vName;

    // parameterless constructor
    private Vehicle() {
    }

    // parameterized constructor
    private Vehicle(Integer vId, String vName) {
        this.vId = vId;
        this.vName = vName;
    }

    // setter methods of the class Vehicle
    public void setVehicleId(Integer vId) {
        this.vId = vId;
    }

    public void setVehicleName(String vName) {
        this.vName = vName;
    }

    // getter methods of the class Vehicle
    public Integer getVehicleId() {
        return vId;
    }

    public String getVehicleName() {
        return vName;
    }
}

class Person{
    private String name;
    private int age;

    private Person() {
        name = "Hoang de thuong";
        age = 20;
    }

    private Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void print() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}

public class InvokePrivateConstructor {
    // the createObj() method is used to create an object of
    // the Vehicle class using the parameterless constructor.
    public void craeteObj(int vId, String vName) throws InstantiationException, IllegalAccessException,
            IllegalArgumentException, InvocationTargetException, NoSuchMethodException {
        // using the parametereless contructor
        Constructor<Vehicle> constt = Vehicle.class.getDeclaredConstructor();

        constt.setAccessible(true);
        Object obj = constt.newInstance();
        if (obj instanceof Vehicle) {
            Vehicle v = (Vehicle) obj;
            v.setVehicleId(vId);
            v.setVehicleName(vName);
            System.out.println("Vehicle Id: " + v.getVehicleId());
            System.out.println("Vehicle Name: " + v.getVehicleName());
        }
    }

    // the craeteObjByConstructorName() method is used to create an object
    // of the Vehicle class using the parameterized constructor.
    public void craeteObjByConstructorName(int vId, String vName) throws NoSuchMethodException, SecurityException,
            InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {

        // using the parameterized contructor
        Constructor<Vehicle> constt = Vehicle.class
                                             .getDeclaredConstructor(Integer.class,
                                                                                       String.class );

        if (Modifier.isPrivate(constt.getModifiers())) {
            constt.setAccessible(true);

            Object obj = constt.newInstance(vId, vName);
            if (obj instanceof Vehicle) {
                Vehicle v = (Vehicle) obj;
                System.out.println("Vehicle Id: " + v.getVehicleId());
                System.out.println("Vehicle Name: " + v.getVehicleName());
            }
        }
    }

    // delegating the responsibility to Java Virtual Machine (JVM) to handle the
    // raised
    // exception
    // main method
    public static void main(String argvs[]) throws InstantiationException,
            IllegalAccessException, IllegalArgumentException, InvocationTargetException,
            NoSuchMethodException, SecurityException {

        // creating an object of the class PvtConstructorDemo
        InvokePrivateConstructor ob = new InvokePrivateConstructor();
        ob.craeteObj(20, "Indica");
        System.out.println(" -------------------------- ");
        ob.craeteObjByConstructorName(30, "Alto");
    }
} 
