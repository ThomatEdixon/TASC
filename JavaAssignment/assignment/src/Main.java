import data.CustomerData;
import entity.Customer;
import validation.CustomerValidation;

import java.util.*;

public class Main {
    private static Map<String, Customer> customerMap = new HashMap<>();
    public static long startTime = System.nanoTime();
    public static long endTime = System.nanoTime();

    public static void main(String[] args) {
        startTime = System.nanoTime();
        ArrayList<Customer> customers = CustomerData.loadCustomers();
        endTime = System.nanoTime();
        for (Customer customer: customers){
            customerMap.put(customer.getPhoneNumber(),customer);
        }
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
            try {
                System.out.print("Enter name: ");
                String name = scanner.nextLine();
                System.out.print("Enter email: ");
                String email = scanner.nextLine();
                System.out.print("Enter phone number: ");
                String phoneNumber = scanner.nextLine();

                CustomerValidation.validateCustomer(name, email, phoneNumber, customerMap);
                startTime = System.nanoTime();
                Customer newCustomer = new Customer(name, email, phoneNumber);
                customerMap.put(phoneNumber,newCustomer);
                endTime = System.nanoTime();
                System.out.println("Time to add 1 customer: " + (endTime - startTime) + " ns");
                System.out.println("Customer added successfully.");

            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage() + "\n Please enter valid customer information.");
                i--; // Retry the current customer

            }
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
            try {
                System.out.print("Enter new name : ");
                String name = scanner.nextLine();
                System.out.print("Enter new email : ");
                String email = scanner.nextLine();
                System.out.print("Enter new phone number : ");
                String newPhoneNumber = scanner.nextLine();

                if (!name.isEmpty()) {
                    existingCustomer.setName(name);
                }
                if (!email.isEmpty()) {
                    CustomerValidation.validateCustomer(existingCustomer.getName(), email, existingCustomer.getPhoneNumber(), customerMap);
                    existingCustomer.setEmail(email);
                }
                if (!newPhoneNumber.isEmpty() && !newPhoneNumber.equals(phoneNumber)) {
                    CustomerValidation.validateCustomer(existingCustomer.getName(), existingCustomer.getEmail(), newPhoneNumber, customerMap);
                    existingCustomer.setPhoneNumber(newPhoneNumber);
                    customerMap.put(newPhoneNumber, existingCustomer);
                }

                System.out.println("Customer updated successfully.");

            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
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
