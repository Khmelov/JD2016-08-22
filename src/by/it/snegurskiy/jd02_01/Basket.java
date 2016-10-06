package by.it.snegurskiy.jd02_01;

import java.util.*;

/**
 * Created by snegurskiy.nn on 01.10.2016.
 */
public class  Basket {

    public static ArrayList<String> GoodsInBasket() {

        Set<String> goods=Helper.allGoods.keySet();
        ArrayList<String> s= new ArrayList<>();
        s.addAll(goods);
        ArrayList<String> basket= new ArrayList<>();
        for (int i = 0; i <((int)(Math.random()*4+1)) ; i++) {
            basket.add(s.get((int)(Math.random()*4)));


        }

        return basket;
    }


}
