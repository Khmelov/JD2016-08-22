package by.it.dubatovka.JD01.jd01_13;

import java.util.Random;

public class TaskB extends Exception {


    public static void one() throws UnsupportedOperationException {
        System.out.println("start one");
        try {
            two();
        } catch (UnsupportedOperationException e) {
            throw e;
        }
        System.err.println("stop one");
    }


    private static void two() throws UnsupportedOperationException {
        System.out.println("start two");
        try {
            three();
        } catch (UnsupportedOperationException e) {
            throw e;
        }
        System.err.println("stop TWO");
    }

    private static void three() throws UnsupportedOperationException {
        System.out.println("start three");
        try {
            double x;
            for (int i = 9; i >= 0; i--)
                x = 1 / i;
        } catch (ArithmeticException e) {
            System.err.println("Exception THREE - Деление на 0.");
            throw e;
        }
        System.out.println("stop tree");
    }
}