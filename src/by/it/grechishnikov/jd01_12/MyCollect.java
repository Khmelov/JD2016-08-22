package by.it.grechishnikov.jd01_12;


import java.util.HashSet;
import java.util.Set;

/**
 * Утилитный класс
 */
public class MyCollect {
    /**
     * Метод возвращает множество объектов, находящихся в обоих множествах
     * @param a - первое множество
     * @param b - второе множество
     * @return - возвращает множество с одинаковыми объектами
     */
    static Set<Integer> getCross(Set<Integer> a, Set<Integer> b) {
        Set<Integer> result = new HashSet<>(a);
        result.retainAll(b);
        return result;
    }

    /**
     * Метод объеденяет 2 множества
     * @param a - первое множество
     * @param b - втрое множество
     * @return - возвращает объеденённое множество
     */
    static Set<Integer> getUnion(Set<Integer> a, Set<Integer> b) {
        Set<Integer> result = new HashSet<>(a);
        result.addAll(b);
        return result;
    }
}
