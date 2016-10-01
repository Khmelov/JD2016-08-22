package by.it.grechishnikov.jd02_03;

import java.util.concurrent.locks.ReentrantLock;

public class Printer {
    private static final ReentrantLock lock = new ReentrantLock();
//    private static final Object lock = new Object();

    public static void println(String message) {
        print(message + "\n");
    }

    public static void print(String message) {
        lock.lock();
        System.out.print(message);
        lock.unlock();
    }

    public static void printCheck(Check check) {
        //TODO написать вывод чека
        println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^\n");
        println("Кассир " + check.getCashirName());
        println("Посититель №" + check.getBuyer().getName());
        println(check.getGoods().toString());
        print("Общая сумма: ");
        printDouble(check.getSum());
        println("\n^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
    }

    static void printDouble(double d) {
        println(String.format("%.2f", d));
    }
}
