package by.it.aborisenok.JD01_06;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Лёша on 07.09.2016.
 */
public class TaskB {
    // Task 1
    public static void deletWords(String text){
        StringBuilder string = new StringBuilder(text);
        Pattern pattern = Pattern.compile("[а-яА-ЯёЁ]+");
        Matcher matcher = pattern.matcher(string);

       String s =  text.replaceAll("[а-яА-ЯёЁ]+", "*");

        System.out.println(s);
//        while (matcher.find()) {
//            int first = matcher.start();
//            int end = matcher.end();
//            int length = matcher.group().length(); //тут длина найденого слова
//
//            if ((length == 5) && isWord(matcher.group())){
//                System.out.println(matcher.group());
//                string.delete(first, end);
//
//            }
//        }

    }

   private static boolean isWord(String word){
        String consonants = "бвгджзйклмнпрстфхцчшщ";
        consonants = consonants + consonants.toUpperCase();
        char first = word.charAt(0);
        //вернем true если согласная в начале
        return (consonants.indexOf(first) >= 0);
    }
}


// \b\w{3,}\b  слова 3 и более букв