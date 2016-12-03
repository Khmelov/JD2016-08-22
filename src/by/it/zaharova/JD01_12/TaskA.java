package by.it.zaharova.JD01_12;

import java.util.*;


public class TaskA {

    static void t1() {
        int studentsNum = Util.getRandomNum(10, 30);
        List<Integer> list = new ArrayList<>(studentsNum);

        for (int i = 1; i <= studentsNum; i++) {
            list.add(Util.getRandomNum(1, 10));
        }

        System.out.println("Изначальный список:");
        System.out.println(list);

        for (Iterator<Integer> it = list.iterator(); it.hasNext();) {
            Integer element = it.next();

            if (element < 4) {
                it.remove();
            }
        }

        System.out.println("Обработанный список:");
        System.out.println(list);
    }

    static void t2() {
        List<Integer> l1 = new ArrayList<>(5);
        l1.add(4);
        l1.add(1);
        l1.add(6);
        l1.add(3);
        l1.add(2);

        System.out.println("Первое множество: " + l1);

        List<Integer> l2 = new ArrayList<>(5);
        l2.add(7);
        l2.add(5);
        l2.add(6);
        l2.add(1);
        l2.add(0);

        System.out.println("Второе множество: " + l2);

        System.out.print("Пересечение множеств: ");
        System.out.println(Collect.getCross(l1, l2));
        System.out.print("Объединение множеств: ");
        System.out.println(Collect.getUnion(l1, l2));
    }

    static void t3() {
        LinkedList<Integer> list = new LinkedList<>();

        for (int i = 0; i < 10; i++) {
            list.add(Util.getRandomNum(-10, 10));
        }

        System.out.print("Список до сортировки: ");
        System.out.println(list);

        Collections.sort(list);
        Collections.reverse(list);

        System.out.print("Список после сортировки: ");
        System.out.println(list);
    }
}
