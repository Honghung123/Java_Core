public class YieldMethod extends Thread {
    @Override
    public void run() {
        try{ 
            for(int i = 0 ; i< 3 ; i++){
                System.out.println(Thread.currentThread().getName() + " " + i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Thread t1 = new YieldMethod();
        Thread t2 = new YieldMethod();
        Thread t3 = new YieldMethod();
        t1.start(); 
        Thread.yield();
        t2.start();    
        t3.start();
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + ": " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } 
    }
}