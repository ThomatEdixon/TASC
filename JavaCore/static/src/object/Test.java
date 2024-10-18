package object;

public class Test {
    // Thuộc tính static
    public static int count = 0;

    // Thuộc tính final
    public final int MAX_COUNT= 5;

    public static final int MIN_COUNT = 1;

    // Phương thức static
    public static void displayCount() {
        System.out.println("The number of object: " + count);
    }
    public void displayLimitCount(){
       // MAX_COUNT = 10 // lỗi khi cố thay đổi giá trị của biến final
        System.out.println("Max object: " + MAX_COUNT);
        System.out.println("Min object: " + MIN_COUNT);
    }
    public static void displayMinCount(){
        // không thể gọi biến MAX_COUNT bởi vì nó không được khai báo là static
        // System.out.println("Số lượng đối tượng tối đa: " + MAX_COUNT);
        System.out.println("Min object: " + MIN_COUNT);
    }


    public Test() {
        // Mỗi lần tạo đối tượng, tăng count
        count++;
    }
    public static class InnerTest {

        public InnerTest(){
            count++;
        }

        public static void displayInnerCount() {
            System.out.println("Min object: " + MIN_COUNT);
        }
        public int increse(){
            return count++;
        }

    }
}
