package by.it.voronovich.JD01_12.Task_A;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Класс является решением первого задания А1
 *
 * @author Voronovich Dmitry
 * @version 1.0
 */

public class Task_A1 {

    public static void task_A1(int n) {

        ArrayList<Integer> student = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int random =(int) (Math.random() * ((10 - 0) + 1));
            student.add(random);
        }
        System.out.print("Оценки всех студентов: ");
        System.out.println(student);

        Iterator<Integer> it = student.iterator();

        while(it.hasNext()){
            if(it.next()<=4) {
                it.remove();
            }
        }
        System.out.print("Оценки после удаления неудовлетворительных элементов, тех, что менее 5: ");
        System.out.println(student);
    }
}
