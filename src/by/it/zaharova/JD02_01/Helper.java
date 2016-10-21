package by.it.zaharova.JD02_01;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Helper {

    static final long init=System.currentTimeMillis();
    static final Random random = new Random(init);

    public static int fromTo(int from, int to) {
        //вычислим время ожидания
        int delta=to-from+1;
        int msWait=from+random.nextInt(delta);
        return msWait;
    }

    //чтобы не загромождать код вынесем try для sleep в свой отдельный метод
    static void sleep(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //текущая секунда (возможно метод пригодится для уровня C)
    static int getSecond(){
        return (Calendar.getInstance().get(Calendar.SECOND));
    }

    static Map<String,Double> allPriceForGoods= new HashMap<String, Double>(){
        {
            this.put("Масло", 2.0d);
            this.put("Хлеб", 0.80d);
            this.put("Яйцо", 0.1d);
            this.put("Вода", 0.05d);
            this.put("Сыр", 1.1d);

        }
    };

    static int random(int from, int to){
        int res = from+(int)Math.round(Math.random()*(to-from));
        return res;
    }
}
