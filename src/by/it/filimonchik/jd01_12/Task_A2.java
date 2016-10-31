package by.it.filimonchik.jd01_12;

import java.util.HashSet;

/**
 * Created by Raman.Filimonchyk on 31/10/2016.
 */
public class Task_A2 {
    public static void task_A2() {
        HashSet<Integer> a = new HashSet<>();
        for (int i = 0; i < 7; i++) {
            a.add( i );
        }

        HashSet<Integer> b = new HashSet<>();
        for (int i = 4; i < 11; i++) {
            b.add( i );
        }
        System.out.println( "Объединение множеств: " + MyCollect.getUnion( a, b ) );
        System.out.println( "Пересечение множеств: " + MyCollect.getCross( a, b ) );
    }
}
