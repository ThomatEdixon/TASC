import object.Test;

import java.util.Scanner;

public class Main {
    public static void question1(){
        /* Primitive Data type  */
        // byte b1 = 12345; // lỗi vì giá trị lưu trữ lớn  kích thước của kiểu dữ liệu
        byte b = 100 ;

        //int i = 123.56; //  lỗi vì sai kiểu dữ liệu short ko lưu trữ số thưc
        int i = 12345 ;

        //short s = 123.45; //  lỗi vì sai kiểu dữ liệu short ko lưu trữ số thưc
        short s = 32000;

        //long l = 176.289; //  lỗi vì sai kiểu dữ liệu short ko lưu trữ số thưc
        long l = 789780863;

        float f = 76.88f;

        double d = 8789676.867;

        //char c = 'asd'; // lỗi vì chả chỉ lưu trữ 1 ký tự
        //char c = 'a ';// lỗi chưa thêm khoảng trắng
        char c = 'a';
        char c1 = 35; // gán giá trị ASCII

        boolean result = true;

        System.out.println("Primitive Data type ");
        System.out.println("byte data type: " + b);
        System.out.println("int data type: " + i);
        System.out.println("short data type: " + s);
        System.out.println("long data type: " + l);
        System.out.println("float data type: " + f);
        System.out.println("double data type: " + d);
        System.out.println("char data type: " + c);
        System.out.println("char ASCII data type: " + c1);
        System.out.println("boolean data type: " + result);
        System.out.println("==============================") ;
        /*Object data type */
        System.out.println("Object Data type ");

        // Người dùng tự định nghĩa
        Test test = new Test(); // khởi tạo 1 dối tượng test bằng constructor() trong class Test

        // thực hiện các thao tác với đối tượng test dựa trên thuộc tính và phương thức được cung cấp trong lớp test.Test
        test.setCount(i); // set giá trị cho thuộc tính count bằng phương thức setCount()
        System.out.println("Count :" + test.getCount()); // lấy giá trị của thuộc tính count bằng phương thức  getCount()
        test.increase();// thực thi phương thức increase() để tăng giá trị biến count ;
        System.out.println("Count after increased :" + test.getCount());
    }
    public static void question2(){
        // chuyển dổi kiểu dữ liệu
        System.out.println("==============================") ;
        System.out.println("Boxing and Unboxing ");
        // Boxing
        int boxing = 10;
        Integer objInteger = boxing; // Boxing chuyển từ kiểu int sang object Interger
        System.out.println("After boxing ");
        System.out.println("Object Interger : " + objInteger);
        // Unboxing
        Integer unboxing = 20;
        int number = unboxing; // Unboxing chuyển từ kiểu object Interger về kiểu int
        System.out.println("After unboxing ");
        System.out.println("Number : "+ number);
    }
    public static void question3(){
        System.out.println("==============================") ;
        System.out.println("Compare primitive ");
        int a = 5;
        int b = 5;
        if (a == b) {
            System.out.println("a and b are same value");
        }

        System.out.println("==============================") ;
        System.out.println("Compare object ");
        String obj1 = new String("object");
        String obj2 = new String("object");
        if (obj1 == obj2) {
            System.out.println("obj1 and obj2 are same memory");
        } else {
            System.out.println("obj1 and obj2 are not same memory");
        }
        if (obj1.equals(obj2)) {
            System.out.println("obj1 and obj2 are same value");
        }else {
            System.out.println("obj1 and obj2 are not same value");
        }
        System.out.println("==============================") ;
        System.out.println("Compare primitive and object ");
        int number = 10;
        Integer objectNumber = 20;
        System.out.println(number>objectNumber);
    }
    public static void question4(){
        System.out.println("==============================") ;
        Test test = new Test();
        System.out.println("Default primitive value");
        System.out.println("Default value variable count in class test" + test.getCount());
        System.out.println("==============================") ;
        System.out.println("Default primitive object");
        System.out.println("Default value variable objectString in class test" + test.getObjectString());
        /*
        int i ;//  khởi tạo giá trị mặc định cho kiểu int
        System.out.println("Default value i :" + i); // lỗi do chưa gán giá trị mặc định cho biến i , vì biến i là biến cục bộ
        */
        int i =0;

    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("===== MENU =====");
            System.out.println("1. Question 1");
            System.out.println("2. Question 2");
            System.out.println("3. Question 3");
            System.out.println("4. Question 4");
            System.out.println("0. Exit");
            System.out.print("Choose an option (0-4): ");

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("You chose Question 1");
                    question1();
                    break;
                case 2:
                    System.out.println("You chose Question 2");
                    question2();
                    break;
                case 3:
                    System.out.println("You chose Question 3");
                    question3();
                    break;
                case 4:
                    System.out.println("You chose Question 4");
                    question4();
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