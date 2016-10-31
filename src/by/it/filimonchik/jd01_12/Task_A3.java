package by.it.filimonchik.jd01_12;

import java.util.*;

/**
 * Created by Raman.Filimonchyk on 31/10/2016.
 */
public class Task_A3 {
    public static void task_A3() {
        TreeSet<Integer> marks = new TreeSet<>();
        for (int i = 0; i < 20; i++) {
            marks.add( (int) (Math.random() * 11 -5) );
        }
        LinkedList<Integer> list=new LinkedList<>();
        for(Integer k:marks)
        {
            list.addFirst(k);
        }
        System.out.println(list);

    }
}
