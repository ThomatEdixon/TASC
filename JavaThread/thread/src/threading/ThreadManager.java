package threading;

import java.util.ArrayList;
import java.util.List;

public class ThreadManager {
    private static List<Thread> threads = new ArrayList<>();

    public ThreadManager() {
    }

    public ThreadManager(List<Thread> threads) {
        this.threads = threads;
    }

    //  thêm một thread mới vào danh sách quản lý
    public void addThread(Thread newThread) {
        threads.add(newThread);
    }

    // Bắt đầu tất cả các thread
    public void startAllThreads() {
        for (Thread thread : threads) {
            thread.start();
        }
    }

    // Đợi cho tất cả các thread hoàn thành công việc của mình
    public void joinAllThreads() {
        for (Thread thread : threads) {
            try {
                thread.join();  // Đợi cho đến khi thread kết thúc
            } catch (InterruptedException e) {
                System.out.println(thread.getName() + " was interrupted during join.");
            }
        }
    }

    // Kiểm tra trạng thái của các thread (có đang chạy không)
    public List<Boolean> checkAliveThreads() {
        List<Boolean> aliveStatus = new ArrayList<>();
        for (Thread thread : threads) {
            aliveStatus.add(thread.isAlive());  // Kiểm tra thread có đang chạy không
        }
        return aliveStatus;
    }

    // Kiểm tra xem tất cả các thread đã đóng hay chưa
    public boolean areAllThreadsClosed() {
        for (Thread thread : threads) {
            if (thread.isAlive()) {
                return false;
            }
        }
        return true;
    }
}
