package performance;

import interfaces.SetPerformance;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class LinkedHashSetPerformance implements SetPerformance {
    private static Set<Integer> linkedHashSet = new LinkedHashSet<>();
    public LinkedHashSetPerformance() {
    }

    @Override
    public void performanceAdd() {
        long startTime = System.nanoTime();
        for (int i = 0; i < SetPerformance.NUMBER_ELEMENTS; i++) {
            linkedHashSet.add(i);
        }
        long endTime = System.nanoTime();
        System.out.println("Linked Hash Set time to add: " + (endTime - startTime) + " ns");
    }

    @Override
    public void performanceSearch() {
        long startTime = System.nanoTime();
        linkedHashSet.contains(SetPerformance.NUMBER_ELEMENTS - 1);
        long endTime = System.nanoTime();
        System.out.println("Linked Hash Set time to search: " + (endTime - startTime) + " ns");
    }

    @Override
    public void performanceIterator() {
        long startTime = System.nanoTime();
        for (Integer i : linkedHashSet) {
            // Duyệt qua phần tử (không làm gì)
        }
        long endTime = System.nanoTime();
        System.out.println("Linked Hash Set time to iterate: " + (endTime - startTime) + " ns");
    }

    @Override
    public void performanceDelete() {
        long startTime = System.nanoTime();
        linkedHashSet.clear();
        long endTime = System.nanoTime();
        System.out.println("Linked Hash Set time to clear: " + (endTime - startTime) + " ns");
        System.out.println();
    }
}
