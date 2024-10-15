package entity;

public class Cat extends Animal {
    public Cat(String name){
        super(name);// gọi constructor lớp cha
    }
    @Override
    public void sound(){
        System.out.println("meows meows");
    }
    /*
    final function không thể overriding
    @Override
    public final void sleep(){

    }*/
    /*
    static function không bị overriding
    * @Override
    public static void eat(){

    }*/
    public static void eat(){ // đây không phải overriding mà là method hiding
        System.out.println("eating");
    }
}
