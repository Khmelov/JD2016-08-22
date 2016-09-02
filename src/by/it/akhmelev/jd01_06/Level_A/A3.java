package by.it.akhmelev.jd01_06.Level_A;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class A3 {

    static boolean Glasnaya(String word){
        //паттерн для гласных букв
        String oae="яыуаиеоюэё";
        //добавим туда еще и большие
        oae=oae+oae.toUpperCase();
        char first=word.charAt(0);
        char last=word.charAt(word.length()-1);
        //вернем true если гласная в начале и в конце
        return (oae.indexOf(first)>=0 && oae.indexOf(last)>=0);
    }

    public static void main(String[ ] args) {
        //Получим строку в которой можно проводить замену символов.
        StringBuilder text=new StringBuilder(Data.lukomor);
        //сначала переберем все слова.
        //Нас интересуют слова из 1 и более русских букв
        //Паттерн для таких слов [а-яА-ЯёЁ]+
        Pattern p=Pattern.compile("[а-яА-ЯёЁ]+");
        //Теперь получим matcher - эта структура умеет находит слова по паттерну
        Matcher m=p.matcher(text);
        int counter=0;
        while (m.find()) //пока находятся слова, мы подсчитываем число подходящих под проверку
            if (Glasnaya(m.group())) //если проверка показали гласные в начале и конце
            {
                counter++;                     //то увеличим общий счетчик
                System.out.println(m.group()); //и напечатаем слово
            }

        System.out.print(counter);

    }


}
