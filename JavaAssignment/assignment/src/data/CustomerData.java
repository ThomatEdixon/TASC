package data;

import entity.Customer;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerData {
    private static final String FILE_PATH = System.getProperty("user.dir").replace("\\","/")+"/data/customers.txt";

    public static List<Customer> loadCustomers() {
        List<Customer> customers = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    customers.add(new Customer(parts[0], parts[1], parts[2]));
                }
            }
        } catch (IOException e) {
            System.out.println("Error loading customers: " + e.getMessage());
        }
        return customers;
    }

    public static void saveCustomers(List<Customer> customers) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (Customer customer : customers) {
                bw.write(customer.getName() + "," + customer.getEmail() + "," + customer.getPhoneNumber());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving customers: " + e.getMessage());
        }
    }
}

