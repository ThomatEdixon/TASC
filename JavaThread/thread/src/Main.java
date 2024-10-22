import object.TestThread;
import threading.ThreadManager;
import threading.ThreadPool;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            // Hiển thị menu
            System.out.println("\n===== Menu =====");
            System.out.println("1. Start Individual Threads");
            System.out.println("2. Manage Multiple Threads with ThreadManager");
            System.out.println("3. Use Thread Pool with ThreadPoolManager");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    startIndividualThreads();
                    break;
                case 2:
                    manageMultipleThreadsWithThreadManager();
                    break;
                case 3:
                    useThreadPoolWithThreadPoolManager();
                    break;
                case 4:
                    exit = true;
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid choice! Please choose again.");
            }
        }

        scanner.close();
    }
    public static void startIndividualThreads() {
        Thread thread1 = new Thread(new TestThread("Thread-1", 2000));
        Thread thread2 = new Thread(new TestThread("Thread-2", 1000));
        Thread thread3 = new Thread(new TestThread("Thread-3", 3000));
        thread1.start();
        thread2.start();
        thread3.start();

        try {
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            System.out.println("A thread was interrupted.");
        }

        System.out.println("All individual threads have finished.");
    }

    public static void manageMultipleThreadsWithThreadManager() {
        Thread thread1 = new Thread(new TestThread("Thread-1", 2000));
        Thread thread2 = new Thread(new TestThread("Thread-2", 1000));
        Thread thread3 = new Thread(new TestThread("Thread-3", 3000));
        ThreadManager manager = new ThreadManager();
        manager.addThread(thread1);
        manager.addThread(thread2);
        manager.addThread(thread3);

        // Bắt đầu chạy  các thread
        manager.startAllThreads();
        System.out.println("All threads have started.");

        // Kiểm tra trạng thái của từng thread sau khi start
        List<Boolean> aliveStatus = manager.checkAliveThreads();
        System.out.println("Thread alive statuses after start: " + aliveStatus);

        // Đợi tất cả các thread hoàn thành
        manager.joinAllThreads();
        System.out.println("All threads have finished.");

        // Kiểm tra lại trạng thái thread
        aliveStatus = manager.checkAliveThreads();
        System.out.println("Thread alive statuses after join: " + aliveStatus);

        // Kiểm tra nếu tất cả các thread đã đóng
        System.out.println("Are all threads closed? " + manager.areAllThreadsClosed());
    }

    // Lựa chọn 3: Sử dụng Thread Pool với ThreadPoolManager
    public static void useThreadPoolWithThreadPoolManager() {
        Thread thread1 = new Thread(new TestThread("Thread-1", 2000));
        Thread thread2 = new Thread(new TestThread("Thread-2", 1000));
        Thread thread3 = new Thread(new TestThread("Thread-3", 3000));
        ThreadPool poolManager = new ThreadPool(2);

        poolManager.submitTask(thread1);
        poolManager.submitTask(thread2);
        poolManager.submitTask(thread3);

        // Đóng thread pool (không nhận thêm task)
        poolManager.shutdown();
        System.out.println("Thread pool shutdown initiated.");

        // Đợi cho đến khi tất cả các task hoàn thành
        poolManager.awaitTermination();
        System.out.println("All tasks in pool have finished.");

        // Kiểm tra nếu tất cả các task đã kết thúc
        System.out.println("All threads in pool have finished? " + poolManager.isTerminated());
    }
}
