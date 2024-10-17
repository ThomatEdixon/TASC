import java.util.*;

public class Main {
    public static void listExample(){
        List<String> fruits = new ArrayList<>();

        // Thêm phần tử vào danh sách
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Orange");
        System.out.println("List fruits:");
        for (String fruit : fruits) {
            System.out.println(fruit);
        }

        // Thêm phần tử vào vị trí chỉ định
        fruits.add(1, "Mango");  // Thêm "Mango" vào vị trí thứ 1

        // Lấy và in phần tử theo chỉ mục
        System.out.println("Index of 1: " + fruits.get(1)); // In "Banana"

        fruits.set(2, "Grapes");  // Cập nhật phần tử tại vị trí 2 thành "Grapes"

        // Xóa phần tử tại vị trí chỉ định
        fruits.remove(3);  // Xóa phần tử tại vị trí 3 (Orange)

        // Duyệt qua các phần tử trong danh sách bằng vòng lặp for-each
        System.out.println("List fruits:");
        for (String fruit : fruits) {
            System.out.println(fruit);
        }

        // Kiểm tra kích thước danh sách
        System.out.println("List size: " + fruits.size());

        // Kiểm tra danh sách có chứa phần tử cụ thể không
        if (fruits.contains("Apple")) {
            System.out.println("List contains 'Apple'");
        }

        // Xóa tất cả phần tử khỏi danh sách
        fruits.clear();
        System.out.println("List after delete all: " + fruits);
    }
    public static void arrayList(){
        List<String> arrayList = new ArrayList<>();
        arrayList.add("Apple");
        arrayList.add("Banana");
        arrayList.add("Orange");
        System.out.println(arrayList.get(1));

    }
    public static void linkedList(){
        List<String> linkedList = new LinkedList<>();
        linkedList.add("Car");
        linkedList.add("Bike");
        linkedList.add("Bus");
        linkedList.remove(1);
        System.out.println(linkedList);

    }
    public static void stack(){
        // Create a new stack
        Stack<Integer> stack = new Stack<>();

        // Push elements onto the stack
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        // Pop elements from the stack
        while(!stack.isEmpty()) {
            System.out.println(stack.pop());
        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("===== MENU =====");
            System.out.println("1. List interface");
            System.out.println("2. Array list");
            System.out.println("3. Linked list");
            System.out.println("4. Stack");
            System.out.println("0. Exit");
            System.out.print("Choose an option (0-4): ");

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("List interface");
                    listExample();
                    break;
                case 2:
                    System.out.println("Array list");
                    arrayList();
                    break;
                case 3:
                    System.out.println("Linked list");
                    linkedList();
                    break;
                case 4:
                    System.out.println("Stack");
                    stack();
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