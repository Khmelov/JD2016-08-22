package by.it.aborisenok.JD02_02;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by Лёша on 26.09.2016.
 */
public class Helper {

    static Map<String, Double> allPriceForGoods = new HashMap<String, Double>(){
        {
            this.put("Butter", 2.45);
            this.put("Milk", 1.95);
            this.put("Bread", 0.45);
            this.put("Chicken", 5.21);
            this.put("Meat", 9.35);
            this.put("Beer", 1.12);
            this.put("Nuts", 34.66);
            this.put("Sugar", 1.35);
        }
    };

    public static String getKeyGood(){
        Set<String> keyGoods = allPriceForGoods.keySet(); // можно это перенести в хелпер так ка повторяем одно и тоже
        int numberGood = Helper.random(0, keyGoods.size()-1);
        String keyGood = (String) keyGoods.toArray()[numberGood];
        return keyGood;
    }

    public static int random(int from, int to){
        int result = from + (int)Math.round(Math.random()*(to-from));
        return result;
    }
}
