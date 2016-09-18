package by.it.opiga.JD01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Asus on 16.09.2016.
 */
public class TaskC {
    public static void z7(String txt) {
        Pattern p = Pattern.compile("[ауеэоыяиюёУЕЭОАЫЯИЮЁ]");
        String[] words = txt.split("[^а-яА-ЯёЁ]+");

        int count = 0;
        int[] col = new int[words.length];

        for (int i = 0; i < words.length; i++) {
            col[i] = words[i].length();
            System.out.println(words[i] + " " + col[i]);
        }

        System.out.println("\n после сортировки \n");
        int itemp;
        String stemp;
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (col[i] < col[j]) {
                    itemp = col[i];
                    col[i] = col[j];
                    col[j] = itemp;
                    stemp = words[i];
                    words[i] = words[j];
                    words[j] = stemp;
                }
                if (col[i] == col[j]) {
                    int colGlas1 = 0, colGlas2 = 0;
                    //System.out.println("Слова одинаковой длины ");
                    Matcher m1 = p.matcher(words[i]);
                    while (m1.find()) {
                        colGlas1++;
                    }
                    Matcher m2 = p.matcher(words[j]);
                    while (m2.find()) {
                        colGlas2++;
                    }
                    if (colGlas1 > colGlas2) {
                        stemp = words[i];
                        words[i] = words[j];
                        words[j] = stemp;
                        itemp = col[i];
                        col[i] = col[j];
                        col[j] = itemp;
                    }

                }
            }
        }
        for (int i = 0; i < words.length; i++) {
            System.out.println(words[i] + " " + col[i]);
        }


    }


}
