package by.it.akhmelev.jd01_08._04_Point;

class Point1D {
    private int x;
    Point1D(int x) {
        this.x = x;
    }
    public double length() {
        return Math.abs(x);
    }
    @Override
    public String toString() {
        return " x=" + x;
    }
}

