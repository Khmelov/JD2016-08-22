package by.it.aborisenok.JD01_12.TaskC;

import by.it.aborisenok.JD01_12.TaskA.*;

import java.util.ArrayList;

/**
 * Created by Лёша on 20.09.2016.
 */
public class TaskC2 {
    {
        System.out.println("***Task A2");
        ArrayList<Integer> A = Utils.randomInt(10);
        System.out.println("А - " + A);
        ArrayList<Integer> B = Utils.randomInt(10);
        System.out.println("В - " + B);
        //Определим пересечения множеств
        System.out.println("Дублируются - " + MyCollect.getCross(A, B));
        //Объеденим множества
        ArrayList<Integer> generalList = MyCollect.getUnion(A, B);
        System.out.println("Совместное множество - " + generalList);
    }
}
