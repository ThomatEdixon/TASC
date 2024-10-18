package performance;

import interfaces.SetPerformance;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class TreeSetPerformance implements SetPerformance {

    private static Set<Integer> treeSet = new TreeSet<>();
    public TreeSetPerformance() {
    }

    @Override
    public void performanceAdd() {
        long startTime = System.nanoTime();
        for (int i = 0; i < SetPerformance.NUMBER_ELEMENTS; i++) {
            treeSet.add(i);
        }
        long endTime = System.nanoTime();
        System.out.println("Tree Set time to add: " + (endTime - startTime) + " ns");
    }

    @Override
    public void performanceSearch() {
        long startTime = System.nanoTime();
        treeSet.contains(SetPerformance.NUMBER_ELEMENTS - 1);
        long endTime = System.nanoTime();
        System.out.println("Tree Set time to search: " + (endTime - startTime) + " ns");
    }

    @Override
    public void performanceIterator() {
        long startTime = System.nanoTime();
        for (Integer i : treeSet) {
            // Duyệt qua phần tử (không làm gì)
        }
        long endTime = System.nanoTime();
        System.out.println("Tree Set time to iterate: " + (endTime - startTime) + " ns");
    }

    @Override
    public void performanceDelete() {
        long startTime = System.nanoTime();
        treeSet.clear();
        long endTime = System.nanoTime();
        System.out.println("Tree Set time to clear: " + (endTime - startTime) + " ns");
        System.out.println();
    }
}
