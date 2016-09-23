package by.it.dubatovka.jd01_12;

import java.util.*;

/**
 * Created by Dubatovka Sergey on 21.09.2016.
 */
public class Task_A3 {
    public static void sortPositiveNegative() {
        System.out.println("\n A3. Не используя вспомогательных объектов (т.е. без обмена местами переменных), переставить\n" +
                "отрицательные элементы произвольного списка чисел в конец, а положительные — в начало списка.");
        int listSize = 20;
        List<Integer> list = new ArrayList<>(listSize);
        Random random = new Random();

        for (int i = 0; i < listSize; i++) {
            list.add(random.nextInt(2 * listSize) + 1 - listSize);
        }
        System.out.println(list);
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        System.out.println(list);

    }
}
