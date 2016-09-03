package by.it.grechishnikov.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class TaskB {
    public static void b1() {
//        Удалить слова длинны 5, которые начинаются на согласную
        Pattern p = Pattern.compile("[а-яА-ЯёЁ]{5,}");
        StringBuilder text = new StringBuilder(Runner.text);
        Matcher m = p.matcher(text);
        String pattern = "бвгджзклмнпрстфхцчшщъыь";
        pattern += pattern.toUpperCase();

        while(m.find()) {
            String word = m.group();
            if(word.length() != 5) {
                continue;
            } else {
                if(pattern.contains(String.valueOf(word.charAt(0)))) {
                    int start = text.indexOf(word);
                    text.delete(start, start + 5);
                }
            }
        }
        System.out.println(text);

//        String[] arr = Runner.text.split(" ");
//        String pattern = "бвгджзклмнпрстфхцчшщъыь";
//        StringBuilder b = new StringBuilder(Runner.text);
//
//        for(String s : arr) {
//            if(s.length() != 5) {
//                continue;
//            } else {
//                if(pattern.contains(String.valueOf(s.charAt(0)))) {
//                    int start = b.indexOf(s);
//                    b.delete(start, start + 5);
//                }
//            }
//        }
//        System.out.println(b);
    }
}
