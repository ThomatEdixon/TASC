package object;

import java.util.*;

public class SetPerformance {
    public static void comparePerformance(int numElements) {
        /*==== Set Performance ====
        Testing HashSet
        Time to add: 2106317 ns nhanh nhất trong set
        Time to iterate: 615979 ns nhanh nhất trong set // nhanh nhất trong toàn bộ clas triển khai collections
        Time to search: 15745 ns chậm nhất trong set
        Time to clear: 265484 ns

        Testing LinkedHashSet
        Time to add: 2531966 ns
        Time to iterate: 2750992 ns chậm nhất trong set
        Time to search: 3634 ns nhanh nhất trong set
        Time to clear: 271767 ns chậm nhất trong set

        Testing TreeSet
        Time to add: 9448833 ns
        Time to iterate: 1600424 ns
        Time to search: 14854 ns
        Time to clear: 4699 ns nhanh nhất trong set
        */

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

