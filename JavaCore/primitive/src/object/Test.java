package object;

public class Test {
    private int count;
    private String objectString;

    public String getObjectString() {
        return objectString;
    }

    public void setObjectString(String objectString) {
        this.objectString = objectString;
    }

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
