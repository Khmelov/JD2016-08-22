package by.it.grechishnikov.jd02_03;

import java.util.Queue;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

class Cashier implements Runnable {
    static AtomicInteger counter = new AtomicInteger(0);
    //обычная очередь
    static ConcurrentLinkedDeque<Buyer> queue = new ConcurrentLinkedDeque<>();
    //пенсионеры вне очереди
    static ConcurrentLinkedDeque<Buyer> pensionerQueue = new ConcurrentLinkedDeque<>();
    private String name;
    private double proceeds;
    private static double totalProceeds;

    public Cashier(String name) {
        this.name = name;
    }

    public void run() {
        while(!Dispatcher.endOfWork) {
            if(queue.isEmpty() && pensionerQueue.isEmpty()) {
                continue;
            }
            Buyer buyer;//Получаем клиента
            if(!pensionerQueue.isEmpty()) {
                buyer = getBuyer(pensionerQueue);
            } else {
                buyer = getBuyer(queue);
            }
            try {
                long time = ThreadLocalRandom.current().nextLong(2,5);
                TimeUnit.SECONDS.sleep(time); //Обслуживаем клиента от 2 до 5 секунд
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Check check = new Check(name, buyer ,buyer.bucket); //Считаем сумму
            Printer.printCheck(check); //Печатаем чек
            setProceeds(check.getSum()); //Считаем прибыль
            counter.incrementAndGet();
        }
        Printer.println("Кассир " + name + " заработала за день $" + Printer.doubleToString(proceeds));
    }

    private void setProceeds(double proceeds) {
        this.proceeds += proceeds;
        totalProceeds += proceeds;
    }

    private Buyer getBuyer(Queue<Buyer> queue) {
        return queue.poll();
    }

    static double getTotalProceeds() {
        return totalProceeds;
    }
}
