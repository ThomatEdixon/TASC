package entity;

import testinterface.Run;
import testinterface.Walk;

public class Dog extends Animal implements Walk, Run {
    public Dog(String name) {
        super(name);
    }
    @Override
    public void sound(){
        System.out.println("gows gows");
    }

    @Override
    public void move() { // Lỗi do kiểu dữ liệu khác nhau của hàm move ở hai interface
        System.out.println(this.getName()+" is running");
    }
}
