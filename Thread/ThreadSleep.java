 
public class ThreadSleep extends Thread{
    public void run() {
        for (int i = 0; i < 5; i++) {
            // the thread will sleep for the 500 milli seconds
            try {
                System.out.println(Thread.currentThread().getName());
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
            System.out.println(i);
        }
    }

    public static void main(String argvs[]) {
        Thread t1 = new Thread(new ThreadSleep());
        t1.start();
        try {
            for (int j = 0; j < 5; j++) {

                // The main thread sleeps for the 1000 milliseconds, which is 1 sec
                // whenever the loop runs
                System.out.println(Thread.currentThread().getName());
                Thread.sleep(1000);
                // displaying the value of the variable
                System.out.println(j);
            }
        } catch (Exception exception) {
            // catching the exception
            System.out.println(exception);
        }
    }
}
