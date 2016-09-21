package by.it.voronovich.JD01_12.Task_B;

import java.util.*;

/**
 * Класс является решением первого задания В1
 *
 * @author Voronovich Dmitry
 * @version 1.0
 */

public class Task_B1 {

    public static void task_B1(String text) {

        String arr[] = text.trim().split("[^a-zA-Z]+");
        List<String> list = new ArrayList<String>(Arrays.asList(arr));

        HashMap<String, Integer> map = new HashMap<>();
        Integer x;
        for (String i : list) {
            x = map.get(i);
            map.put(i, x == null ? 1 : x + 1);
        }
        System.out.println(map);
    }
}