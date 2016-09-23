package by.it.grechishnikov.jd01_14;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Evgeniy on 21.09.16.
 */
public class TaskB {
    static void run() {
        System.out.println("TaskB");
        String path = System.getProperty("user.dir") + "/src/by/it/grechishnikov/jd01_14" + "/test2.txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            int countWord = 0, countSimbol = 0;
            String newText = "";
            while(reader.ready()) {
                newText += reader.readLine();
            }
            Pattern forWord = Pattern.compile("[а-яА-Яa-zA-Z]+");
            Pattern forSimbol = Pattern.compile("\\p{Punct}");
            Matcher word = forWord.matcher(newText);
            Matcher simbol = forSimbol.matcher(newText);
            while (word.find()) {
                countWord++;
            }
            while (simbol.find()) {
                countSimbol++;
            }
            System.out.printf("Количество слов в тексте = %d, количество знаков припенания = %d\n", countWord, countSimbol);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
