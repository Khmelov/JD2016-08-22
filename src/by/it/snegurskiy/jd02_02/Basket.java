package by.it.snegurskiy.jd02_02;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Random;

/**
 * Created by snegurskiy.nn on 02.10.2016.
 */
public class Basket {
    public static Hashtable GoodsInBasket() {
        Hashtable<String, Double> basket = new Hashtable<>();
        basket.putAll(Helper.allGoods);
        try {
            for (Map.Entry<String, Double> item : basket.entrySet()) {
                Random random = new Random();
                if (random.nextBoolean() == true) {
                    basket.remove(item.getKey());
                }

            }


        } catch (Exception e) {
            System.out.println(e);
        }
        return basket;
    }
}
