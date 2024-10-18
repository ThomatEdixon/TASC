import performance.HashSetPerformance;
import performance.LinkedHashSetPerformance;
import performance.TreeSetPerformance;

import java.util.*;

enum Test { CODE, LEARN, CONTRIBUTE, QUIZ, MCQ }

public class Main {
     public static void set(){
         Set<String> set = new HashSet<>();
         set.add("Java");
         set.add("Python");
         set.add("C#");
         set.add("Java");  // Thêm trùng lặp
         System.out.println("List data in set :"+ set);
         System.out.println("Set contained Java :" + set.contains("Java"));
         System.out.println("Set size :"+set.size());

         // duyệt phần tử trong set

         Iterator<String> iterator = set.iterator();

         while (iterator.hasNext()) {
             System.out.println(iterator.next());
         }
         // thêm 1 list vào set
         List<String> list = List.of("C", "C++");
         set.addAll(list);
         System.out.println("List data in set after add all:"+ set);
         // giữ lại phần tử có trong listRetain xoá các phần tử còn lại.
         List<String> listRetain = List.of("Python", "C#","Java","Html","Css");
         set.retainAll(listRetain);
         System.out.println("List data in set after retain:"+ set);
         // xoá phần tử có trong listMove
         List<String> listRemove = List.of("Java", "C++");
         set.removeAll(listRemove);
         System.out.println("List data in set after remove:"+ set);
         // xoá cả set
         set.clear();
         if(set.isEmpty()){
             System.out.println("Set is empty");
         }else {
             System.out.println("List data in set :"+ set);
         }

     }

    public static void hashSet(){
        HashSetPerformance hashSetPerformance = new HashSetPerformance();
        hashSetPerformance.performanceAdd();
        hashSetPerformance.performanceDelete();
        hashSetPerformance.performanceIterator();
        hashSetPerformance.performanceSearch();

    }
    public static void linkedHashSet(){
        LinkedHashSetPerformance linkedHashSetPerformance= new LinkedHashSetPerformance();
        linkedHashSetPerformance.performanceAdd();
        linkedHashSetPerformance.performanceDelete();
        linkedHashSetPerformance.performanceIterator();
        linkedHashSetPerformance.performanceSearch();
    }
    public static void treeSet(){
        TreeSetPerformance treeSetPerformance = new TreeSetPerformance();
        treeSetPerformance.performanceAdd();
        treeSetPerformance.performanceDelete();
        treeSetPerformance.performanceIterator();
        treeSetPerformance.performanceSearch();
    }
    public static void enumSet(){
        // tạo enum set
        EnumSet<Test> test = EnumSet.allOf(Test.class);
        System.out.println("EnumSet: " + test);


    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice ;
        do {
            System.out.println("====== MENU =====");
            System.out.println("1. Set Interface");
            System.out.println("2. HashSet");
            System.out.println("3. LinkedHashSet");
            System.out.println("4. TreeSet");
            System.out.println("5. EnumSet");
            System.out.println("0. Exit");
            System.out.println(" Choice option 0-5 : ");

            choice = scanner.nextInt();

            switch (choice){
                case 1:
                    System.out.println("Set Interface");
                    set();
                    break;
                case 2:
                    System.out.println("HashSet");
                    hashSet();
                    break;
                case 3:
                    System.out.println("LinkedHashSet");
                    linkedHashSet();
                    break;
                case 4:
                    System.out.println("TreeSet");
                    treeSet();
                    break;
                case 5:
                    System.out.println("EnumSet");
                    enumSet();
                    break;
                case 0:
                    System.out.println("Exiting the program...");
                    break;
                default:
                    System.out.println("Invalid choice. Please choose again.");
            }
        }while (choice !=0 );
    }
}