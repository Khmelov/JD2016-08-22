package by.it.dubatovka.jd02_01;

import java.util.ArrayDeque;
import java.util.Queue;

public class Runner {
    private static int countBuyers = 0;
    private static int limitBuyers = 10;

    public static void main(String[] args) throws InterruptedException {

        Queue<Buyer> queue = new ArrayDeque<>();
        while (countBuyers < limitBuyers) {
            Thread.sleep(1000);
            int counter = Rnd.fromTo(0, 2);
            for (int i = 0; i < counter; i++) {
                countBuyers++;
                if (countBuyers < limitBuyers+1) {
                    Buyer buyer;
                    int random = Rnd.fromTo(0, 4);
                    if (random == 1) {
                        buyer = new Buyer(countBuyers, true);
                    } else {
                        buyer = new Buyer(countBuyers, false);
                    }
                    queue.add(buyer);
                }
            }
        }
    }
}
