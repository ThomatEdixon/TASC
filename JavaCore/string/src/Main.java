import java.util.Scanner;

public class Main {
    public static void question1(){
        // Tính bất biến
        System.out.println("Tính bất biến");
        String str = "Hello";
        str.concat(" World");  // Không thay đổi chuỗi ban đầu
        System.out.println("String before "+str);

        str = str.concat(" World");
        System.out.println("String after variable reassignment "+str);
        System.out.println(str);

        // cung cấp nhiều phương thức
        System.out.println("\n Cung cấp nhiều phương thức");
        String string = "Java Programming";

        System.out.println("Length: " + string.length());

        System.out.println("Character at index 5: " + string.charAt(5));

        System.out.println("Substring: " + string.substring(5, 16));

        System.out.println("Lowercase: " + string.toLowerCase());

        String str2 = "   Hello World   ";
        System.out.println("Trimmed: " + str2.trim());
        // biểu thức chính quy
        System.out.println("\n Biểu thức chính quy");
        String stringRegex = "abc123";

        // Kiểm tra chuỗi có khớp với mẫu biểu thức chính quy
        System.out.println(stringRegex.matches("[a-z]+[0-9]+"));  // true

        // Thay thế tất cả các chữ số bằng dấu '#'
        System.out.println(stringRegex.replaceAll("[0-9]", "#"));  // "abc###"

        // Tách chuỗi dựa trên biểu thức chính quy
        String stringRegexSplit = "one,two,three";
        String[] parts = stringRegexSplit.split(",");
        for (String part : parts) {
            System.out.println(part);
        }
    }
    public static void question2(){
        // tạo biến String lưu vào String pool
        String string1 = "Hello";
        String string2 = "Hello";
        // so sánh địa chỉ của s1 và s2 trong string pool;
        System.out.println(string1 == string2);

        // đưa 1 đối tượng String khởi tạo bằng new vào String pool
        String string3 = new String("Hello");

        String string4 = string3.intern();  // Thêm string3 vào String Pool
        System.out.println("Compare string 1 and string 3"+ string1 == string3);
        System.out.println("Compare string 1 and string 4"+string1 == string4);

    }
    public static void question3(){
        // tạo biến bằng ký tự ""
        String str1 = "Hello";
        System.out.println(str1);

        // tạo chuỗi bằng từ khoá new
        String str2 = new String("Java");
        System.out.println(str2);

        // Tạo chuỗi từ mảng ký tự
        char[] charArray = {'H', 'e', 'l', 'l', 'o'};
        String str3 = new String(charArray);
        System.out.println(str3);

        // Tạo chuỗi từ đối tượng khác thông qua phương thức valueOf()
        int num = 100;
        String str4 = String.valueOf(num);
        System.out.println(str4);

        // Tạo chuỗi từ StringBuilder hoặc StringBuffer
        StringBuilder sb = new StringBuilder("Programming");
        String str5 = sb.toString();
        System.out.println(str5);

        // Sử dụng phương thức concat()
        String str6 = str1.concat(" World");
        System.out.println(str6);

    }
    public static void question4(){
        String str1 = "Hello";
        String str2 = new String("Hello");
        String str3 = "HELLO";
        // so sánh bằng toán tử == so sánh địa chỉ bộ nhớ của str1 và str2
        System.out.println(str1 == str2);

        //so sánh bằng hàm equals() nội dung hai biến str1 và str2
        System.out.println(str1.equals(str2));

        // so sánh nội dung hai biến str1 và str3 sử dụng phương thức equalsIgnoreCase()
        System.out.println(str1.equals(str3));

        // so sánh bằng phương thức compareTo()
        String string1 = "apple";
        String string2 = "banana";

        System.out.println(str1.compareTo(str2));

    }
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("===== MENU =====");
            System.out.println("1. Đặc điểm và tính chất của String trong java");
            System.out.println("2. String pool");
            System.out.println("3. Cách để tạo 1 biến String");
            System.out.println("4. So sánh hai chuỗi trong java");
            System.out.println("0. Exit");
            System.out.print("Choose an option (0-4): ");

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Đặc điểm và tính chất của String trong java");
                    question1();
                    break;
                case 2:
                    System.out.println("String pool");
                    question2();
                    break;
                case 3:
                    System.out.println("Cách để tạo 1 biến String");
                    question3();
                    break;
                case 4:
                    System.out.println("So sánh hai chuỗi trong java");
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