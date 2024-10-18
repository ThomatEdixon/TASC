package performance;

import java.util.LinkedList;

public class LinkedListPerformance implements ListPerformance{
    private static LinkedList<Integer> linkedList = new LinkedList<>();
    public LinkedListPerformance() {
    }

    @Override
    public void performanceAdd() {
        long startTime = System.nanoTime();
        for (int i = 0; i < ListPerformance.NUMBER_ELEMENTS; i++) {
            linkedList.add(i);
        }
        long endTime = System.nanoTime();
        System.out.println("Linked List time to add: " + (endTime - startTime) + " ns");
    }

    @Override
    public void performanceSearch() {
        long startTime = System.nanoTime();
        linkedList.contains(ListPerformance.NUMBER_ELEMENTS - 1);
        long endTime = System.nanoTime();
        System.out.println("Linked List time to search: " + (endTime - startTime) + " ns");
    }

    @Override
    public void performanceIterator() {
        long startTime = System.nanoTime();
        for (Integer i : linkedList) {
        }
        long endTime = System.nanoTime();
        System.out.println("Linked List time to iterate: " + (endTime - startTime) + " ns");
    }

    @Override
    public void performanceDelete() {
        long startTime = System.nanoTime();
        linkedList.remove(ListPerformance.NUMBER_ELEMENTS - 1);
        long endTime = System.nanoTime();
        System.out.println("Linked List time to search: " + (endTime - startTime) + " ns");

    }
}
