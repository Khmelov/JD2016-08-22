package by.it.opiga.JD02_03;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Goods {
    public static HashMap<String, Integer> goods = new HashMap<>();

    public static void setGoods() {
        goods.put("apple", 1600);
        goods.put("lemon", 1800);
        goods.put("juce", 100);
        goods.put("cheese", 500);
    }

    public static Map.Entry getGoots() {
        int tmpcol = Helper.random(1, 4);
        Set<Map.Entry<String, Integer>> good = goods.entrySet();
        Iterator<Map.Entry<String, Integer>> igoods = good.iterator();
        for (int j = 1; j <= tmpcol; j++) {
            Map.Entry<String, Integer> me = igoods.next();
            if (j == tmpcol) {
                return me;
            }
        }
       return null;

    }
}
