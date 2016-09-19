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
        System.out.println(spisok);
        spisok=A12.supplyAssessment(spisok);// проставил оценки рандом

        System.out.println(spisok);
    }
}
