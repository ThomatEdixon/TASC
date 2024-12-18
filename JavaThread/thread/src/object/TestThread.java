package object;

public class TestThread implements Runnable{
    private String threadName;
    private int sleepTime;
    private static int count;

    public TestThread() {
    }

    public TestThread(String threadName, int sleepTime) {
        this.threadName = threadName;
        this.sleepTime = sleepTime;
    }

    @Override
    public void run() {
        count++;
        System.out.println(threadName + " is starting.");
        try {
            Thread.sleep(sleepTime);  // Thread sẽ tạm nghỉ một thời gian
        } catch (InterruptedException e) {
            System.out.println(threadName + e.getMessage());
        }
        System.out.println("count : "+ count);
        System.out.println(threadName + " has finished.");
    }
}
