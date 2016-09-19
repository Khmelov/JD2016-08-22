package by.it.snegurskiy.jd01_12;

import java.util.ArrayList;

/**
 * Created by snegurskiy.nn on 19.09.2016.
 */
public class MyCollect {

    public static ArrayList getCross (ArrayList A, ArrayList B) {
        ArrayList <Integer> res = new ArrayList<Integer>();
        for (int i = 0; i <A.size() ; i++) {
            if (B.contains(A.get(i))) res.add((Integer) A.get(i));

        }
        return res;
    }

    public static ArrayList getUnion (ArrayList A, ArrayList B) {
        ArrayList res=new ArrayList();
        res.addAll(A);
        res.add(B);
        return res;
    }
}
