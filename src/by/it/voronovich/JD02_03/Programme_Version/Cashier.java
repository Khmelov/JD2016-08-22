package by.it.voronovich.JD02_03.Programme_Version;

import by.it.voronovich.JD02_03.Programme_Version.Util.Queue;
import by.it.voronovich.JD02_03.Programme_Version.Util.RandomNum;
import by.it.voronovich.JD02_03.RunProgramme;

/**
 * Класс реализует методы объекта "Cashier"
 *
 * @author Voronovich Dmitry
 * @version 1.0
 */
public class Cashier extends Thread {

    private int number;

    public Cashier(int number) {
        this.number = number;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Client client;
                if (Queue.queue.size() == 0) {
                    break;
                } else {
                    client = Queue.queue.pollFirst();
                }
                System.out.println(client + " обслуживается в " + this);
                Thread.sleep(RandomNum.Random(2000, 5000));
                synchronized (client) {
                    System.out.println(client + " закончил обсуживаться в " + this);
                    client.notify();
                }
            }
            System.out.println(this + " закрылась.//////////////////////////////////");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        RunProgramme.numberCashier.getAndDecrement();
    }

    @Override
    public String toString() {
        return "Касса № " + number;
    }
}