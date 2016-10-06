package by.it.shkantau.jd02.jd02_03.market;

import java.util.concurrent.ConcurrentLinkedQueue;

 class QueueOfBuyers {
    private final static ConcurrentLinkedQueue<Buyer> queueOfBuyers = new ConcurrentLinkedQueue<>();

    public static boolean add(Buyer buyer){
        return queueOfBuyers.add(buyer);
    }

    static Buyer poll(){
        if (queueOfBuyers.isEmpty()){
            return null;
        }else {
            return queueOfBuyers.poll();
        }
    }
}
