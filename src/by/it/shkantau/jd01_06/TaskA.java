package by.it.shkantau.jd01_06;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Aliaksei on 15.09.2016.
 */
public class TaskA {
    private static Pattern pattern;
    private static Matcher matcher;

//    В каждом слове текста буквы No 5-ю и 7-ю заменить символом #. Для слов короче 5
//    корректировку не выполнять.
    public  static void  a1 (String text){
        System.out.println("TaskA1");
        StringBuilder sbResult = new StringBuilder(text);
        String word ;
        pattern = Pattern.compile(Regexes.regexRussianWord);
        matcher = pattern.matcher(text);

        while(matcher.find()){
            word = matcher.group();
            sbResult.setCharAt(matcher.start()+4,'#');
            if (word.length()>7) {
                sbResult.setCharAt(matcher.start() + 6, '#');
            }
        }
        System.out.println(sbResult);
    }

//    Определить, сколько раз повторяется в тексте каждое слово, которое встречается в нем.
    public static void a2 (String text){
        System.out.println("\nTaskA2");
        List <String > words = new ArrayList<>(200);
        pattern = Pattern.compile(Regexes.regexRussianWord);
        matcher = pattern.matcher(text);

        while (matcher.find()){
            words.add(matcher.group());
        }
        Set<String> unique = new HashSet<String>(words);
        for (String key : unique) {
            System.out.println(key + ": " + Collections.frequency(words, key));
        }
    }
//    В стихотворении найти количество слов, начинающихся и заканчивающихся гласной буквой
    public static void a3 (String text) {
        System.out.println("\nTaskA3");
        List <String > words = new ArrayList<>(200);
        int repetitionCounter = 0;

        pattern = Pattern.compile(Regexes.regexRussianWord);
        matcher = pattern.matcher(text);
        while(matcher.find()){
            words.add(matcher.group());
        }

        for (String word : words) {
            if(Pattern.matches(Regexes.regexVowel, word)){
//                System.out.println(word);
                repetitionCounter++;
            }
        }
        System.out.println("Count of the word repetition starts with vowel and finish with vowel = " + repetitionCounter);
    }
}
