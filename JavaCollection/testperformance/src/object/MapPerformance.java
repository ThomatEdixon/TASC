package object;

import java.util.*;

public class MapPerformance {

    public static void comparePerformance(int numElements) {
        compareMap(new HashMap<>(), numElements);
        compareMap(new LinkedHashMap<>(), numElements);
        compareMap(new TreeMap<>(), numElements);
    }

    private static void compareMap(Map<Integer, Integer> map, int numElements) {
        String mapType = map.getClass().getSimpleName();
        System.out.println("Testing " + mapType);

        // Thêm phần tử
        long startTime = System.nanoTime();
        for (int i = 0; i < numElements; i++) {
            map.put(i, i);
        }
        long endTime = System.nanoTime();
        System.out.println("Time to put: " + (endTime - startTime) + " ns");

        // Duyệt qua các entry
        startTime = System.nanoTime();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            // Duyệt qua phần tử (không làm gì)
        }
        endTime = System.nanoTime();
        System.out.println("Time to iterate: " + (endTime - startTime) + " ns");

        // Tìm kiếm phần tử
        startTime = System.nanoTime();
        map.containsKey(numElements - 1);
        endTime = System.nanoTime();
        System.out.println("Time to search: " + (endTime - startTime) + " ns");

        // Xóa phần tử
        startTime = System.nanoTime();
        map.clear();
        endTime = System.nanoTime();
        System.out.println("Time to clear: " + (endTime - startTime) + " ns");
        System.out.println();
    }
}

