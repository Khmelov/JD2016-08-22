package by.it.snegurskiy.jd01_12;

import java.util.*;

/**
 * Created by snegurskiy.nn on 16.09.2016.
 */
public class Runner12 {
    public static void main(String[] args) {


        HashMap<String, Integer> spisok = new HashMap<String, Integer>();
        spisok.put("Ivanov", 0);
        spisok.put("Petrov", 0);
        spisok.put("Sidorov", 0);
        spisok.put("Ivanova", 0);
        spisok.put("Jevnov", 0);
        spisok.put("Kim", 0);
        spisok=A12.supplyAssessment(spisok);// проставил оценки рандом
        ArrayList <Integer> Assessment = new ArrayList<Integer>();
//        System.out.println("Залание А1");
//        A12.A1(Assessment);
//        System.out.println(Assessment);
//        A12.A11(Assessment);
//        System.out.println(Assessment);
        System.out.println("Залание А2");
//        ArrayList <Integer> Assessment = new ArrayList<Integer>();
//        ArrayList <Integer> Assessment = new ArrayList<Integer>();

        //System.out.println(spisok);
    }
}
