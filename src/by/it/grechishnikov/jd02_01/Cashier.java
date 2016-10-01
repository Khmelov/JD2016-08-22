package by.it.grechishnikov.jd02_01;

import java.util.Map;
import java.util.concurrent.*;

/**
 * Created by Evgeniy on 28.09.16.
 */
public class Cashier implements Runnable {
    public static volatile ConcurrentLinkedDeque<Buyer> buyers = new ConcurrentLinkedDeque<>();
    private String name;
    private boolean alive = true;

    public Cashier(String name) {
        this.name = name;
    }

    public void run() {
        while (alive) {
            if(!alive) {
                System.out.println("!alive");
            }
            Buyer firstBuyer;
            synchronized (buyers) {
                firstBuyer = buyers.poll();
            }
            if (firstBuyer == null) {
                continue;
            }
            long time = 0;
            try {
                time = ThreadLocalRandom.current().nextLong(2000, 5000);
                Thread.sleep(time);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("Кассир " + getName() + " работает с " + firstBuyer.getName() + " в течении " + time + " милисекунд.");
            printTotalPrice(firstBuyer);
            firstBuyer.setCanGo(true);
        }
    }

    private void printTotalPrice(Buyer b) {
        double count = 0;
        String goods = " В корзине: ";
        for(Map.Entry<Good, Double> pair : b.goods.entrySet()) {
            count += pair.getValue();
            goods += pair.getKey() + "(" + pair.getValue() + "), ";
        }
        System.out.print(goods.substring(0, goods.length() - 2) + " на сумму: " + priceToString(count));
        if(b.isPensioner()) {
            double totalCount = count / 1.5;
            System.out.print(" (Пенсионер, скидка 30%). Итоговая стоимость = " + priceToString(totalCount));
        }
        System.out.println();
    }

    private String priceToString(double price) {
        return String.format("$%.2f", price);
    }

    public String getName() {
        return name;
    }

    public void interrupt() {
        alive = false;
    }
}