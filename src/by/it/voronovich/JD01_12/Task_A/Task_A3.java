package by.it.voronovich.JD01_12.Task_A;

import java.util.ArrayList;

/**
 * Класс является решением первого задания А3
 *
 * @author Voronovich Dmitry
 * @version 1.0
 */

public class Task_A3 {

    public static void task_A3() {

        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < 15; i++) {
            int random = -15 + (int) (Math.random() * ((15 - (-15)) + 1));
            list.add(random);
        }
        System.out.print("Рандомный список чисел: ");
        System.out.println(list);

        int i = 0;
        int count = 0;
        while (i < list.size() - count) {
            if (list.get(i) < 0) {
                list.add(list.size() - 1, list.remove(i));
                count++;
            } else {
                i++;
            }
        }
        System.out.print("Отсортированный список чисел: ");
        System.out.println(list);
    }
}
