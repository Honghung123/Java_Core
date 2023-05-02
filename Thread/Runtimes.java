import java.io.IOException;

public class Runtimes{
    public static void main(String[] args) {
        try {
            Runtime r = Runtime.getRuntime();
            System.out.println(r.availableProcessors());
            System.out.println(r.totalMemory()/1024/1024);
            System.out.println(r.freeMemory() / 1024 / 1024);
       
        } catch (Exception e) { 
            e.printStackTrace();
        }
    }
}
