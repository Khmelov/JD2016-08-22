package by.it.aborisenok.JD01_12;

import java.util.ArrayList;

/**
 * Created by Лёша on 16.09.2016.
 */
public class Utils {
    //Создаём список случайных оценнок
    public static ArrayList<Integer> randomMarkInt(int count){
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int  i = 0; i < count; i++){
            arrayList.add( (int) (Math.random()*10+1)); // мы не звери, нули ученикам ставить не будем, min=1 max=10
        }
        return arrayList;
    }
    //Создаём список случайных значений
    public static ArrayList<Integer> randomInt(int count){
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int  i = 0; i < count; i++){
            arrayList.add( (int) (Math.random()*20));
        }
        return arrayList;
    }

}
