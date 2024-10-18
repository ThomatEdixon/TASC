import entity.Animal;
import entity.Cat;
import entity.Dog;

import java.util.Scanner;

public class Main {

    public static void oop(){
        Animal myDog = new Dog("Husky");
        myDog.sound();  // Phải triển khai phương thức trừu tượng trong lớp cha
        myDog.eat();
        Animal myCat = new Cat("Indian Cat");
        myCat.sound(); //
    }
    public static void compareAbstractInterface(){
        Dog  dog = new Dog("Akita");
        dog.move();
    }
    public static void finalFunction(){
        Animal myDog = new Dog("Husky");
        myDog.sleep();
        myDog.speed();
        Animal myCat = new Cat("Indian Cat");
        myCat.sleep();
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("===== MENU =====");
            System.out.println("1. OOP");
            System.out.println("2.Compare Abstract Interface");
            System.out.println("3. Final Function");
            System.out.println("0. Exit");
            System.out.print("Choose an option (0-3): ");

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("OOP");
                    oop();
                    break;
                case 2:
                    System.out.println("Compare Abstract Interface");
                    compareAbstractInterface();
                    break;
                case 3:
                    System.out.println("Final Function");
                    finalFunction();
                    break;
                case 0:
                    System.out.println("Exiting the program...");
                    break;
                default:
                    System.out.println("Invalid choice. Please choose again.");
            }
        } while (choice != 0);
    }
}