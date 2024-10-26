package thread;

import java.io.*;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;

public class FilePartReader implements Callable<String> {
    private final String filePath;
    private final long start;
    private final long end;
    private final int partNumber;
    private final ConcurrentHashMap<Integer, String> resultsMap;

    public FilePartReader(String filePath,long start, long end, int partNumber, ConcurrentHashMap<Integer, String> resultsMap) {
        this.filePath=filePath;
        this.start = start;
        this.end = end;
        this.partNumber = partNumber;
        this.resultsMap = resultsMap;
    }

    @Override
    public String call() throws IOException {

        // Mỗi thread tạo một đối tượng RandomAccessFile riêng biệt
        try (RandomAccessFile raf = new RandomAccessFile(filePath, "r")) {
            raf.seek(start);  // Đặt con trỏ file tại vị trí bắt đầu

            StringBuilder result = new StringBuilder();
            long currentPosition = start;
            boolean isFirstLine = true;

            // Đọc từng ký tự một để đảm bảo không bị bỏ sót hoặc đọc nhầm dòng
            while (currentPosition < end) {
                String line = readLine(raf);
                currentPosition = raf.getFilePointer();  // Cập nhật vị trí đọc hiện tại

                // Nếu là dòng đầu tiên trong phần và bắt đầu không phải từ đầu file, bỏ qua phần bị cắt của dòng
                if (isFirstLine && start != 0) {
                    isFirstLine = false;  // Dòng đầu tiên, có thể bị cắt bỏ
                    continue;
                }

                result.append(line).append(System.lineSeparator());
            }

            // Lưu kết quả vào ConcurrentHashMap
            resultsMap.put(partNumber, result.toString());

            // Trả về kết quả của thread
            return "Thread " + partNumber + " complete.";
        }
    }

    private String readLine(RandomAccessFile raf) throws IOException {
        StringBuilder sb = new StringBuilder();
        int c;
        while ((c = raf.read()) != -1) {
            if (c == '\n') {
                break;
            }
            sb.append((char) c);
        }
        return sb.toString();
    }
}
