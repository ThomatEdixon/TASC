package async_sync;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Sync {
    public static void ExampleSync(){
        System.out.println("Start");
        try {
            Thread.sleep(5000); // Chờ 5 giây
            System.out.println("Task completed");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("End");

    }
}
