package by.it.grechishnikov.jd02_03;

import java.util.concurrent.locks.ReentrantLock;

public class Printer {
    private static final ReentrantLock lock = new ReentrantLock();

    public static void println(String message) {
        print(message + "\n");
    }

    public static void print(String message) {
        lock.lock();
        System.out.print(message);
        lock.unlock();
    }

    static void printCheck(Check check) {
        print(
                "Кассир " + check.getCashirName() +
                "\nПосититель " + (check.getBuyer().isPensioner() ? "(пенсионер) " : "") +
                "№" + check.getBuyer().getName()
                + "\n" +
                check.getGoods().toString() +
                "\nОбщая сумма: $" +
                doubleToString(check.getSum()) +
                "\n\n^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^\n\n");
    }

    static String doubleToString(double d) {
        return String.format("%.2f", d);
    }
}
