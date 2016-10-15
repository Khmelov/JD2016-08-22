package by.it.dubatovka.jd02_01;


import java.util.*;

 class PriceList {

    /**
     * Прайслист с продуктами
     */

     private HashMap<Good, Double> goods = new HashMap<>();

    {
        goods.put(Good.Молоко, 1.5);
        goods.put(Good.Хлеб, 1.2);
        goods.put(Good.Сыр, 3.0);
        goods.put(Good.Яблоки, 0.7);
        goods.put(Good.Шоколад, 1.0);
        goods.put(Good.Кофе, 4.0);
    }
}
