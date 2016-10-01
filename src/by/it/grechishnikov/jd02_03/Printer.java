package by.it.grechishnikov.jd02_03;

import java.util.concurrent.CopyOnWriteArraySet;
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
        String s = String.format("|%41s|", "Кассир " + check.getCashirName()) + "\n";
        s += String.format("|%41s|", "Посититель " + (check.getBuyer().isPensioner() ? "(пенсионер) " : "") + "№" + check.getBuyer().getName());
        s += String.format("\n|%41s|" , "Продажа");
        s += goodsToString(check.getGoods());
        s += String.format("\n|ИТОГО%36s|",  "$" + doubleToString(check.getSum()));
        s += "\n^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^\n";
        print(s);
    }

    static String doubleToString(double d) {
        return String.format("%.2f", d);
    }

    private static String goodsToString(CopyOnWriteArraySet<Good> goods) {
        StringBuilder result = new StringBuilder();
        for (Good good : goods) {
            StringBuilder tmp = new StringBuilder(String.format("\n|%s%34s%.2f|", good, "$", good.getPrice()));
            if(tmp.length() > 43) {
                int start = 43/2;
                tmp.delete(start, start + (tmp.length() - 44));
            }
            result.append(tmp);
        }
        return result.toString();
    }
}
