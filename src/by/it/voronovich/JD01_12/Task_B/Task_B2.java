package by.it.voronovich.JD01_12.Task_B;

import java.util.*;

/**
 * Класс является решением второго задания B2
 *
 * @author Voronovich Dmitry
 * @version 1.0
 */

public class Task_B2 {

    public static void processArray() {
        ArrayList<Integer> list1 = new ArrayList<>();
        int n = 17;
        for (int i = 0; i < n; i++) {
            int random = i + 1;
            list1.add(i, random);
        }
        System.out.print("Исходное количество людей: ");
        System.out.println(list1);

        Timer t = new Timer();
        Iterator it = list1.iterator();
        int z = 0;
        while (list1.size() > 1) {
            if (it.hasNext()) {
                it.next();
                z++;
                if (z == 2) {
                    it.remove();
                    z = 0;
                }
            } else {
                it = list1.iterator();
            }
        }
        System.out.println(t + " для Array");
        System.out.println(list1);
    }

    public static void processLinked() {

        LinkedList<Integer> list2 = new LinkedList<>();
        int n = 17;
        for (int i = 0; i < n; i++) {
            int random = i + 1;
            list2.add(i, random);
        }
        System.out.print("Исходное количество людей: ");
        System.out.println(list2);

        Timer t=new Timer();
        Iterator it = list2.iterator();
        int z = 0;
        while (list2.size() > 1) {
            if (it.hasNext()) {
                it.next();
                z++;
                if (z == 2) {
                    it.remove();
                    z = 0;
                }
            } else {
                it = list2.iterator();
            }
        }
        System.out.println(t + " для Linked");
        System.out.print("Оставщийся номер: ");
        System.out.println(list2);
    }


    //вспомогательный nested-класс для измерения быстродействия
    public static class Timer {
        private long iniTime;
        private Double Delta;

        public Timer() {
            iniTime = System.nanoTime();
        }

        public String toString() {
            Delta = (double) (System.nanoTime() - iniTime) / 1000;
            iniTime = System.nanoTime();

            return "Прошло " + Delta.toString() + " микросекунд.";
        }

    }
}