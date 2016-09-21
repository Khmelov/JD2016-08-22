package by.it.voronovich.JD01_12.Task_A;

import java.util.*;

/**
 * Класс находит объединение и пересечение множеств
 *
 * @author Voronovich Dmitry
 * @version 1.0
 */

public class MyCollect {

    public static String getCross(ArrayList<Integer> list1, ArrayList<Integer> list2) {

        Set<Integer> set1 = new HashSet<>(list1);
        Set<Integer> set2 = new HashSet<>(list2);
        set1.retainAll(set2);
        return "Пересечение множеств: " + set1;
    }

    public static String getUnion(ArrayList<Integer> list1, ArrayList<Integer> list2) {

        Set<Integer> set1 = new HashSet<>(list1);
        Set<Integer> set2 = new HashSet<>(list2);
        set1.addAll(set2);
        return "Объединение множеств: " + set1;
    }

}
