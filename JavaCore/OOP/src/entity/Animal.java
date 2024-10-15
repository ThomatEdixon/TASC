package entity;

public abstract class Animal {
    private static String name; // khai báo biến static

    public Animal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public final void sleep(){
        System.out.println("animal is sleeping");
    }
    public static void eat() {
        System.out.println(name + " is eating.");
    }
    public abstract void sound() ; // phương thức abstract ko cần thực thi

    // overloading
    public void breath(String name){
        System.out.println(name+" is breathing");
    }
    public void breath(){
        System.out.println("is breathing");
    }
}
