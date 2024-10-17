import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

public class Main {
    public static void queue(){
        // Triển khai queue với linkedList;
        Queue<String> queue = new LinkedList<>();

        // thêm phần tử
        queue.add("apple");
        queue.add("banana");
        queue.add("cherry");

        // in phần tử trong queue
        System.out.println("Queue: " + queue);

        // xoá phần tử
        String front = queue.remove();
        System.out.println("Removed element: " + front);
        System.out.println("Queue after removal: " + queue);

        // thêm phần tử
        queue.add("date");

        // sử dụng hàm  lấy ra phần tử đầu
        String peeked = queue.peek();
        System.out.println("Peeked element: " + peeked);
        System.out.println("Queue after peek: " + queue);
    }
    public static void classImplementQueueInterface() throws InterruptedException { // throws exception do arrayBlockedQueue sử dụng trong môi trường đa luồng
        // Priority Queue
        System.out.println("PriorityQueue");
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.add(10);
        queue.add(30);
        queue.add(20);
        // queue.add(null); //  hàng đợi không lưu giá trị null
        System.out.println("Peek: " + queue.peek());
        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }

        // Queue triển khai với linked list
        System.out.println("Linked List");
        Queue<String> linkedQueue = new LinkedList<>();
        linkedQueue.add("Alice");
        linkedQueue.add("Charlie");
        linkedQueue.add("Bob");
        System.out.println("Peek: " + queue.peek());
        while (!linkedQueue.isEmpty()) {
            System.out.println(linkedQueue.poll());
        }
        // ArrayBlockedQueue
        System.out.println("ArrayBlockedQueue");
        BlockingQueue<Integer> arrayBlockedQueue = new ArrayBlockingQueue<>(3);

        arrayBlockedQueue.put(1);
        arrayBlockedQueue.put(2);
        arrayBlockedQueue.put(3);
        while (!arrayBlockedQueue.isEmpty()) {
            System.out.println(arrayBlockedQueue.take());
        }
        //PriorityBlockingQueue
        System.out.println("PriorityBlockingQueue");
        PriorityBlockingQueue<Integer> priorityBlockingQueue = new PriorityBlockingQueue<>();

        priorityBlockingQueue.put(30);
        priorityBlockingQueue.put(10);
        priorityBlockingQueue.put(20);

        System.out.println(priorityBlockingQueue.take());
    }
    public static void classImplementDeque(){
        // Deque với linked list
        System.out.println("Deque with Linked list");
        Deque<String> deque = new LinkedList<>();

        deque.add("Alice");
        deque.add("Bob");
        deque.add("Charlie");
        deque.add(null);

        deque.addFirst("Jack");
        deque.addLast("John");

        System.out.println(deque.pollFirst());
        System.out.println(deque.pollLast());
        // ArrayDeque
        System.out.println("ArrayDeque: ");
        Deque<Integer> arrayDeque = new ArrayDeque<>();
        arrayDeque.add(10);
        arrayDeque.add(20);
        arrayDeque.add(30);
        arrayDeque.add(40);
        arrayDeque.addFirst(null);
        System.out.println(deque.pollFirst());
        System.out.println(deque.pollLast());


    }
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("===== MENU =====");
            System.out.println("1. Queue Interface");
            System.out.println("2.Class implement queue interface");
            System.out.println("3. Deque interface and class implement");
            System.out.println("0. Exit");
            System.out.print("Choose an option (0-3): ");

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Queue Interface");
                    queue();
                    break;
                case 2:
                    System.out.println("Class implement queue interface");
                    classImplementQueueInterface();
                    break;
                case 3:
                    System.out.println("Deque interface and class implement");
                    classImplementDeque();
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