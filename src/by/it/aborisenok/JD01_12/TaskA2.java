package by.it.aborisenok.JD01_12;

import java.util.ArrayList;

/**
 * Created by Лёша on 16.09.2016.
 */
public class TaskA2 {
    {
        System.out.println("Task A2");
        ArrayList<Integer> a = Utils.randomInt(10);
        System.out.println("А - " + a);
        ArrayList<Integer> b = Utils.randomInt(10);
        System.out.println("В - " + b);
        //Определим пересечения множеств
        System.out.println("Дублируются - " + MyCollect.getCross(a, b));
        //Объеденим множества
        ArrayList<Integer> generalList = new ArrayList<>(a);
        generalList.removeAll(b);
        generalList.addAll(b);
        System.out.println("Совместное множество - " + generalList);
    }
}
