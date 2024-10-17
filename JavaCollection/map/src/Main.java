import java.util.*;

public class Main {
    public static void hashMap(){
        HashMap<Integer, String> students = new HashMap<>();

        // Thêm các cặp khóa-giá trị (ID sinh viên, tên sinh viên) vào HashMap
        students.put(101, "Nguyen Van A");
        students.put(102, "Le Thi B");
        students.put(103, "Tran Van C");

        // Lấy và in tên sinh viên có ID là 102
        System.out.println("Student have ID 102 là: " + students.get(102));

        // Kiểm tra xem HashMap có chứa sinh viên với ID 104 hay không
        if (students.containsKey(104)) {
            System.out.println("Student have ID 104 là: " + students.get(104));
        } else {
            System.out.println("Can not find ID 104");
        }

        // Duyệt qua tất cả các phần tử trong HashMap và in ra
        System.out.println("\nList student:");
        for (Integer id : students.keySet()) {
            System.out.println("ID: " + id + ", Name: " + students.get(id));
        }
    }
    public static void linkedHashMap(){
        // Tạo LinkedHashMap và thêm các phần tử
        LinkedHashMap<Integer, String> linkedHashMap = new LinkedHashMap<>();

        linkedHashMap.put(1, "Apple");
        linkedHashMap.put(2, "Banana");
        linkedHashMap.put(3, "Orange");
        linkedHashMap.put(4, "Mango");

        // In các phần tử theo thứ tự chèn
        System.out.println("LinkedHashMap :");
        for (Map.Entry<Integer, String> entry : linkedHashMap.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }

        // Tạo LinkedHashMap theo thứ tự truy cập (access order)
        LinkedHashMap<Integer, String> accessOrderMap = new LinkedHashMap<>(16, 0.75f, true);

        accessOrderMap.put(1, "Apple");
        accessOrderMap.put(2, "Banana");
        accessOrderMap.put(3, "Orange");
        accessOrderMap.put(4, "Mango");

        // Truy cập một vài phần tử
        accessOrderMap.get(2);
        accessOrderMap.get(1);

        // In các phần tử theo thứ tự truy cập
        System.out.println("\nLinkedHashMap :");
        for (Map.Entry<Integer, String> entry : accessOrderMap.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }
    }
    public static void treeMap(){
        // Tạo một TreeMap
        TreeMap<Integer, String> treeMap = new TreeMap<>();

        // Thêm các phần tử vào TreeMap
        treeMap.put(3, "Apple");
        treeMap.put(1, "Banana");
        treeMap.put(4, "Orange");
        treeMap.put(2, "Grapes");

        // Hiển thị TreeMap
        System.out.println("Tree map:");
        for (Map.Entry<Integer, String> entry : treeMap.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }

        // Lấy phần tử đầu tiên và cuối cùng
        System.out.println("key first: " + treeMap.firstEntry());
        System.out.println("key last : " + treeMap.lastEntry());

        // Lấy các phần tử trong khoảng khóa
        System.out.println("Key from 2 to 4:");
        TreeMap<Integer, String> subMap = new TreeMap<>(treeMap.subMap(2, true, 4, true));
        for (Map.Entry<Integer, String> entry : subMap.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice ;
        do {
            System.out.println("====== MENU =====");
            System.out.println("1. HashMap");
            System.out.println("2. LinkedHashMap");
            System.out.println("3. TreeMap");
            System.out.println("0. Exit");
            System.out.println(" Choice option 0-3 : ");

            choice = scanner.nextInt();

            switch (choice){
                case 1:
                    System.out.println("HashMap");
                    hashMap();
                    break;
                case 2:
                    System.out.println("LinkedHashMap");
                    linkedHashMap();
                    break;
                case 3:
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