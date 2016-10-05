package by.it.shkantau.jd02_03.market;

import java.util.concurrent.ConcurrentLinkedQueue;

 class QueueOfBuyers {
    private final static ConcurrentLinkedQueue queueOfBuyers = new ConcurrentLinkedQueue();

    public static boolean add(Buyer buyer){
        return queueOfBuyers.add(buyer);
    }

    static Buyer poll(){
        if (queueOfBuyers.isEmpty()){
            return null;
        }else {
            return (Buyer) queueOfBuyers.poll();
        }
    }
}
