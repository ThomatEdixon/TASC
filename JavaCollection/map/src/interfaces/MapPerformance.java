package interfaces;

public interface MapPerformance {
    static final int NUMBER_ELEMENTS = 999999;

    public abstract void performanceAdd();
    public abstract void performanceSearch();
    public abstract void performanceIterator();
    public abstract void performanceDelete();
}
