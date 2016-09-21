package by.it.voronovich.JD01_12.Task_C;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Класс является решением первого задания C1
 *
 * @author Voronovich Dmitry
 * @version 1.0
 */

public class Task_C1 {


    public static TreeMap<Integer, String> Map(String text) {
        TreeMap<Integer, String> tm = new TreeMap<>();
        Pattern word = Pattern.compile("[a-zA-Z]+");
        Matcher m = word.matcher(text);

        int n = 0;
        while (m.find()) {
            n++;
            String st = m.group();
            tm.put(n, st);
        }
        return tm;
    }

    public static TreeMap<Integer, String> compressedList(TreeMap<Integer, String> tm) {
        TreeMap<Integer, String> list = new TreeMap<>();
        for (Map.Entry pair : tm.entrySet())
            if (!list.containsValue(pair.getValue()))
                list.put((Integer) pair.getKey(), (String) pair.getValue());
        return list;
    }

    public static void printList(TreeMap<Integer, String> tm) {
        for (Map.Entry pair : tm.entrySet())
            System.out.print(pair.getValue() + "-" + pair.getKey() + "\t");
    }

}
