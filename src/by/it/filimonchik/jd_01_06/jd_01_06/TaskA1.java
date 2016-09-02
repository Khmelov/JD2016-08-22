package by.it.filimonchik.jd_01_06.jd_01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by user on 02.09.2016.
 */
public class TaskA1 {
    static String z1(String txt) {
        StringBuilder tmp = new StringBuilder(txt);
        Pattern p = Pattern.compile("[а-яА-ЯёЁ](5,)");
        Matcher m = p.matcher(tmp);
        while (m.find()) {
//        System.out.print((m.start()+" "+m.group()+",   ");
            tmp.setCharAt(m.start() + 4, '#');
            if (m.group().length() > 6) ;
            tmp.setCharAt(m.start() + 6, '#');
        }
//    System.out.println(tmp);
        return tmp.toString();
    }

    static void z2(String txt) {
        String[] words = txt.toUpperCase().split("[^а-яА-ЯёЁ]+");
        for (int i = 0; i < words.length; i++) {
            int count = 1;
            if (!words[i].isEmpty()) {
                for (int j = i + 1; j < words.length; j++) {
                    if (words[i].equals(words[j])) {
                        count++;
                        words[j] = "";
                    }
                }
                for (String s : words) {
                    System.out.println(s);
                }
            }
        }
    }
}