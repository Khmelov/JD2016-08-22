package by.it.aborisenok.JD01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Лёша on 07.09.2016.
 */
public class TaskA {
    // Task 1
    public static void charChange(String text) {

        StringBuilder string = new StringBuilder(text);
        Pattern pattern = Pattern.compile("[а-яА-ЯёЁ]{5,}");
        Matcher matcher = pattern.matcher(string);

        while (matcher.find()) { //пока находятся слова, мы заменяем в них 5 и 7 букву.
            int start = matcher.start(); //тут хранится индекс с которого начинается слово в StringBuilder-е text
            int length = matcher.group().length(); //тут длина найденого слова
            string.setCharAt(start+4,'#');   //заменяем 5-й символ (он есть всегда, так указано в паттерне)
            if (length>6)
                string.setCharAt(start+6,'#'); //заменяет 7-й символ, если позволяет длина слова

            }
        System.out.println(string);
    }

    // Task 2
    public static void wordRepeat(String text) {

        String[] textArr = text.split("[^а-яА-ЯёЁ]+");

        for (int i = 0; i < textArr.length; i++) {
            if (textArr[i].length()>0) {
                int count=1;
                for (int j = i+1; j < textArr.length; j++) {
                    if (textArr[i].equals(textArr[j])) {
                        count++;
                        textArr[j]="";
                    }
                }
                System.out.println("Слово \""+textArr[i]+"\" повторяется " + count + ((count >= 2)&&(count <= 4)? " раза" : " раз"));
            }
        }
    }

    // Task 3
    public static void countOfVowel(String text) {
        Pattern pattern = Pattern.compile("[а-яА-ЯёЁ]+");
        Matcher matcher = pattern.matcher(text);
        int count = 0;


        while (matcher.find()) {
            if (isWord(matcher.group())) {
                System.out.println(matcher.group());
                count++;
            }
        }
        System.out.println("Число найденных слов - " + count);
    }

   private static boolean isWord(String word){
        String vowels = "аеёиоуэюя";
        vowels = vowels + vowels.toUpperCase();

        char first = word.charAt(0);
        char last = word.charAt(word.length()-1);
        //вернем true если гласная в начале и в конце
        return (vowels.indexOf(first)>=0 && vowels.indexOf(last)>=0);
    }

}
