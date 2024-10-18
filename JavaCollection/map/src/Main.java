import performance.HashMapPerformance;
import performance.LinkedHashMapPerformance;
import performance.TreeMapPerformance;

import java.util.*;

public class Main {
    public static void map(){
        Map<String, Integer> students = new HashMap<>();

        // Thêm phần tử vào Map (sử dụng phương thức put)
        students.put("John", 85);
        students.put("Alice", 92);
        students.put("Bob", 75);
        students.put("Daisy", 89);

        // Truy xuất giá trị theo khóa (sử dụng phương thức get)
        System.out.println("Alice score is: " + students.get("Alice"));

        // Xóa phần tử dựa trên khóa (sử dụng phương thức remove)
        students.remove("Bob");
        System.out.println("Map after remove Bob: " + students);

        // Kiểm tra xem một khóa có tồn tại hay không (sử dụng phương thức containsKey)
        boolean hasJohn = students.containsKey("John");
        System.out.println("is John exist in map? " + hasJohn);

        // Kiểm tra xem một giá trị có tồn tại hay không (sử dụng phương thức containsValue)
        boolean hasScore92 = students.containsValue(92);
        System.out.println("Have anyone have 92? " + hasScore92);

        // Lấy tất cả các khóa (sử dụng phương thức keySet)
        System.out.println("List Student: " + students.keySet());

        // Lấy tất cả các giá trị (sử dụng phương thức values)
        System.out.println("List score: " + students.values());

        // Lấy tất cả các cặp khóa-giá trị (sử dụng phương thức entrySet)
        System.out.println("List student and score:");
        for (Map.Entry<String, Integer> entry : students.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
    public static void hashMap(){
        HashMapPerformance hashMapPerformance = new HashMapPerformance();
        hashMapPerformance.performanceAdd();
        hashMapPerformance.performanceDelete();
        hashMapPerformance.performanceIterator();
        hashMapPerformance.performanceSearch();
    }
    public static void linkedHashMap(){
        LinkedHashMapPerformance linkedHashMapPerformance = new LinkedHashMapPerformance();
        linkedHashMapPerformance.performanceAdd();
        linkedHashMapPerformance.performanceDelete();
        linkedHashMapPerformance.performanceIterator();
        linkedHashMapPerformance.performanceSearch();

    }
    public static void treeMap(){
        TreeMapPerformance treeMapPerformance = new TreeMapPerformance();
        treeMapPerformance.performanceAdd();
        treeMapPerformance.performanceDelete();
        treeMapPerformance.performanceIterator();
        treeMapPerformance.performanceSearch();

    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice ;
        do {
            System.out.println("====== MENU =====");
            System.out.println("1. Map Interface");
            System.out.println("2. HashMap");
            System.out.println("3. LinkedHashMap");
            System.out.println("4. TreeMap");
            System.out.println("0. Exit");
            System.out.println(" Choice option 0-4 : ");

            choice = scanner.nextInt();

            switch (choice){
                case 1:
                    System.out.println("Map Interface");
                    map();
                    break;
                case 2:
                    System.out.println("HashMap");
                    hashMap();
                    break;
                case 3:
                    System.out.println("LinkedHashMap");
                    linkedHashMap();
                    break;
                case 4:
                    System.out.println("TreeMap");
                    treeMap();
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