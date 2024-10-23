package org.example.pattern.singleton;

public class SingletonDemo {
    private static SingletonDemo instance;
    private SingletonDemo(){}
    public static SingletonDemo getInstance() {
        if (instance == null) {
            instance = new SingletonDemo();  // Tạo đối tượng mới chỉ một lần
        }
        return instance;
    }
}
