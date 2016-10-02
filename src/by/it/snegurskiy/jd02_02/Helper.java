package by.it.snegurskiy.jd02_02;

import java.util.HashMap;

/**
 * Created by snegurskiy.nn on 02.10.2016.
 */
public class Helper {
    public static HashMap<String,Double> allGoods=new HashMap<String,Double>(){
        {
            this.put("Масло", 1.9d);
            this.put("Хлеб", 0.8d);
            this.put("Молоко", 1.2d);
            this.put("Кефир", 1.0d);
        }

    };
}
