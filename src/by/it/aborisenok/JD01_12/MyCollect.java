package by.it.aborisenok.JD01_12;

import java.util.ArrayList;

/**
 * Created by Лёша on 16.09.2016.
 */
public class MyCollect {
    public static ArrayList<Integer> getCross(ArrayList<Integer> A, ArrayList<Integer> B){
        ArrayList<Integer> arrayList = new ArrayList<>(A);
        arrayList.retainAll(B);
        return arrayList;
    }
}

