package threading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadPool {
    private ExecutorService executorService;

    // Khởi tạo thread pool với số lượng thread cố định

    public ThreadPool() {
    }

    public ThreadPool(int poolSize) {
        this.executorService = Executors.newFixedThreadPool(poolSize);
    }

    // Thực thi một task trong pool
    public void submitTask(Runnable task) {
        executorService.submit(task);
    }

    // Đóng pool, không nhận thêm task mới
    public void shutdown() {
        executorService.shutdown();
    }

    // Đợi cho đến khi tất cả các task hoàn thành
    public void awaitTermination() {
        try {
            if (!executorService.awaitTermination(60, TimeUnit.SECONDS)) {
                executorService.shutdownNow();  // Bắt buộc shutdown nếu thời gian chờ hết
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
        }
    }

    // Kiểm tra nếu tất cả các task đã hoàn thành
    public boolean isTerminated() {
        return executorService.isTerminated();
    }
}
