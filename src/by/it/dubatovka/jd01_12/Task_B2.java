package by.it.dubatovka.jd01_12;

import java.util.*;

/**
 * Created by Dubatovka Sergey on 22.09.2016.
 */
public class Task_B2 {

    private static Iterator<Integer> iterator;

    public static void tb2(int N) {
        System.out.println("\nB2. В кругу стоят N человек, пронумерованных от 1 до N. При ведении счета по кругу вычеркивается каждый\n" +
                "второй человек, пока не останется один. Составить два метода processArray и prоcessLinked\n" +
                "моделирующие процесс. Первый должен использовать класс ArrayList, а второй — LinkedList. Какой из\n" +
                "двух методов работает быстрее? Докажите.");
        List<Integer> arrList = new ArrayList<>(N);
        List<Integer> linkedList = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            arrList.add(i, i + 1);
            linkedList.add(i, i + 1);
        }
        processArray((ArrayList<Integer>) arrList);
        processLinked((LinkedList<Integer>) linkedList);
    }

    private static void processArray(ArrayList<Integer> arrList) {
        System.out.println("Удаление из ArrayList: " + removeFromList(arrList));
    }

    private static void processLinked(LinkedList<Integer> linkedList) {
        System.out.println("Удаление из LinkedList: " + removeFromList(linkedList));
        System.out.println("LinkedList при удалении быстрее.");
    }

    private static Double removeFromList(List<Integer> list) {
        int count = 0;

        long iniTime = System.nanoTime();

        while (list.size() > 1) {

            count++;
            iterator = list.iterator();
            while (iterator.hasNext()) {
                count++;
                iterator.next();
                if (count % 2 != 0) {
                    iterator.remove();
                }
            }
        }
        Double delta = (double) (System.nanoTime() - iniTime) / 1000;

        return delta;
    }

}
