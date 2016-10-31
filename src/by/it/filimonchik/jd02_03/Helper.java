package by.it.filimonchik.jd02_03;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created by Raman.Filimonchyk on 24/10/2016.
 */
public class Helper {
    static final long init=System.currentTimeMillis();
    static final Random random = new Random(init);

    static  int fromTo(int from, int to){
        int delta=to-from+1;
        int msWait=from+random.nextInt(delta);
        return msWait;
    }
    static void sleep(int ms){
        try {
                Thread.sleep(ms);
            }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
    static Map<String,Double> allPriceForGoods= new HashMap<String, Double>(){
        {
            this.put("Eggs", 1.0d);
            this.put("Water", 1.80d);
            this.put("Milk", 2.1d);
            this.put("Coffee", 10.05d);
            this.put("Bread", 2.2d);

        }
    };

    static int random(int from, int to){
        int res = from+(int)Math.round(Math.random()*(to-from));
        return res;
    }
}
