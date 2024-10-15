public class Main {
    public static void main(String[] args) {
        /* Primitive Data type  */
        // byte b1 = 12345; // lỗi vì giá trị lưu trữ lớn  kích thước của kiểu dữ liệu
        byte b = 100 ;

        //int i = 123.56; //  lỗi vì sai kiểu dữ liệu short ko lưu trữ số thưc
        int i = 12345 ;

        //short s = 123.45; //  lỗi vì sai kiểu dữ liệu short ko lưu trữ số thưc
        short s = 32000;

        //long l = 176.289; //  lỗi vì sai kiểu dữ liệu short ko lưu trữ số thưc
        long l = 789780863;

        float f = 76.88f;

        double d = 8789676.867;

        //char c = 'asd'; // lỗi vì chả chỉ lưu trữ 1 ký tự
        //char c = 'a ';// lỗi chưa thêm khoảng trắng
        char c = 'a';
        char c1 = 35; // gán giá trị ASCII

        boolean result = true;

        System.out.println("Primitive Data type ");
        System.out.println("byte data type: " + b);
        System.out.println("int data type: " + i);
        System.out.println("short data type: " + s);
        System.out.println("long data type: " + l);
        System.out.println("float data type: " + f);
        System.out.println("double data type: " + d);
        System.out.println("char data type: " + c);
        System.out.println("char ASCII data type: " + c1);
        System.out.println("boolean data type: " + result);
        System.out.println("==============================") ;

        /*Object data type */

        System.out.println("Object Data type ");
        Test test = new Test(); // khởi tạo 1 dối tượng test bằng constructor() trong class Test
        // thực hiện các thao tác với đối tượng test dựa trên thuộc tính và phương thức được cung cấp trong lớp Test

        test.setCount(i); // set giá trị cho thuộc tính count bằng phương thức setCount()
        System.out.println("Count :" + test.getCount()); // lấy giá trị của thuộc tính count bằng phương thức  getCount()
        test.increase();// thực thi phương thức increase() để tăng giá trị biến count ;
        System.out.println("Count after increased :" + test.getCount());

    }
}