public class ThreadInterrupt extends Thread{
    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + " : " + i);
                //Thread.currentThread().interrupt();
                Thread.sleep(151);
                Thread.interrupted();
            } 
        } catch (InterruptedException e) {
            System.out.println("A thread has been interrupted while sleeping");
        }
    }
    public static void main(String[] args) {
        Thread t1 = new ThreadInterrupt(); 
        t1.start();  
        try {
            t1.interrupt();
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + " : " + i);
                Thread.sleep(501);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
