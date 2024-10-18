package object;

import java.util.*;

public class SetPerformance {
    public static void comparePerformance(int numElements) {

        compareSet(new HashSet<>(), numElements);
        compareSet(new LinkedHashSet<>(),numElements);
        compareSet(new TreeSet<>(), numElements);
    }

    private static void compareSet(Set<Integer> set, int numElements) {
        String setType = set.getClass().getSimpleName();
        System.out.println("Testing " + setType);

        // Thêm phần tử
        long startTime = System.nanoTime();
        for (int i = 0; i < numElements; i++) {
            set.add(i);
        }
        long endTime = System.nanoTime();
        System.out.println("Time to add: " + (endTime - startTime) + " ns");

        // Duyệt phần tử
        startTime = System.nanoTime();
        for (Integer i : set) {
            // Duyệt qua phần tử (không làm gì)
        }
        endTime = System.nanoTime();
        System.out.println("Time to iterate: " + (endTime - startTime) + " ns");

        // Tìm kiếm phần tử
        startTime = System.nanoTime();
        set.contains(numElements - 1);
        endTime = System.nanoTime();
        System.out.println("Time to search: " + (endTime - startTime) + " ns");

        // Xóa phần tử
        startTime = System.nanoTime();
        set.clear();
        endTime = System.nanoTime();
        System.out.println("Time to clear: " + (endTime - startTime) + " ns");
        System.out.println();
    }
}

