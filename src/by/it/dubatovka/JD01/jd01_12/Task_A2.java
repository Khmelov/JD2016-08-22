package by.it.dubatovka.JD01.jd01_12;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * Created by Dubatovka Sergey on 21.09.2016.
 */
public class Task_A2 {

    public static void getUnionGetCrossAB() {
        System.out.println("\nA2. Определить два множества (A и B) на основе целых чисел. Создать отдельный класс MyCollect и\n" +
                              "статические методы в нем для определения пересечения множеств getCross и объединения множеств\n" +
                               "getUnion. Показать работу этих методов на примере двух множеств (A и B).\n" );

        Set<Integer> setIntA = genSetArrInt(30);
        Set<Integer> setIntB = genSetArrInt(30);
        System.out.println("Множество А: " + setIntA);
        System.out.println("Множество B: " + setIntB);
        MyCollect.getCross(setIntA,setIntB);
        MyCollect.getUnion(setIntA,setIntB);
    }

    public static Set<Integer> genSetArrInt(int sizeOfSet) {
        Set<Integer> setInt = new HashSet<>(sizeOfSet);
        Random random = new Random();
        for (int i = 0; i < sizeOfSet; i++)
            setInt.add(random.nextInt(2*sizeOfSet)-sizeOfSet+1);
        return setInt;
    }
}
