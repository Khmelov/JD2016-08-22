package by.it.voronovich.JD01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Класс содержит тело метода для решения задачи 1 блока B
 *
 * @author Voronovich Dmitry
 * @version 1.0
 */

public class TaskB1 {

    /**
     * Метод удаляет все слова длины 5, начинающиеся на согласную букву.
     */
    public static void b1()  {

        StringBuilder text = new StringBuilder(Data.lukomorie);

        Pattern p = Pattern.compile("[а-яА-ЯёЁ]{5,}");

        Matcher m = p.matcher(Data.lukomorie);

        String part ="йцкнгшщзхфвпрлджчсмтб";
        part = part + part.toUpperCase();

        while (m.find()){
            String word = m.group();
            if(word.length()==5 && part.contains(String.valueOf(word.charAt(0)))){
                int start = text.indexOf(word);
                text.delete(start, start+5);
            }
        }
        System.out.println(text);
    }


}

