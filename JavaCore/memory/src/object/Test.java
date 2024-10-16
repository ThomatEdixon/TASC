package object;

public class Test {
    int count;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Test(int count) {
        this.count = count;
    }
    public void displayCount(){
        System.out.println("Count object: " + count);
    }
}
