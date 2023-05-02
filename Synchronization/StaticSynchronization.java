package com.honghung.Synchronization;

class Table {
    private int seat = 10;
    public static void printTable(int n) {
        synchronized (Table.class) {
            for (int i = 1; i <= 5; i++) {
                System.out.println(n * i);
                try {
                    Thread.sleep(400);
                } catch (Exception e) {
                }
            }
        }
    }

    public void print(int num) {
        if (num < seat) {
            System.out.println("Num of seat are booked: " + num);
            seat -= num;
        } else {
            System.out.println("All seat almost sold out");
            System.out.println("Your order is "+ num);
        }
    }
}

class MyThread1 extends Thread {
    private int num;
    private Table b;
    MyThread1(Table b, int num) {
        this.b = b;
        this.num = num;
    }
    public void run() {
        //Table.printTable(1);
        b.print(num);
    }
}

class MyThread2 extends Thread {
    private int num;
    private Table b;

    MyThread2(Table b, int num) {
        this.b = b;
        this.num = num;
    }

    public void run() {
        // Table.printTable(1);
        b.print(num);
    }
}

class MyThread3 extends Thread {
    public void run() {
        Table.printTable(100);
    }
}

class MyThread4 extends Thread {
    public void run() {
        Table.printTable(1000);
    }
}

public class StaticSynchronization {
    public static void main(String t[]) {
        // Without using static synchronization
        Table a = new Table();
        Table b = new Table();
        MyThread1 t1 = new MyThread1(a, 5);
        MyThread2 t2 = new MyThread2(a,6);
        t1.start();
        t2.start();
        MyThread1 t3 = new MyThread1(b, 4);
        MyThread2 t4 = new MyThread2(b, 6 + 2);
        t3.start();
        t4.start();

        // Using static synchronization
        MyThread3 t5 = new MyThread3();
        MyThread4 t6 = new MyThread4();
        t5.start();
        t6.start();
    }
}
