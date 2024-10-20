import data.CustomerData;
import entity.Customer;
import validation.CustomerValidation;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<Customer> customers = new ArrayList<>();

    public static void main(String[] args) {
        customers = CustomerData.loadCustomers();
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
                    CustomerData.saveCustomers(customers);
                    System.exit(0);
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }

    private static void viewCustomers() {
        if (customers.isEmpty()) {
            System.out.println("No customers available.");
        } else {
            customers.forEach(customer -> System.out.println(customer.toString()));
        }
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

                CustomerValidation.validateCustomer(name, email, phoneNumber, customers);

                customers.add(new Customer(name, email, phoneNumber));
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
        Customer foundCustomer = customers.stream()
                .filter(c -> c.getPhoneNumber().equals(phoneNumber))
                .findFirst()
                .orElse(null);

        if (foundCustomer != null) {
            System.out.println("Customer found: " + foundCustomer);
        } else {
            System.out.println("Customer not found.");
        }
    }

    private static void editCustomer(Scanner scanner) {
        System.out.print("Enter phone number of the customer to edit: ");
        String phoneNumber = scanner.nextLine();
        Customer existingCustomer = customers.stream()
                .filter(c -> c.getPhoneNumber().equals(phoneNumber))
                .findFirst()
                .orElse(null);

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
                    CustomerValidation.validateCustomer(existingCustomer.getName(), email, existingCustomer.getPhoneNumber(), customers);
                    existingCustomer.setEmail(email);
                }
                if (!newPhoneNumber.isEmpty()) {
                    CustomerValidation.validateCustomer(existingCustomer.getName(), existingCustomer.getEmail(), newPhoneNumber, customers);
                    existingCustomer.setPhoneNumber(newPhoneNumber);
                }

                System.out.println("Customer updated successfully.");

            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        } else {
            System.out.println("Customer not found.");
        }
    }

    private static void deleteCustomer(Scanner scanner) {
        System.out.print("Enter phone number of the customer to delete: ");
        String phoneNumber = scanner.nextLine();
        customers.removeIf(c -> c.getPhoneNumber().equals(phoneNumber));
        System.out.println("Customer deleted successfully.");
    }
}
