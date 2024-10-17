import object.ListPerformance;
import object.MapPerformance;
import object.QueuePerformance;
import object.SetPerformance;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int numberElements = 10000;

        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("===== MENU =====");
            System.out.println("1. List Performance");
            System.out.println("2.Set Performance");
            System.out.println("3. Map Performance");
            System.out.println("4. Queue Performance ");
            System.out.println("5. Compare performance for all interface collections.");
            System.out.println("0. Exit");
            System.out.print("Choose an option (0-5): ");

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("==== List Performance ====");
                    ListPerformance.comparePerformance(numberElements);
                    break;
                case 2:
                    System.out.println("==== Set Performance ====");
                    SetPerformance.comparePerformance(numberElements);
                    break;
                case 3:
                    System.out.println("==== Map Performance ====");
                    MapPerformance.comparePerformance(numberElements);
                    break;
                case 4:
                    System.out.println("==== Queue Performance ====");
                    QueuePerformance.comparePerformance(numberElements);
                    break;
                case 5:
                    System.out.println("Compare performance for all interface collections.");
                    comparePerformanceAllInterfaceCollections(numberElements);
                case 0:
                    System.out.println("Exiting the program...");
                    break;
                default:
                    System.out.println("Invalid choice. Please choose again.");
            }
        } while (choice != 0);
    }
    public static void comparePerformanceAllInterfaceCollections(int numberElements){

        System.out.println("==== List Performance ====");
        ListPerformance.comparePerformance(numberElements);

        System.out.println("==== Set Performance ====");
        SetPerformance.comparePerformance(numberElements);

        System.out.println("==== Map Performance ====");
        MapPerformance.comparePerformance(numberElements);

        System.out.println("==== Queue Performance ====");
        QueuePerformance.comparePerformance(numberElements);
    }
}