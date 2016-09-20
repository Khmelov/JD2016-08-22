package by.it.aborisenok.JD01_12.TaskC;

import java.util.ArrayList;

/**
 * Created by Лёша on 20.09.2016.
 */
public class MyCollect {
    public static <T> ArrayList<T> getCross(ArrayList<T> A, ArrayList<T> B){
        ArrayList<T> arrayList = new ArrayList<>(A);
        arrayList.retainAll(B);
        return arrayList;
    }

    public static <T> ArrayList<T> getUnion(ArrayList<T> A, ArrayList<T> B){
        ArrayList<T> generalList = new ArrayList<>(A);
        generalList.removeAll(B);
        generalList.addAll(A);
        return generalList;
    }
}
