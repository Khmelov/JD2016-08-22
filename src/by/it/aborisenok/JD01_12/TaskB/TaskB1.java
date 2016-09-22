package by.it.aborisenok.JD01_12.TaskB;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Лёша on 19.09.2016.
 */
public class TaskB1 {

    {
        System.out.println("***TaskB1");
        HashMap<String,Integer> hashMap = TaskB1.wordsCount();
        TaskB1.hashMapPrint(hashMap);
    }

    /**
     * Метод служит для определения колличества повторений слов
     */
    public static HashMap<String, Integer> wordsCount() {
        // создаём список для кранения слова и числа его повторений
        HashMap<String, Integer> hashMap = new HashMap<>();
        String text = MyRandomText.getText();
        // создаём шаблон для поиска слов
        Pattern pattern = Pattern.compile("[a-zA-Z]+");
        Matcher matcher = pattern.matcher(text);
            // заполняем список словами и их повторениями
        while (matcher.find()) {
            String word = matcher.group();
            if (!hashMap.containsKey(word)){
                hashMap.put(word, 1);
            } else
            if (hashMap.containsKey(word)){
                hashMap.put(word, hashMap.get(word)+1);
            }
        }
        return hashMap;
    }

    /**
     * Метод служит для выода на печать карты HashMap
     * @param hashMap входное выражение типа HashMap
     */
    public static <T1, T2> void hashMapPrint(HashMap<T1, T2> hashMap ){
        Iterator<Map.Entry<T1, T2>> itr = hashMap.entrySet().iterator();
        while (itr.hasNext()){
            System.out.println(itr.next());
        }
    }
}
