public class Test {
    private int count;

    public Test(int count) {
        this.count = count;
    }
    public Test(){}

    public void setCount(int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }
     public int increase(){
        return count++;
     }
}
