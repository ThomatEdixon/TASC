import object.Test;

public class Main {
    public static void main(String[] args) {
        // cấp phát bộ nhớ stack
        int count = 10 ;// biến nguyên thuỷ count lưu vào trong bộ nhớ stack

        // cấp phát bộ nhớ heap
        Test object = new Test(10);// Đối tượng 'object' được lưu trữ trong heap

        addNumberObject(object.getCount(),15);// gọi hàm được lưu trên stack
    }
    public static void addNumberObject(int count , int numberObject){
        //int numberObject biến có phạm vi trong method , nếu method kết thức biến sẽ bị xoá khỏi stack
        int totalCountObject = count + numberObject;
        System.out.println(totalCountObject);
    }
}