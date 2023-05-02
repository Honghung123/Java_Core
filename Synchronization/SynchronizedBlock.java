package com.honghung.Synchronization;

class Sender {
    public void SenderMsg(String msg) {
        synchronized (this) {
            System.out.println("Sending a Message: " + msg);
            try {
                Thread.sleep(800);
            } catch (Exception e) {
                System.out.println("Thread interrupted.");
            }
            System.out.println(msg + " Sent");
            System.out.println("End of Message " + msg);
       }
    }
}

// A Sender class for sending a message using Threads
class SenderWThreads extends Thread {
    private String msg;
    Sender sd;
    
    SenderWThreads(String m, Sender obj) {
        msg = m;
        sd = obj;
    }

    public void run() { 
        sd.SenderMsg(msg);
    }
}

// Driver Code
public class SynchronizedBlock {
    public static void main(String args[]) {
        Sender sender = new Sender();
        SenderWThreads sender1 = new SenderWThreads("Hola ", sender);
        SenderWThreads sender2 = new SenderWThreads("Javatpoint", sender);

        // Start two threads of SenderWThreads type
        sender1.start();
        sender2.start();

        // // wait for threads to end
        // try {
        //     sender1.join();
        //     sender2.join();
        // } catch (Exception e) {
        //     System.out.println("Interrupted");
        // }
    }
}