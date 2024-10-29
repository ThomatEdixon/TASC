import data.CustomerData;
import entity.Customer;
import validation.CustomerValidation;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.ExecutionException;

public class Main {
    private static Map<String, Customer> customerMap = new HashMap<>();
    public static long startTime = System.nanoTime();
    public static long endTime = System.nanoTime();

    public static void main(String[] args) throws InterruptedException, ExecutionException, IOException {
        startTime = System.nanoTime();
        customerMap = CustomerData.LoadCustomerBuffer();
        endTime = System.nanoTime();
        System.out.println("Time to read file: " + (endTime - startTime) + " ns");
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Customer Management ---");
            System.out.println("1. View Customers");
            System.out.println("2. Add Customers");
            System.out.println("3. Search by Phone Number");
            System.out.println("4. Edit Customer");
            System.out.println("5. Delete Customer");
            System.out.println("6. Exit");

            System.out.print("Select an option: ");
            int option = scanner.nextInt();
            scanner.nextLine();  // Clear the buffer

            switch (option) {
                case 1:
                    viewCustomers();
                    break;
                case 2:
                    addCustomers(scanner);
                    break;
                case 3:
                    searchByPhoneNumber(scanner);
                    break;
                case 4:
                    editCustomer(scanner);
                    break;
                case 5:
                    deleteCustomer(scanner);
                    break;
                case 6:
                    startTime = System.nanoTime();
                    CustomerData.saveCustomers(customerMap);
                    endTime = System.nanoTime();
                    System.out.println("Time to write file: " + (endTime - startTime) + " ns");
                    System.exit(0);
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }

    private static void viewCustomers() {
        startTime = System.nanoTime();
        if (customerMap.isEmpty()) {
            System.out.println("No customers available.");
        } else {
            for (Customer customer : customerMap.values()) {
                System.out.println(customer.toString());
            }
        }
        endTime = System.nanoTime();
        System.out.println("Time to view customer: " + (endTime - startTime) + " ns");
    }

    private static void addCustomers(Scanner scanner) {
        System.out.print("Enter the number of customers to add: ");
        int n = scanner.nextInt();
        scanner.nextLine();  // Clear the buffer

        for (int i = 0; i < n; i++) {
            System.out.print("Enter name: ");
            String name = scanner.nextLine();
            while (!CustomerValidation.validateName(name)){
                System.out.println("Name cannot be null or empty. Please , try again !\n");
                System.out.print("Enter name: ");
                name = scanner.nextLine();
            }
            System.out.print("Enter email: ");
            String email = scanner.nextLine();
            while (!CustomerValidation.validateEmail(email)){ // có nên tạo hàm static để tái sử dụng ko ?
                System.out.println("Invalid email format.\n" + "Please enter a valid email format (e.g., user123@example.com).");
                System.out.print("Enter email: ");
                email = scanner.nextLine();
            }
            System.out.print("Enter phone number: ");
            String phoneNumber = scanner.nextLine();
            while (!CustomerValidation.validatePhoneNumber(phoneNumber)){
                System.out.println("Phone number must be 10 digits.Please, try again !");
                System.out.print("Enter phone number: ");
                phoneNumber = scanner.nextLine();
            }
            while (!CustomerValidation.validateDuplicate(phoneNumber,customerMap)){
                System.out.println("Phone number already exists.Please, try again !");
                System.out.print("Enter phone number: ");
                phoneNumber = scanner.nextLine();
            }
            startTime = System.nanoTime();
            Customer newCustomer = new Customer(name, email, phoneNumber);
            customerMap.put(phoneNumber,newCustomer);
            endTime = System.nanoTime();
            System.out.println("Time to add 1 customer: " + (endTime - startTime) + " ns");
            System.out.println("Customer added successfully.");
        }
    }

    private static void searchByPhoneNumber(Scanner scanner) {
        System.out.print("Enter phone number to search: ");
        String phoneNumber = scanner.nextLine();
        startTime = System.nanoTime();
        Customer customer = customerMap.get(phoneNumber);
        if (customer != null) {
            System.out.println(customer);
        } else {
            System.out.println("Customer not found.");
        }
        endTime = System.nanoTime();
        System.out.println("Time to search customer: " + (endTime - startTime) + " ns");
    }

    private static void editCustomer(Scanner scanner) {
        System.out.print("Enter phone number of the customer to edit: ");
        String phoneNumber = scanner.nextLine();
        startTime = System.nanoTime();
        Customer existingCustomer = customerMap.get(phoneNumber);
        if (existingCustomer != null) {
            System.out.print("Enter new name (Leave if you don't want change ) : ");
            String name = scanner.nextLine();
            System.out.print("Enter new email (Leave if you don't want change ) : ");
            String email = scanner.nextLine();
            System.out.print("Enter new phone number (Leave if you don't want change ) : ");
            String newPhoneNumber = scanner.nextLine();
            if(name.isEmpty() && email.isEmpty() && (newPhoneNumber.isEmpty()||newPhoneNumber.equals(phoneNumber))){
                System.out.println("You not change anything.");
            }else {
                if (!name.isEmpty()) {
                    existingCustomer.setName(name);
                }
                if (!email.isEmpty()) {
                    while(!CustomerValidation.validateEmail(email)){
                        System.out.println("Invalid email format.\n" + "Please enter a valid email format (e.g., user123@example.com).");
                        System.out.print("Enter new email (Leave if you don't want change ) : ");
                        email = scanner.nextLine();
                    }
                    existingCustomer.setEmail(email);
                }
                if (!newPhoneNumber.isEmpty() && !newPhoneNumber.equals(phoneNumber)) {
                    while (!CustomerValidation.validatePhoneNumber(newPhoneNumber)){
                        System.out.println("Phone number must be 10 digits.Please, try again !");
                        System.out.print("Enter new phone number (Leave if you don't want change ) : ");
                        newPhoneNumber = scanner.nextLine();
                    }
                }
                System.out.println("Customer updated successfully.");
            }
        } else {
            System.out.println("Customer not found.");
        }
        endTime = System.nanoTime();
        System.out.println("Time to edit customer: " + (endTime - startTime) + " ns");
    }

    private static void deleteCustomer(Scanner scanner) {
        System.out.print("Enter phone number of the customer to delete: ");
        String phoneNumber = scanner.nextLine();
        startTime = System.nanoTime();
        Customer customerToRemove = customerMap.get(phoneNumber); // lấy customer tương ứng với key phoneNumber trong map .

        if (customerToRemove != null) {
            customerMap.remove(phoneNumber);
            System.out.println("Customer deleted successfully.");
        } else {
            System.out.println("Customer not found.");
        }
        endTime = System.nanoTime();
        System.out.println("Time to delete customer: " + (endTime - startTime) + " ns");
    }
}
