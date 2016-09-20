package by.it.aborisenok.JD01_12.TaskA;

import java.util.ArrayList;

/**
 * Created by Лёша on 16.09.2016.
 */
public class MyCollect {
    /**
     * Метод служит для определения пересечений множеств А и В
     * @param A входное выражение типа ArrayList
     * @param B входное выражение типа ArrayList
     */
    public static ArrayList<Integer> getCross(ArrayList<Integer> A, ArrayList<Integer> B){
        ArrayList<Integer> arrayList = new ArrayList<>(A);
        arrayList.retainAll(B);
        return arrayList;
    }
    /**
     * Метод служит для объедиения множеств А и В
     * @param A входное выражение типа ArrayList
     * @param B входное выражение типа ArrayList
     */
    public static ArrayList<Integer> getUnion(ArrayList<Integer> A, ArrayList<Integer> B){
        ArrayList<Integer> generalList = new ArrayList<>(A);
        generalList.removeAll(B);
        generalList.addAll(A);
        return generalList;
    }
}

