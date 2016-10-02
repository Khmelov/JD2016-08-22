package by.it.snegurskiy.jd02_01;

import javax.swing.text.html.HTMLDocument;
import java.util.*;

/**
 * Created by snegurskiy.nn on 01.10.2016.
 */
public class  Basket {

    public static HashMap GoodsInBasket() {
        HashMap<String, Double> basket = new HashMap<String, Double>();
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
