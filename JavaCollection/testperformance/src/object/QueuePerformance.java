package object;

import java.util.*;

public class QueuePerformance {
        /*==== Queue Performance ====
        Testing LinkedList
        Time to offer: 1819308 ns
        Time to iterate: 1064117 ns
        Time to search: 599279 ns chậm hơn
        Time to clear: 376195 ns chậm hơn

        Testing PriorityQueue
        Time to offer: 2002746 ns chậm hơn
        Time to iterate: 1277114 ns chậm hơn
        Time to search: 281412 ns
        Time to clear: 156908 ns
        */
    public static void comparePerformance(int numElements) {
        compareQueue(new LinkedList<>(), numElements);
        compareQueue(new PriorityQueue<>(), numElements);
    }

    private static void compareQueue(Queue<Integer> queue, int numElements) {
        String queueType = queue.getClass().getSimpleName();
        System.out.println("Testing " + queueType);

        // Thêm phần tử
        long startTime = System.nanoTime();
        for (int i = 0; i < numElements; i++) {
            queue.offer(i);
        }
        long endTime = System.nanoTime();
        System.out.println("Time to offer: " + (endTime - startTime) + " ns");

        // Duyệt phần tử
        startTime = System.nanoTime();
        for (Integer i : queue) {
            // Duyệt qua phần tử (không làm gì)
        }
        endTime = System.nanoTime();
        System.out.println("Time to iterate: " + (endTime - startTime) + " ns");

        // Tìm kiếm phần tử
        startTime = System.nanoTime();
        queue.contains(numElements - 1);
        endTime = System.nanoTime();
        System.out.println("Time to search: " + (endTime - startTime) + " ns");

        // Xóa phần tử
        startTime = System.nanoTime();
        queue.clear();
        endTime = System.nanoTime();
        System.out.println("Time to clear: " + (endTime - startTime) + " ns");
        System.out.println();
    }
}

