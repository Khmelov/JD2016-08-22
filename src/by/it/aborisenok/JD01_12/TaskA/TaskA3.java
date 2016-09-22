package by.it.aborisenok.JD01_12.TaskA;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/**
 * Created by Лёша on 19.09.2016.
 */
public class TaskA3 {

    {
        System.out.println("***TaskA3");
        ArrayList<Integer> arrayList = TaskA3.randomInt(20);
        System.out.println("Случайное множество - " + arrayList);
        Collections.sort(arrayList);
        Collections.reverse(arrayList);
        System.out.println("Отсортированное множество - " + arrayList);
    }


    /**
     * Метод служит для заполнения списка случайными значениями [-10;20]
     * @param count входное выражение типа int
     */
    public static ArrayList<Integer> randomInt(int count){
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int  i = 0; i < count; i++){
            arrayList.add( (int) (Math.random()*20-10));
        }
        return arrayList;
    }
}
