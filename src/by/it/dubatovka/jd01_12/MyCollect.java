package by.it.dubatovka.jd01_12;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by Dubatovka Sergey on 21.09.2016.
 */
public class MyCollect {

    public static <T extends Number> Set<T> getCross(Set<T> setA, Set<T> setB) {
        setA.retainAll(setB);
        System.out.println("Пересечение A и B - getCross: " + setA);
        return setA;


    }

    public static <T extends Number> Set<T> getUnion(Set<T> setInt1, Set<T> setInt2) {
        setInt1.addAll(setInt2);
        System.out.println("Объединение коллекций - getUnion= "+ setInt1);
        return setInt1;
    }

}
