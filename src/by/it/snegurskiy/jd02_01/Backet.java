package by.it.snegurskiy.jd02_01;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by snegurskiy.nn on 26.09.2016.
 */
public class Backet {
    private Map<String,Float> goods=new HashMap<>();
    void putGood(String name, float count){
        goods.put (name,count);
    }

    public Map<String,Float> getGoods(){
        return goods;
    }
    public Float getCountGoods(String name){
        return goods.get(name);
    }
}
