package by.it.aborisenok.JD02_02;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Лёша on 26.09.2016.
 */
public class Backet {
    private Map<String, Integer> goods = new HashMap<>();

    public void putGood(String name, int count){
        goods.put(name, count);
    }

    public Map<String, Integer> getGoods(){
        return goods;
    }

    public Integer getCountGoods(String name){
       return goods.get(name);
    }
 }
