package by.it.voronovich.JD02_03;

import by.it.voronovich.JD02_03.Programme_Version.Cashier;
import by.it.voronovich.JD02_03.Programme_Version.Client;
import by.it.voronovich.JD02_03.Programme_Version.Util.Queue;
import by.it.voronovich.JD02_03.Programme_Version.Util.RandomNum;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Класс запускает процесс иммитации взаимодействия клиент-магазин
 *
 * @author Voronovich Dmitry
 * @version 1.0
 */
public class RunProgramme {

    public static AtomicInteger numberClient = new AtomicInteger(1);
    public static AtomicInteger numberCashier = new AtomicInteger(1);

    public static void main(String[] args) {

        ExecutorService executer = Executors.newFixedThreadPool(5);

        while (numberClient.get() < 101) {
            try {
                Thread.sleep(1000);
                int count = RandomNum.Random(0, 2);
                for (int i = 0; i < count; i++) {
                    new Client(numberClient.getAndIncrement());
                }
                if (numberCashier.get() < 2 && Queue.queue.size() >= 5) {
                    executer.execute(new Cashier(numberCashier.getAndIncrement()));
                } else if (numberCashier.get() < 3 && Queue.queue.size() >= 10) {
                    executer.execute(new Cashier(numberCashier.getAndIncrement()));
                } else if (numberCashier.get() < 4 && Queue.queue.size() >= 15) {
                    executer.execute(new Cashier(numberCashier.getAndIncrement()));
                } else if (numberCashier.get() < 5 && Queue.queue.size() >= 20) {
                    executer.execute(new Cashier(numberCashier.getAndIncrement()));
                } else if (numberCashier.get() < 6 && Queue.queue.size() >= 21) {
                    executer.execute(new Cashier(numberCashier.getAndIncrement()));
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        executer.shutdown();
    }
}

