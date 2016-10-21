package by.it.zaharova.JD02_01;

import java.util.HashMap;
import java.util.Map;


public class Basket {

    private Map<String, Float> goods = new HashMap<>();
    void putGood(String name, float count){
        goods.put(name,count);
    }

    public Map<String, Float> getGoods() {
        return goods;
    }

}
