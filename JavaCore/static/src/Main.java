import object.Test;

public class Main {
    public static void main(String[] args) {

        // Truy cập thuộc tính và phương thức static mà không cần tạo đối tượng
        System.out.println("The start: " + Test.count);
        Test.displayCount();

        // Tạo các đối tượng mới
        Test obj1 = new Test();
        Test obj2 = new Test();

        // Truy cập lại sau khi đã tạo đối tượng
        System.out.println("After instancing object: " + Test.count);
        Test.displayCount();

        // Truy cập thuộc tính static final MIN_COUNT mà không cần tạo đối tượng

        // Truy cập đến phương thức displayMinCount mà không cần khởi tạo dối tượng
        Test.displayMinCount();

        // Khởi tạo đối tượng để truy cập phương thức displayLimitCount;
        Test test = new Test();
        // khởi tạo lớp static qua outnner class
        Test.InnerTest innerTest = new Test.InnerTest();
        test.displayLimitCount();
    }
}