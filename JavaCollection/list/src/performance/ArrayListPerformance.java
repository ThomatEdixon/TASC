package performance;

import interfaces.ListPerformance;

import java.util.ArrayList;

public class ArrayListPerformance implements ListPerformance {
    private static ArrayList<Integer> arrayList = new ArrayList<>();
    public ArrayListPerformance() {
    }

    @Override
    public void performanceAdd() {
        long startTime = System.nanoTime();
        for (int i = 0; i < ListPerformance.NUMBER_ELEMENTS; i++) {
            arrayList.add(i);
        }
        long endTime = System.nanoTime();
        System.out.println("Array list time to add: " + (endTime - startTime) + " ns");
    }

    @Override
    public void performanceSearch() {
        long startTime = System.nanoTime();
        arrayList.contains(ListPerformance.NUMBER_ELEMENTS - 1);
        long endTime = System.nanoTime();
        System.out.println("Array list time to search object: " + (endTime - startTime) + " ns");
        startTime = System.nanoTime();
        arrayList.remove(ListPerformance.NUMBER_ELEMENTS-2);
        endTime = System.nanoTime();
        System.out.println("Array list time to search by  index: " + (endTime - startTime) + " ns");
    }

    @Override
    public void performanceIterator() {
        long startTime = System.nanoTime();
        for (Integer i : arrayList) {
            // Duyệt qua phần tử (không làm gì)
        }
        long endTime = System.nanoTime();
        System.out.println("Array list time to iterate: " + (endTime - startTime) + " ns");
    }

    @Override
    public void performanceDelete() {
        long startTime = System.nanoTime();
        arrayList.remove(arrayList.size()-1);
        long endTime = System.nanoTime();
        System.out.println("Array list time to delete object: " + (endTime - startTime) + " ns");

    }
}
