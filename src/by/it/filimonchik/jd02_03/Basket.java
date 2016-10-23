package by.it.filimonchik.jd02_03;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Raman.Filimonchyk on 24/10/2016.
 */
public class Basket {
    private Map<String, Float> goods = new HashMap<>();

    void putGood(String name, float count) {
        goods.put( name, count );
    }

    public Map<String, Float> getGoods() {
        return goods;
    }

}
