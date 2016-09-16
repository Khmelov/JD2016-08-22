package by.it.prymshyts.jd01_12;

import by.it.akhmelev.jd01_12.CollectionsSpeed;
import by.it.prymshyts.jd01_02.Util;

import java.util.*;

public class TaskB {

    static void t1() {
        String[] txt = Data.b1Txt.split("[\\W]+");

        HashMap<String, Integer> map = new HashMap<>();

        for (String str : txt) {
            if (map.containsKey(str)) {
                map.put(str, map.get(str) + 1);
            } else {
                map.put(str, 1);
            }
        }

        System.out.println("Слово и его количество повторений в тексте:");
        System.out.println(map);
    }

    static void t2() {
        int N = Util.getRandomNum(10, 20);
        ArrayList<Integer> listArray = new ArrayList<>(N);
        LinkedList<Integer> listLinked = new LinkedList<>();

        for (Integer i = 1; i <= N; i++) {
            listArray.add(i);
            listLinked.add(i);
        }

        CollectionsSpeed.Timer timer = new CollectionsSpeed.Timer();

        processList(listArray);
        System.out.println("Удаление из ArrayList: " + timer);

        processList(listLinked);
        System.out.println("Удаление из LinkedList: " + timer);

    }

    private static void processList(List<Integer> list) {
        Iterator<Integer> it = list.iterator();

        boolean toDel = false;

        while (list.size() > 1) {
            if (!it.hasNext()) {
                it = list.listIterator();
            }
            it.next();
            if (toDel) {
                it.remove();
                toDel = false;
            } else {
                toDel = true;
            }
        }
    }
}
