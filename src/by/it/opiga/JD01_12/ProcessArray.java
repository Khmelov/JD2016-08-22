package by.it.opiga.JD01_12;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Asus on 28.09.2016.
 */
public class ProcessArray {


    public static void processArray(List<Integer> base,int n) {
        Timer t = new Timer();
        ArrayList<Integer> list = new ArrayList<Integer>(base);
         while (n!= 1) {
            for (int i = 0; i < n; i++) {
                if (i % 2 == 1) {
                    System.out.println(list.get(i)+" "+i);
                    list.remove(i);
                    n--;
                }
            }
        }
        System.out.println(" удаление из arraylist " + t);

    }


}
