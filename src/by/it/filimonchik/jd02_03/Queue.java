package by.it.filimonchik.jd02_03;

import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by Raman.Filimonchyk on 24/10/2016.
 */
public class Queue {
private final static ConcurrentLinkedQueue queue = new ConcurrentLinkedQueue();
    public static boolean add (Buyer buyer){
        return queue.add(buyer);
    }
    public static Buyer poll(){
        if(queue.isEmpty()){
            return null;
        }else {
            return(Buyer) queue.poll();
        }
    }
}
