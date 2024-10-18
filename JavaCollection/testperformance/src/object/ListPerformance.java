package object;

import java.util.*;

public class ListPerformance {
    public static void comparePerformance(int numElements) {

        compareList(new ArrayList<>(), numElements);
        compareList(new LinkedList<>(), numElements);
    }

    private static void compareList(List<Integer> list, int numElements) {
        String listType = list.getClass().getSimpleName();
        System.out.println("Testing " + listType);

        // Thêm phần tử
        long startTime = System.nanoTime();
        for (int i = 0; i < numElements; i++) {
            list.add(i);
        }
        long endTime = System.nanoTime();
        System.out.println("Time to add: " + (endTime - startTime) + " ns");

        // Duyệt phần tử
        startTime = System.nanoTime();
        for (Integer i : list) {
            // Duyệt qua phần tử (không làm gì)
        }
        endTime = System.nanoTime();
        System.out.println("Time to iterate: " + (endTime - startTime) + " ns");

        // Tìm kiếm phần tử
        startTime = System.nanoTime();
        list.contains(numElements - 1);
        endTime = System.nanoTime();
        System.out.println("Time to search: " + (endTime - startTime) + " ns");

        // Xóa phần tử
        startTime = System.nanoTime();
        list.clear();
        endTime = System.nanoTime();
        System.out.println("Time to clear: " + (endTime - startTime) + " ns");
        System.out.println();
    }
}

