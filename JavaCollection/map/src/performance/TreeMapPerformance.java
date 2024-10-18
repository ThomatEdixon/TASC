package performance;

import interfaces.MapPerformance;

import java.util.Map;
import java.util.TreeMap;

public class TreeMapPerformance implements MapPerformance {
    private static Map<Integer,Integer> treeMap = new TreeMap<>();

    public TreeMapPerformance() {
    }

    @Override
    public void performanceAdd() {
        long startTime = System.nanoTime();
        for (int i = 0; i < MapPerformance.NUMBER_ELEMENTS; i++) {
            treeMap.put(i, i);
        }
        long endTime = System.nanoTime();
        System.out.println("TreeMap time to put: " + (endTime - startTime) + " ns");
    }

    @Override
    public void performanceSearch() {
        long startTime = System.nanoTime();
        treeMap.containsKey(MapPerformance.NUMBER_ELEMENTS -1);
        long endTime = System.nanoTime();
        System.out.println("TreeMap time to search: " + (endTime - startTime) + " ns");
    }

    @Override
    public void performanceIterator() {
        long startTime = System.nanoTime();
        for (Map.Entry<Integer, Integer> entry : treeMap.entrySet()) {
        }
        long endTime = System.nanoTime();
        System.out.println("TreeMap time to iterator: " + (endTime - startTime) + " ns");
    }

    @Override
    public void performanceDelete() {
        long startTime = System.nanoTime();
        treeMap.remove(MapPerformance.NUMBER_ELEMENTS -1);
        long endTime = System.nanoTime();
        System.out.println("TreeMap time to delete: " + (endTime - startTime) + " ns");
    }
}
