package by.it.voronovich.JD02_03.Programme_Version.Util;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class GoodsList {

    public static ConcurrentMap<String, Double> priceList = new ConcurrentHashMap<String, Double>() {
        {
            this.put("Сахар", 1.0d);
            this.put("Хлеб", 1.1d);
            this.put("Свинина", 7.0d);
            this.put("Говядина", 9.1d);
            this.put("Молоко", 1.3d);
            this.put("Огурцы", 0.7d);
            this.put("Помидоры", 1.1d);
            this.put("Шоколад", 1.5d);
            this.put("Картофель", 0.3d);
        }
    };

    public static List<String> goodsList = new ArrayList<String>() {
        {
            for (String key : priceList.keySet()) {
                this.add(key);
            }
        }
    };


    public static String getGoods() {
        return goodsList.get(new Random().nextInt(goodsList.size() - 1));
    }

    public static String getPrice(String good) {
        return priceList.get(good).toString();
    } //корректировка

    public static double getPriceDoub(String good) {
        return priceList.get(good);
    } //корректировка
}
