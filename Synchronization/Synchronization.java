package com.honghung.Synchronization;

class BookTicket {
    private int numOfTickets = 10;

    public synchronized void book(int tickets) {
        if (tickets < numOfTickets) {
            System.out.println("Book successfully");
            numOfTickets -= tickets;
            System.out.println("Tickets left: " + numOfTickets);
        } else {
            System.out.println("Ticket has nearly sold out");
            System.out.println("Tickets left: " + numOfTickets);
        }
    }
}

class Table {
    static void printTable(int n) {// synchronized method
        for (int i = 1; i <= 5; i++) {
            System.out.println(n * i);
            try {
                Thread.sleep(400);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    static void printNormal(int n) {
        for (int i = 1; i <= 5; i++) {
            System.out.println(n + i);
            try {
                Thread.sleep(400);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}

class MyThread1 extends Thread {
    static BookTicket book;
    static {
        book = new BookTicket();
    }

    public void run() {
        book.book(7);
    }

}

class MyThread2 extends Thread {
    public void run() {
        // Table.printTable(100);
        // Table.printNormal(100);
    }
}

public class Synchronization {
    public static void main(String args[]) {
        MyThread1 t1 = new MyThread1();
        t1.setName("Ana");
        MyThread1 t2 = new MyThread1();
        t2.setName("Brody");
        t1.start();
        t2.start();
    }
}