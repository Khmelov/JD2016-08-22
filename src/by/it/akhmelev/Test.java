package by.it.akhmelev;

public class Test {
    public static void main(String[] args) {
        System.out.println("test");
    }


    abstract class Parent<T> {
        abstract T x();
    }

    class Child extends Parent<String> {
        @Override
        String x() { return "abc"; }
    }
}
