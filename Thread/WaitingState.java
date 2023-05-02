 
public class WaitingState implements Runnable {
    public static Thread t1;

    public static void main(String[] args) {
        t1 = new Thread(new WaitingState(), "Thread 1");
        t1.start();
        Thread t3 = new Thread("Thread 3");
        t3.start();
        System.out.println("Thread 1 state: " + t1.getState()); // Runable
        System.out.println("Thread 3 state: " + t3.getState()); // Terminated
        try {
            Thread.sleep(100 );
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }
        System.out.println("Thread 1 state: " + t1.getState()); // Timed_waiting
        try{
            t1.join();
            System.out.println(t1.isInterrupted());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }
        System.out.println("Thread 1 join(): " + t1.getState()); // Terminated
    }

    @Override
    public void run() {
        Thread t2 = new Thread(new DemoWaitingStateRunnable());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }
        t2.start();
        System.out.println("Thread State 1 after start t2:  " + WaitingState.t1.getState()); // runable
        try {
            Thread.sleep(1000);
            t2.join();  // Waiting to die
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }
       
        System.out.println("Thread State 1 after t2 call join() method:  " + WaitingState.t1.getState());
    }
}

class DemoWaitingStateRunnable implements Runnable {
    @Override
    public void run() {
        try {
            System.out.println("Run called");
            Thread.sleep(2000);
            System.out.println("Thread State 1 while t2 call join() method:  "
                                + WaitingState.t1.getState()); // Waiting state
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }
    }    
}