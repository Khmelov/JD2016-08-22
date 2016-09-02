package by.it.akhmelev.jd01_06.Level_A;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class A1 {


    public static void main(String[ ] args) {
        //Получим строку в которой можно проводить замену символов.
        //это StringBuilder. В String такое делать нельзя.
        StringBuilder text=new StringBuilder(Data.lukomor);

        //сначала переберем все слова.
        //Нас интересуют слова с длиной 5 и выше
        //Паттерн для таких слов [а-яА-ЯёЁ]{5,}
        Pattern p=Pattern.compile("[а-яА-ЯёЁ]{5,}");

        //Теперь получим matcher - эта структура умеет находить слова по паттерну
        Matcher m=p.matcher(text);
        while (m.find()) { //пока находятся слова, мы заменяем в них 5 и 7 букву.
            int start=m.start(); //тут хранится индекс с которого начинается слово в StringBuilder-е text
            int length=m.group().length(); //тут длина найденого слова
            text.setCharAt(start+4,'#');   //заменяем 5-й символ (он есть всегда, так указано в паттерне)
            if (length>6)
                text.setCharAt(start+6,'#'); //заменяет 7-й символ, если позволяет длина слова
        }
        //конец. печатаем массив
        System.out.print(text);
    }

}
