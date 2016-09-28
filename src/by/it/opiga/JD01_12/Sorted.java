package by.it.opiga.JD01_12;

import java.util.ArrayList;
import java.util.LinkedList;


public class Sorted {
    public static ArrayList<Integer> sortArr(ArrayList<Integer> mas) {
        Integer temp;
        int last = mas.size() - 1;
        boolean swap;
        do {
            swap = false;
            for (int i = 0; i <last ; i++) {
                if (mas.get(i).compareTo(mas.get(i+1))<0) {
                    temp = mas.get(i+1);
                    mas.remove(i+1);
                    mas.add(i,temp);
                    swap = true;
                }
            }
            last--;
        } while (swap);
        return mas;
    }
    public static LinkedList<Integer> sortLink(LinkedList<Integer> mas) {
        Integer temp;
        int last = mas.size() - 1;
        boolean swap;
        do {
            swap = false;
            for (int i = 0; i <last ; i++) {
                if (mas.get(i).compareTo(mas.get(i+1))<0) {
                    temp = mas.get(i+1);
                    mas.remove(i+1);
                    mas.add(i,temp);
                    swap = true;
                }
            }
            last--;
        } while (swap);
        return mas;
    }
}
