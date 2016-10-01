package by.it.grechishnikov.jd02_01;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;


public class Runner {
    public static void main(String[] args) throws Exception {
        CashierManager manager = new CashierManager();

        ArrayDeque<Buyer> queue = new ArrayDeque<>();
        for (int i = 0; i < 20; i++) {
            queue.add(new Buyer("id: " + i));
        }
//        int countClients = ThreadLocalRandom.current().nextInt(5, 30);
//        for (int i = 1; i <= countClients; i++) {
//            if(i % 4 != 0) {
//                queue.push(new Buyer("id: " + i));
//            } else {
//                queue.push(new Buyer("id: " + i, true));
//            }
//        }

        for (Buyer b : queue) {
            b.start();
        }
    }
}
