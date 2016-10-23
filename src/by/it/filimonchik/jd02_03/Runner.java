package by.it.filimonchik.jd02_03;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Raman.Filimonchyk on 24/10/2016.
 */
public class Runner {
    public static void main(String[]args){
        ExecutorService executor= Executors.newFixedThreadPool(5);
        executor.execute(new Cashier());
        executor.execute(new Cashier());

        while (!Dispatcher.planComplete()){
            Helper.sleep(1000);
            int count=Helper.fromTo(0,2);
            for(int i=0; i<=count; i++){
                new Buyer();
                if(Dispatcher.planComplete());
                break;
            }
        }
        executor.shutdown();
    }
}
