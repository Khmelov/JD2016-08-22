package by.it.opiga.JD01_12;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ProcessLinked {
    public static void processLinked(List<Integer> base, int n) {
        Timer t = new Timer();
        LinkedList<Integer> list = new LinkedList<Integer>(base);
        while (n!= 1) {
            for (int i = 0; i < n; i++) {
                if (i % 2 == 1) {
                    System.out.println(list.get(i)+" "+i);
                    list.remove(i);
                    n--;
                }
            }
        }
        System.out.println(" удаление из LinkedList " + t);

    }



}
