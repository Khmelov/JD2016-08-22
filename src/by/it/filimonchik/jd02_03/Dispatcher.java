package by.it.filimonchik.jd02_03;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Raman.Filimonchyk on 24/10/2016.
 */
public class Dispatcher {
    private static final int planCount=5;
    static int countBuyers=0;
    static boolean planComplete(){
        return countBuyers>=planCount;
    }
    static int countCompleteBuyers=0;
    static boolean finish(){
        return countCompleteBuyers>=planCount;
    }
    static AtomicInteger acountCompleteBuyers=new AtomicInteger( 0 );
    static int countCashiers=0;
}
