package by.it.grechishnikov.jd01_12;


import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Задание А
 * @author Grechishnikov
 * @version 1.0
 */
public class TaskA {
    static void start() {
        taskA1();
        taskA2();
        taskA3();
    }

    /**
     * Задание А1
     * Генерируются случайные оценки для 15 учеников.
     * Затем удаляются все оценки ниже 5.
     */
    private static void taskA1() {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            list.add(ThreadLocalRandom.current().nextInt(0, 10));
        }
        System.out.println("Оценки 15 учеников:\n" + list);

        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            int tmp = iterator.next();
            if(tmp < 5) {
                iterator.remove();
            }
        }
        System.out.println("Удаляем оценки ниже 5:\n" + list);
    }

    /**
     * Задание А2
     * Генерируем 2 множества на 10 элементов каждое.
     * Сначала объеденяем множества, затем находим пересечения значений множества
     */
    private static void taskA2() {
        Set<Integer> a = new HashSet<>();
        for (int i = 0; i < 10; i++) {
            a.add(i);
        }
        Set<Integer> b = new HashSet<>();
        for (int i = 5; i < 15; i++) {
            b.add(i);
        }

        System.out.println("Объеденыннеы множества:\n" + MyCollect.getUnion(a, b));
        System.out.println("Множество пересечения:\n" + MyCollect.getCross(a, b));
    }

    /**
     * Задание А3
     * Генерируем список случайных чисел от -10 да 10 на 15 элементов.
     * Затем сдвигаем отрицательные числа в конец списка без использования сторонних объектов
     */
    private static void taskA3() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            list.add(ThreadLocalRandom.current().nextInt(-10, 10));
        }
        System.out.println("Изначальный список чисел:\n" + list);
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        System.out.println("Сдвигаем отрицательные числа в конец:\n" + list);
    }
}