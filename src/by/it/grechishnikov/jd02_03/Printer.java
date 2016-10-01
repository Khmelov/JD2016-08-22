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
        String space = "                               ";
        String tab = "";
        switch (check.getCashirName()) {
            case "Наталия" :
                tab = space;
                break;
            case "Анна" :
                tab = space + space;
                break;
            case "Александра" :
                tab = space + space + space;
                break;
            case "Зоя" :
                tab = space + space + space + space;
                break;
        }
        String s = tab + "^^^^^^^^^^^^^^^^^^^^^^^^^^^^^\n";

        s += String.format(tab + "|%27s|", "Кассир " + check.getCashirName()) + "\n";
        s += String.format(tab + "|%27s|", "Посититель " + (check.getBuyer().isPensioner() ? "(пенсионер) " : "") + "№" + check.getBuyer().getName());
        s += addDataToString(String.format("\n" + tab + "|%27s|" , "Продажа"));
        s += goodsToString(check.getGoods(), tab);
        s += String.format("\n" + tab + "|ИТОГО%22s|",  "$" + doubleToString(check.getSum()));
        s += "\n" + tab + "^^^^^^^^^^^^^^^^^^^^^^^^^^^^^\n";
        print(s);
    }

    static String doubleToString(double d) {
        return String.format("%.2f", d);
    }

    private static String addDataToString(String text) {
        int index = 172 - text.length();
        String tab = "";
        for (int i = 0; i < index - 14; i++) {
            tab += " ";
        }
        int count = Cashier.pensionerQueue.size() + Cashier.queue.size();
        text += tab +  count + (count < 10 ? " " : "") + "     " + doubleToString(Cashier.getTotalProceeds());
        return text;
    }

    private static String goodsToString(CopyOnWriteArraySet<Good> goods, String tab) {
        StringBuilder result = new StringBuilder();
        for (Good good : goods) {
            StringBuilder tmp = new StringBuilder(String.format("\n" + tab + "|%s%20s%.2f|", good, "$", good.getPrice()));
            int sub = tmp.length() - tmp.indexOf("|");
            if(sub > 29) {
                int dif = sub - 29;
                int index = tmp.indexOf(" ", tmp.indexOf("|"));
                tmp.delete(index, index + dif);
            }
            result.append(tmp);
        }
        return result.toString();
    }
}
