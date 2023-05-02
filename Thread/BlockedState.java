 
public class BlockedState {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new DemoBlockedRunnable());
        Thread t2 = new Thread(new DemoBlockedRunnable());
        System.out.println("Before start: " + t1.getState() + "  " + t2.getState());
        t1.start();
        t1.setName("Thread 1");
        System.out.println("After start: " + t1.getState() + "  " + t2.getState());
        t2.start();
        t2.setName("Thread 2");
        System.out.println("After start: " + t1.getState() + "  " + t2.getState());
        
        Thread.sleep(1000);
        System.out.println("After sleep: " + t1.getState() + "  " + t2.getState());
 
        System.exit(0);
    }
}

class DemoBlockedRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("Run method called for " + Thread.currentThread().getName());
        commonResource();
    }

    public static synchronized void commonResource() {
        while (true) {
            //We've created two different threads – t1 and t2
        
            // t1 starts and enters the synchronized commonResource() method; this means that 
            // only one thread can access it; all other subsequent threads that try to access 
            // this method will be blocked from the further execution until the current one 
            // will finish the processing

            // When t1 enters this method, it is kept in an infinite while loop; this is just 
            // to imitate heavy processing so that all other threads cannot enter this method

            // Now when we start t2, it tries to enter the commonResource() method, which 
            // is already being accessed by t1, thus, t2 will be kept in the BLOCKED state
        }
    }
}