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


    public static HashMap<String, Integer> wordsCount() {

        HashMap<String, Integer> hashMap = new HashMap<>();
        String text = MyRandomText.getText();
        Pattern pattern = Pattern.compile("[a-zA-Z]+");
        Matcher matcher = pattern.matcher(text);

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

    public static <T1, T2> void hashMapPrint(HashMap<T1, T2> hashMap ){
        Iterator<Map.Entry<T1, T2>> itr = hashMap.entrySet().iterator();
        while (itr.hasNext()){
            System.out.println(itr.next());
        }
    }
}
