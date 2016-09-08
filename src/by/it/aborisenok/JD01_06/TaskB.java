package by.it.aborisenok.JD01_06;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Лёша on 07.09.2016.
 */
public class TaskB {
    // Task 1
    public static void deletWords(String text){
        StringBuilder string = new StringBuilder(text);
        Pattern pattern = Pattern.compile("[а-яА-ЯёЁ]{5,}");
        Matcher matcher = pattern.matcher(text);


        while(matcher.find()) {
            String word = matcher.group();
            if(word.length() == 5) {
                if(isWord(word)) {
                    int start = string.indexOf(word);
                    string.delete(start, start + 5);
                }
            }
        }
        System.out.println(string + "\n");
    }

   private static boolean isWord(String word){
        String consonants = "бвгджзйклмнпрстфхцчшщ";
        consonants = consonants + consonants.toUpperCase();
        char first = word.charAt(0);
        //вернем true если согласная в начале
        return (consonants.indexOf(first) >= 0);
    }

    // Task 2
    public static void orderOfSentences(String text) {

        Pattern pattern = Pattern.compile("[.!;]");
        Matcher matcher = pattern.matcher(text);

        char[] chArr = text.toCharArray();
       StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < chArr.length; i++) {
            if (!(chArr[i] == '\n')) {
               stringBuilder.append(chArr[i]);
            }
        }
        String spr = new String(stringBuilder);
        String[] sentences = pattern.split(spr);

        arraySort(sentences, true);

        for (String s : sentences){
            if (!(s.length() == 0))
            System.out.println("count = "+ s.length() + "----" + s);
        }
    }

    private static void arraySort(String[] arr, boolean direction) {
        for (int i = 0; i < arr.length-1; i++){
            for (int j = i+1; j < arr.length; j++) {
                if((direction && arr[i].length() > arr[j].length()) ||
                        (!direction && arr[i].length() < arr[j].length()))
                {
                    String m = arr[i];
                    arr[i] = arr[j];
                    arr[j] = m;
                }
            }
        }
    }

    // Task 3

    public static void wordCount(String text, char ch){
        Pattern pattern = Pattern.compile("[а-яА-ЯёЁ]+");
        Matcher matcher = pattern.matcher(text);
        TreeMap<Integer, ArrayList<String>> treeMap = new TreeMap<>();

    }

    private static int coutLetters(String word, char ch) {
        int count = 0;
        for (int i = 0; i < word.length(); i++){
            if (word.charAt(i) == ch){
                count++;
            }
        }
        return count;
    }
}


