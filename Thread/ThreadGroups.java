public class ThreadGroups extends Thread{
    @Override
    public void run() {
        // TODO Auto-generated method stub
        try{
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        ThreadGroup group = new ThreadGroup("thread Group 1");
        Thread t1 = new Thread(group, new ThreadGroups(), "Thread 1");
        Thread t2 = new Thread(group, new ThreadGroups(), "Thread 2");
        Thread t3 = new Thread(group, new ThreadGroups(), "Thread 3");
        
    }
}