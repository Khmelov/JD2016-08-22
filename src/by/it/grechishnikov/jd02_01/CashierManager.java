package by.it.grechishnikov.jd02_01;

import java.util.*;

/**
 * Created by Evgeniy on 30.09.16.
 */
public class CashierManager extends Thread {
    private List<Cashier> listCushiers = new ArrayList<>();
    private List<Cashier> runningCushiers = new ArrayList<>();
    {
        listCushiers.add(new Cashier("Жанна"));
        listCushiers.add(new Cashier("Светлана"));
        listCushiers.add(new Cashier("Алексей"));
        listCushiers.add(new Cashier("Зоя"));
        listCushiers.add(new Cashier("Александра"));
        listCushiers.add(new Cashier("Наталия"));
    }

    public CashierManager() {
        setDaemon(true);
        start();
        System.out.println("Магазин открылся! Добро пожаловать!");
    }

    public void run() {
        while(true) {
            int countBuyers = Cashier.buyers.size();
            if(countBuyers == 0) {
                continue;
            }
            if(countBuyers > 0 && countBuyers <= 5) {
                f(1);
            } else if(countBuyers > 5 && countBuyers <= 10) {
                f(2);
            } else if(countBuyers > 10 && countBuyers <= 15) {
                f(3);
            } else if(countBuyers > 15 &&  countBuyers <= 20) {
                f(4);
            } else if(countBuyers > 20 && countBuyers <= 25) {
                f(5);
            } else if(countBuyers > 25 && countBuyers <= 30) {
                f(6);
            }
        }
    }

    void f(int i) {
//        System.out.println(Cashier.buyers.size() + " - размер, " + i);
        if(runningCushiers.size() < i) {
            int count = i - runningCushiers.size();
            for (int j = 0; j < count; j++) {
                Cashier c = listCushiers.get(0);
                runningCushiers.add(c);
                listCushiers.remove(c);
                runCashier(c);
            }
        } else if(runningCushiers.size() > i) {
            interruptCushiers(runningCushiers.size() - i);
        }
    }

    private void runCashier(Cashier c) {
        Thread th = new Thread(c);
        th.setDaemon(true);
        th.start();
    }

    private void interruptCushiers(int i) {
        for (int j = 0; j < i; j++) {
            Cashier c = runningCushiers.get(j);
            System.out.println("interrupt " + c.getName());
            c.interrupt();
            listCushiers.add(c);
        }
        for (int j = 0; j < i; j++) {
            runningCushiers.remove(0);
        }
    }
}
