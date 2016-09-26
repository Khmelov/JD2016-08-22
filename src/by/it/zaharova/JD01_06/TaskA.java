package by.it.zaharova.JD01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskA {
    public static String z1(String txt) {
        StringBuilder tmp = new StringBuilder(txt);
        Pattern p = Pattern.compile("[а-яА-ЯёЁ]{5,}");
        Matcher m = p.matcher(tmp);
        while (m.find()) {
            //  System.out.println(m.start()+ " " +m.group()+", ");
            tmp.setCharAt(m.start() + 4, '#');
            if (m.group().length() > 6)
                tmp.setCharAt(m.start() + 6, '#');
        }
        return tmp.toString();
    }

    public static void z2(String txt) {
        String[] words = txt.toUpperCase().split("[^а-яА-яёЁ]+");

        for (int i = 0; i < words.length; i++) {
            int count = 1;
            if (!words[i].isEmpty()) {
                for (int j = i + 1; j < words.length; j++) {
                    if (words[i].equals(words[j])) {
                        count++;
                        words[j] = "";
                    }
                }
                System.out.println(words[i] + " : " + count);
            }
        }
    }

    public static void z3(String txt){
        StringBuilder tmp = new StringBuilder(txt);
        Pattern p = Pattern.compile("\\b[уеыаоэяиюёУЕЫАОЭЯИЮЁ][а-яА-ЯёЁ]*[уеыаоэяиюёУЕЫАОЭЯИЮЁ]\\b");
        Matcher m = p.matcher(tmp);
        int count = 0;
        while (m.find()) {
            System.out.println(m.group());
            count ++;
        }
        System.out.println("Количетво слов, с гласными в начале и конце: " + count);
    }
}
