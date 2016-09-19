package by.it.snegurskiy.jd01_12;

import java.util.*;

/**
 * Created by snegurskiy.nn on 16.09.2016.
 */
public class A12 {

    public static HashMap<String, Integer> supplyAssessment(HashMap<String, Integer> A) {
        HashMap<String, Integer> res=new HashMap<>();
        Set<Map.Entry<String, Integer>> set = A.entrySet();
        for (Map.Entry<String, Integer> me : set) {
            me.setValue((int) (Math.random() * ((5 - 0) + 1)));
            res.put(me.getKey(),me.getValue());
        }
        return res;

        }
}

//(int)(Math.random() * ((5 - 0) + 1))