package com.honghung.Synchronization;

class TotalEarning extends Thread{
    public static int sum = 0;
    @Override
    public void run() {
        synchronized (this) {
            getSum();
        }
    }
    public void getSum() {
        for (int i = 1; i <= 10; i++) {
            System.out.println(Thread.currentThread().getName() + " Calculate the sum: " + i);
            sum += 100;
        }
        this.notify();
    }
}

public class NotifyWaitMehod {
    public static void main(String[] args) throws InterruptedException {
        TotalEarning t = new TotalEarning();
        t.start();
        System.out.println( Thread.currentThread().getName() + " - TotalEarning: " + TotalEarning.sum);
        synchronized (t) {
            System.out.println(Thread.currentThread().getName() + " will call t.wait()");
            t.wait(00);
            System.out.println(Thread.currentThread().getName()
                                + "TotalEarning: " + TotalEarning.sum);
        }
        System.out.println("Current Thread: " + Thread.currentThread().getName());
    }
}
