package by.it.grechishnikov.jd02_03;

import java.util.Queue;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

class Cashier implements Runnable {
    //обслуженные поситители
    static AtomicInteger counter = new AtomicInteger(0);
    //обычная очередь
    static volatile ConcurrentLinkedDeque<Buyer> queue = new ConcurrentLinkedDeque<>();
    private String name;
    private double proceeds;
    private static volatile double totalProceeds;
    private static final ReentrantLock lock = new ReentrantLock();


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
        synchronized (queue) {
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
        lock.lock();
        totalProceeds += proceeds;
        lock.unlock();
    }

    static double getTotalProceeds() {
        lock.lock();
        double total = totalProceeds;
        lock.unlock();
        return total;
    }
}
