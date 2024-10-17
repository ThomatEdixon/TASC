import java.util.*;

enum Test { CODE, LEARN, CONTRIBUTE, QUIZ, MCQ };

public class Main {

    public static void hashSet(){
        HashSet<String> fruits = new HashSet<>();
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Kiwi");
        fruits.add("Orange");
        fruits.add("Apple");// thêm giá trị đã có từ trước
        for(String fruit : fruits){
            System.out.println(fruit);
        }

    }
    public static void linkedHashSet(){
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();

        // Thêm các phần tử vào LinkedHashSet
        linkedHashSet.add("Java");
        linkedHashSet.add("Python");
        linkedHashSet.add("C++");
        linkedHashSet.add("JavaScript");

        // Thêm phần tử trùng lặp
        linkedHashSet.add("Python"); // Sẽ không được thêm vào

        // Hiển thị các phần tử trong LinkedHashSet
        System.out.println("LinkedHashSet:");
        for (String language : linkedHashSet) {
            System.out.println(language);
        }

        // Kiểm tra một phần tử có tồn tại hay không
        if (linkedHashSet.contains("Java")) {
            System.out.println("\nJava exited in LinkedHashSet.");
        }

        // Xóa một phần tử
        linkedHashSet.remove("C++");
        System.out.println("\nAfter delete C++:");
        for (String language : linkedHashSet) {
            System.out.println(language);
        }

        // Kiểm tra kích thước của LinkedHashSet
        System.out.println("\nSize ofLinkedHashSet: " + linkedHashSet.size());

    }
    public static void treeSet(){
        // Sử dụng lambda để tạo Comparator sắp xếp chuỗi theo độ dài
        TreeSet<String> treeSet = new TreeSet<>((s1, s2) -> {
            int len1 = s1.length();
            int len2 = s2.length();

            if (len1 != len2) {
                return len1 - len2; // Sắp xếp theo độ dài tăng dần
            } else {
                return s1.compareTo(s2); // Nếu độ dài bằng nhau, sắp xếp theo thứ tự từ alphabet
            }
        });

        // Thêm các phần tử vào TreeSet
        treeSet.add("banana");
        treeSet.add("apple");
        treeSet.add("cherry");
        treeSet.add("kiwi");
        treeSet.add("grape");

        // In các phần tử trong TreeSet
        System.out.println("TreeSet order by lenght :");
        for (String fruit : treeSet) {
            System.out.println(fruit);
        }
    }
    public static void enumSet(){
        // tạo enum set
        EnumSet<Test> test = EnumSet.allOf(Test.class);
        System.out.println("EnumSet: " + test);


    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice ;
        do {
            System.out.println("====== MENU =====");
            System.out.println("1. HashSet");
            System.out.println("2. LinkedHashSet");
            System.out.println("3. TreeSet");
            System.out.println("4. EnumSet");
            System.out.println("0. Exit");
            System.out.println(" Choice option 0-4 : ");

            choice = scanner.nextInt();

            switch (choice){
                case 1:
                    System.out.println("HashSet");
                    hashSet();
                    break;
                case 2:
                    System.out.println("LinkedHashSet");
                    linkedHashSet();
                    break;
                case 3:
                    System.out.println("TreeSet");
                    treeSet();
                    break;
                case 4:
                    System.out.println("EnumSet");
                    enumSet();
                    break;
                case 0:
                    System.out.println("Exiting the program...");
                    break;
                default:
                    System.out.println("Invalid choice. Please choose again.");
            }
        }while (choice !=0 );
    }
}