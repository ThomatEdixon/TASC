package data;

import entity.Customer;
import thread.FilePartReader;

import java.io.*;
import java.util.*;
import java.util.concurrent.*;

public class CustomerData {
    private static final String FILE_PATH = System.getProperty("user.dir").replace("\\","/")+"/data/customers.txt";
    private static final String BACKUP_PATH = System.getProperty("user.dir").replace("\\","/")+"/data/backup.txt";
    private static final int NUMBER_THREADS = 8;// 2042453851 10
                                                 //4100398417 1
    public static Map<String,Customer> LoadCustomerBuffer(){
        Map<String,Customer> customerMap = new HashMap<>();
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line = bufferedReader.readLine();
            while (line!=null){
                String[] info = line.split(",");
                String name = info[0];
                String email = info[1];
                String phoneNumber = info[2];
                Customer customer = new Customer(name,email,phoneNumber);
                customerMap.put(phoneNumber,customer);
            }

        }catch (IOException e){
            System.out.println(e.getMessage());
        }
        return customerMap;
    }
    public static Map<String,Customer> loadCustomers() throws InterruptedException, ExecutionException, IOException{
        ExecutorService executorService = Executors.newFixedThreadPool(NUMBER_THREADS);

        // chia kích thước cho tùng thread
        File file = new File(FILE_PATH);
        long fileSize = file.length();
        long partSize = fileSize / NUMBER_THREADS;  // Kích thước mỗi phần

        System.out.println("kich co file :" + fileSize);

        ConcurrentHashMap<Integer, String> resultsMap = new ConcurrentHashMap<>();  // Collection an toàn cho đa luồng
        List<Future<String>> futures = new ArrayList<>();  // Lưu kết quả Future của từng thread

        // Tạo các tác vụ đọc từng phần của tệp
        try (RandomAccessFile raf = new RandomAccessFile(file, "r")) {
            for (int i = 0; i < NUMBER_THREADS; i++) {
                long start = i * partSize;
                long end = (i == NUMBER_THREADS - 1) ? fileSize : (i + 1) * partSize;  // Phần cuối cùng lấy đến hết file

                Callable<String> task = new FilePartReader(FILE_PATH, start, end, i, resultsMap);
                Future<String> future = executorService.submit(task);
                futures.add(future);
            }
        }catch (Exception e){
            for (Future<String> future : futures) { // nếu đọc file bị exception thì sẽ lưu nhưng gì đã đọc được
                future.get();
            }
            System.out.println("Thread error");
        }
        for (Future<String> future : futures) {
            future.get();
        }

        // Đóng ExecutorService
        executorService.shutdown();

        // Chuyển từ về dạng hashmap
        Map<String,Customer> customers = new HashMap();
        for (String data : resultsMap.values()) {
            String[] lines = data.split(System.lineSeparator());
            for (String line : lines) {
                if (!line.trim().isEmpty()) {
                    String[] parts = line.split(",");
                    if (parts.length == 3) {
                        String name = parts[0].trim();
                        String email = parts[1].trim();
                        String phoneNumber = parts[2].trim();
                        customers.put(phoneNumber,new Customer(name, email, phoneNumber));
                    }
                }
            }
        }
        return customers;
    }

    public static void saveCustomers(Map<String,Customer> customers) throws IOException, ExecutionException, InterruptedException {
        Map<String,Customer> existingCustomer = new HashMap<>();
        existingCustomer = loadCustomers();
        Map<String,Customer> customerBackup = new HashMap<>();
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (Customer customer : customers.values()) {
                if(!existingCustomer.containsKey(customer.getPhoneNumber())){
                    existingCustomer.put(customer.getPhoneNumber(), customer);
                    bufferedWriter.write(customer.getName() + "," + customer.getEmail() + "," + customer.getPhoneNumber());
                    bufferedWriter.newLine();
                    customerBackup.put(customer.getPhoneNumber(), customer);
                }
            }
        } catch (IOException e) {
            saveBackup(customerBackup,BACKUP_PATH);
            System.out.println("Error saving customers: " + e.getMessage());
        }
    }
    private static void saveBackup(Map<String,Customer> dataBackup, String backupPath) {
        try (BufferedWriter backupWriter = new BufferedWriter(new FileWriter(backupPath))) {
            for (Customer customer : dataBackup.values()) {
                backupWriter.write(customer.getName() + "," + customer.getEmail() + "," + customer.getPhoneNumber());
                backupWriter.newLine();
            }
            System.out.println("Data save to backup: " + backupPath);
        } catch (IOException e) {
            System.err.println("Error backup: " + e.getMessage());
        }
    }
}

