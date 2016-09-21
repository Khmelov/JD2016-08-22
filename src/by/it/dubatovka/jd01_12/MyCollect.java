package by.it.dubatovka.jd01_12;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by Dubatovka Sergey on 21.09.2016.
 */
public class MyCollect {

    public static Set<Integer> getCross(Set<Integer> setIntA, Set<Integer> setIntB) {
        Set<Integer> setAB = new HashSet<>();
        Iterator<Integer> iteratorSetA = setIntA.iterator();

        while (iteratorSetA.hasNext()) {
            if (setIntB.contains(iteratorSetA.next())) {
                setAB.add(iteratorSetA.next());
            }
        }
        System.out.println("Пересечение A и B - getCross: "+ setAB);
        return setAB;
    }



}
