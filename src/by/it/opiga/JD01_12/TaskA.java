package by.it.opiga.JD01_12;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskA {
public static void main(String[] arg)
{
    //Задание А1
    ArrayList<Integer> marks=new ArrayList<>();
    ArrayList<Integer> badmarks=new ArrayList<>();
    for (int i = 0; i < 10; i++) {
        marks.add((int)(Math.random()*10));
        }
    System.out.println(marks);
    //Pattern p=Pattern.compile("[123]");
    for (int i = 0; i < marks.size(); i++) {
        if(marks.get(i)==1||marks.get(i)==2||marks.get(i)==3||marks.get(i)==0)
        {badmarks.add(marks.get(i));
        marks.remove(i);}
    }
    System.out.println("Удовл оценки: "+marks);
    System.out.println("Неуовл оценки: "+badmarks);

    //Задание А2

    TreeSet<Integer>A=new TreeSet<Integer>();
    TreeSet<Integer>B=new TreeSet<Integer>();
    for (int i = 0; i < 10; i++) {
        A.add((int)(Math.random()*10));
        B.add((int)(Math.random()*10));
    }
    System.out.println("Множество А "+A);
    System.out.println("Множество B "+B);
    System.out.println("Объединение множеств: "+MyCollect.getUnion(A,B));
    System.out.println("Пересечение множеств: "+MyCollect.getCross(A,B));

    //Задание А3
    ArrayList<Integer> m=new ArrayList<>();
    for (int i = 0; i < 10; i++) {
        m.add((int)(Math.random()*10-5));
    }
    TreeSet<Integer> t=new TreeSet<>();
    t.addAll(m);
    System.out.println("список "+m);
    System.out.println("отсортированный список"+t);
    LinkedList<Integer> list=new LinkedList<>();
    for(Integer k:t)
    {
        list.addFirst(k);
    }
    System.out.println("new list "+list);

}

}
