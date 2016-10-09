package by.it.kisel.JD02_01;

import java.util.HashMap;
import java.util.Map;

public class Helper {

    static Map<String,Double> allPriceForGoods= new HashMap<String, Double>(){
        {
            this.put("Масло", 2.0d);
            this.put("Хлеб", 0.80d);
            this.put("Яйцо", 0.1d);
            this.put("Вода", 0.05d);
            this.put("Сыр", 1.1d);

        }
    };

    static int random(int from, int to){
        int res = from+(int)Math.round(Math.random()*(to-from));
        return res;
    }
}
