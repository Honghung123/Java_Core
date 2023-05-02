package com.honghung.Concurrent;

import java.util.concurrent.*;

class DemoThread extends Thread {
    @Override
    public void run() {
        System.out.println("Running current thread: " + Thread.currentThread().getName());
        for (int i = 0; i < 3; i++) {
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(i);
        }
        System.out.println("Task completed: " + Thread.currentThread().getName());
    }
}

public class Executors implements Executor {
    @Override
    public void execute(Runnable r) {
        r.run();
    }

    public static void main(String[] args) {
        new DemoThread().start();
        new DemoThread().start();
        Executor executor = new Executors();
        executor.execute(new DemoThread());
        executor.execute(new DemoThread());
    }
}
