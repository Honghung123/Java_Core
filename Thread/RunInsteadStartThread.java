 
public class RunInsteadStartThread extends Thread{
    public void run() {
        for (int i = 1; i < 5; i++) {
            try {
                Thread.sleep(500);
                System.out.println(Thread.currentThread().getName());
            } catch (InterruptedException e) {
                System.out.println(e);
            }
            System.out.println(i);
        }
    }

    public static void main(String args[]) {
        RunInsteadStartThread t1 = new RunInsteadStartThread();
        RunInsteadStartThread t2 = new RunInsteadStartThread(); 
        RunInsteadStartThread t3 = new RunInsteadStartThread(); 

        t1.start(); // Will print 1,2,3,4
        t2.run(); // Will print 1,2,3,4
        t3.start(); // Will print 1,2,3,4
    }
}
