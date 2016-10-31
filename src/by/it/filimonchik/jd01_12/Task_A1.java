package by.it.filimonchik.jd01_12;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Raman.Filimonchyk on 30/10/2016.
 */
public class Task_A1 {
    public static void task_A1() {
        ArrayList<Integer> marks = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            marks.add( (int) (Math.random() * 9 + 2) );
        }
        System.out.println( "Оценки учеников: " + marks );

        Iterator<Integer> iter = marks.iterator();
        while (iter.hasNext()) {
            int s = iter.next();

            if (s < 6) {
                iter.remove();
            }
        }
        System.out.println("Ученики с удовлетворительными оценками:  "+ marks);
    }
}


