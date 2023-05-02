 
public class ThreadOne implements Runnable{

    // @Override
    // public void run() {
    //     try {
    //         Thread t = new Thread(new ThreadOne());
    //         Thread.sleep(2000); // sleep in the specified amount of time
    //         t.start();
    //         t.join(5000);
    //         System.out.println("Thread T: " + t.getState());
    //     } catch (InterruptedException e) {
    //         Thread.currentThread().interrupt(); // interrupt the current thread
    //         e.printStackTrace();
    //     }
    // }
    
    @Override
    public void run() { 
        try{ 
            Thread.sleep(3320); // wait   
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // interrupt the current thread
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        System.out.println("Current Thread: " + Thread.activeCount()); 
        Thread t1 = new Thread(new ThreadOne());
        t1.start();
        System.out.println("Thread T1: " +t1.getState());
        System.out.println("Current Thread: " + Thread.activeCount()); 
        Thread t2 = new Thread(new ThreadOne());
        t2.start();
        System.out.println("Thread T2: " +t2.getState());
        System.out.println("Current Thread: " + Thread.activeCount()); 
        //Thread t3 = new Thread(new Thread());
        //t3.start();
        //System.out.println("Thread T3: " +t3.getState());
        //System.out.println("Current Thread: " + Thread.activeCount());
        System.out.println(Thread.currentThread().getState());
        System.out.println("Thread T1: " +t1.getState());
        System.out.println("Thread T2: " +t2.getState());
        //System.out.println("Thread T3: " + t3.getState());
        try{
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Thread T1: " +t1.getState());
        System.out.println("Thread T2: " +t2.getState());
        
    }
}
