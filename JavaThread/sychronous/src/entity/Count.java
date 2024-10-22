package entity;

public class Count {
    private int count = 0;

    public Count() {
    }

    public synchronized void increment() {
        count++;
    } // nếu không sử dụng synchronized két quả là số ngẫu nhiên

    public int getCount() {
        return count;
    }
}

