package performance;

import interfaces.MapPerformance;

import java.util.HashMap;
import java.util.Map;

public class HashMapPerformance implements MapPerformance {
    private static Map<Integer,Integer> hashMap = new HashMap<>();
    @Override
    public void performanceAdd() {
        long startTime = System.nanoTime();
        for (int i = 0; i < MapPerformance.NUMBER_ELEMENTS; i++) {
            hashMap.put(i, i);
        }
        long endTime = System.nanoTime();
        System.out.println("Hash map time to put: " + (endTime - startTime) + " ns");
    }

    @Override
    public void performanceSearch() {
        long startTime = System.nanoTime();
        hashMap.containsKey(MapPerformance.NUMBER_ELEMENTS -1);
        long endTime = System.nanoTime();
        System.out.println("HashMap time to search: " + (endTime - startTime) + " ns");
    }

    @Override
    public void performanceIterator() {
        long startTime = System.nanoTime();
        for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
        }
        long endTime = System.nanoTime();
        System.out.println("HashMap time to iterator: " + (endTime - startTime) + " ns");
    }

    @Override
    public void performanceDelete() {
        long startTime = System.nanoTime();
        hashMap.remove(MapPerformance.NUMBER_ELEMENTS -1);
        long endTime = System.nanoTime();
        System.out.println("HashMap time to delete: " + (endTime - startTime) + " ns");
    }
}
