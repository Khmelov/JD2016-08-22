package by.it.kisel.JD01_06;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB {
    public static void z_1(String txt) {
        StringBuilder tmp = new StringBuilder(txt);
        Pattern p = Pattern.compile("\\b[йцкнгшщзхъфвпрлджчсмтьбЙЦКНГШЩЗХЪФВПРЛДЖЧСМТЬБ][а-яА-ЯёЁ]{4}\\b");
        Matcher m = p.matcher(tmp);
        System.out.println();
        int pos = 0;
        while (m.find(pos)) {
            System.out.println(m.group());
            tmp.delete(m.start(), m.end());
            pos=m.start();
            // m.reset(); //сбрасывает в самое начало(менее эффективный)
        }
        System.out.println(tmp);
    }


    public static void z_2 (String txt){
        String[] predl = txt.split("[.?!]+\\s*");
        String[] words = txt.split("[^а-яА-яёЁ]+");

        for (int i = 0; i < predl.length ; i++) {

            int count = 0;
            System.out.print(predl[i]+" ");
//
//            for (int j = 0; j < words.length ; j++) {
//
//                count++;
//                System.out.println(words[j]);
//            }
//            System.out.println(count);
        }


    }


}