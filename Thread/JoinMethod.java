 
class ThreadJoin extends Thread {
    public void run() {
        for (int j = 0; j < 5; j++) {
            try {
                // sleeping the thread for 300 milli seconds
                Thread.sleep(500);
                System.out.println("The current thread name is: " + Thread.currentThread().getName());
            }
            // catch block for catching the raised exception
            catch (Exception e) {
                System.out.println("The exception has been caught: " + e);
            }
            System.out.println(j);
        }
    }
}

public class JoinMethod {
    // main method
    public static void main(String argvs[]) {

        // creating 3 threads
        ThreadJoin th1 = new ThreadJoin();
        ThreadJoin th2 = new ThreadJoin();
        ThreadJoin th3 = new ThreadJoin();
        
        // thread th1 starts
        th1.start();
        th2.start();

        // starting the second thread after when
        // the first thread th1 has ended or died.
        try {
            System.out.println("The current thread name is: " + Thread.currentThread().getName());

            // invoking the join() method
            th1.join();
        }

        // catch block for catching the raised exception
        catch (Exception e) {
            System.out.println("The exception has been caught " + e);
        }

        // thread th2 starts

        // starting the th3 thread after when the thread th2 has ended or died.
        try {
            System.out.println("The current thread name is: " + Thread.currentThread().getName());
            th2.join(1500); // Ưu tiên thực hiện trong 1.5s
        }

        // catch block for catching the raised exception
        catch (Exception e) {
            System.out.println("The exception has been caught " + e);
        }

        // thread th3 starts
        th3.start();
    }
}
