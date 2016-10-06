package by.it.grechishnikov.jd02_03;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

class Cashier implements Runnable {
    static AtomicInteger counter = new AtomicInteger(0); //обслуженные поситители
    static ConcurrentLinkedDeque<Buyer> queue = new ConcurrentLinkedDeque<>();
    private String name; //имя кассира
    private double proceeds; //его выручка
    private static volatile double totalProceeds; //выручка магазина
    private static final ReentrantLock lock = new ReentrantLock();
    private static final Object monitor = new Object();
    private static volatile boolean flag = true;


    public Cashier(String name) {
        this.name = name;
    }

    public void run() {
        while(!Dispatcher.endOfWork) {
            if(queue.isEmpty()) {
                continue;
            }
            Buyer buyer = getBuyer();//Получаем клиента
            try {
                long time = ThreadLocalRandom.current().nextLong(2,5);
                TimeUnit.SECONDS.sleep(time); //Обслуживаем клиента от 2 до 5 секунд
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Check check = new Check(name, buyer ,buyer.bucket); //Считаем сумму
            setProceeds(check.getSum()); //Считаем прибыль
            check.setTotalSum(getTotalProceeds());
            lock.lock();
            Printer.printCheck(check); //Печатаем чек
            lock.unlock();
            counter.incrementAndGet(); //Считаем обслуженных поситителей
        }
        Printer.println("                                                                   " +
                "Кассир " + name + " заработала за день $" + Printer.doubleToString(proceeds));
    }

    public Buyer getBuyer() {
        synchronized (monitor) {
            for(Buyer buyer : queue) {
                if(buyer.isPensioner()) {
                    queue.remove(buyer);
                    return buyer;
                }
            }
        }
        return queue.poll();
    }

    private void setProceeds(double proceeds) {
        this.proceeds += proceeds;
        synchronized (monitor) {
            try {
                while(!flag) {
                    monitor.wait();
                }
                flag = false;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            totalProceeds += proceeds;
        }
    }

    static double getTotalProceeds() {
        synchronized (monitor) {
            double result = totalProceeds;
            flag = true;
            monitor.notify();
            return result;
        }
    }
}
