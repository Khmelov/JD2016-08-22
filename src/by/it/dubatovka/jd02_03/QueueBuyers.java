package by.it.dubatovka.jd02_03;

import java.util.concurrent.ConcurrentLinkedQueue;

 class QueueBuyers {
    private final static ConcurrentLinkedQueue queueBuyers = new ConcurrentLinkedQueue();

    public static boolean add(Buyer buyer) {
        return queueBuyers.add(buyer);}

    public static Buyer poll() {
        if (queueBuyers.isEmpty()) {
            return null;
        } else {
            return (Buyer) queueBuyers.poll();
        }
    }
}


