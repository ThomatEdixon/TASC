package performance;

import interfaces.MapPerformance;

import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapPerformance implements MapPerformance {
    private static Map<Integer,Integer> linkedHashMap = new LinkedHashMap<>();

    public LinkedHashMapPerformance() {
    }

    @Override
    public void performanceAdd() {
        long startTime = System.nanoTime();
        for (int i = 0; i < MapPerformance.NUMBER_ELEMENTS; i++) {
            linkedHashMap.put(i, i);
        }
        long endTime = System.nanoTime();
        System.out.println("LinkedHashMap time to put: " + (endTime - startTime) + " ns");
    }

    @Override
    public void performanceSearch() {
        long startTime = System.nanoTime();
        linkedHashMap.containsKey(MapPerformance.NUMBER_ELEMENTS -1);
        long endTime = System.nanoTime();
        System.out.println("LinkedHashMap time  to search: " + (endTime - startTime) + " ns");
    }

    @Override
    public void performanceIterator() {
        long startTime = System.nanoTime();
        for (Map.Entry<Integer, Integer> entry : linkedHashMap.entrySet()) {
        }
        long endTime = System.nanoTime();
        System.out.println("LinkedHashMap time  to iterator: " + (endTime - startTime) + " ns");
    }

    @Override
    public void performanceDelete() {
        long startTime = System.nanoTime();
        linkedHashMap.remove(MapPerformance.NUMBER_ELEMENTS -1);
        long endTime = System.nanoTime();
        System.out.println("LinkedHashMap time  to delete: " + (endTime - startTime) + " ns");
    }
}
