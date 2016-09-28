package by.it.opiga.JD01_12;

import java.io.*;
import java.util.*;

/**
 * Created by Asus on 28.09.2016.
 */
public class TaskC {
public static void main(String []arg)
{   Timer t=new Timer();
    TreeMap<String,Integer> a=new TreeMap<>();
    HashMap<String,Integer> b=new HashMap<>();
    for (int i = 0; i <100000 ; i++) {
        a.put(" элемент "+i,10+i);
    }
    System.out.println("TreeMap "+t);
    for (int i = 0; i <100000 ; i++) {
        b.put(" элемент "+i,10+i);
    }
    System.out.println("HashMap "+t);

    ArrayList<Integer> arrlist=new ArrayList<>();
    for (int i = 0; i < 10; i++) {
        arrlist.add((int)(Math.random()*10+10));
    }
    System.out.println(arrlist);
    System.out.println(Sorted.sortArr(arrlist));
    System.out.println("Сортировка Arraylist "+t);

    LinkedList<Integer> linklist=new LinkedList<>();
    for (int i = 0; i < 10; i++) {
        linklist.add((int)(Math.random()*10+10));
    }
    System.out.println(linklist);
    System.out.println(Sorted.sortLink(linklist));
    System.out.println("Сортировка LinkedList "+t);


    }


}



