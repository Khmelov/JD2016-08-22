package by.it.dubatovka.jd01_14;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class TaskB {

    /**
     * В файле с текстом подсчитать количество слов и знаков препинания
     */
    static void taskB() throws IOException {
        System.out.println("Задание B. В файле с текстом подсчитать количество слов и знаков препинания" +
                "\n-----------------------------------------");

        String src = System.getProperty("user.dir") + "/src/by/it/dubatovka";
        String filename = src + "/jd01_14/text.txt";
        File file = new File(filename);
        int countPoint = 0, countWord = 0;

        try {
            Scanner scanner = new Scanner(file);
            scanner.useDelimiter("[.,!?-]+");

            while (scanner.hasNext()) {
                scanner.next();
                countPoint++;
            }
            scanner = new Scanner(file);
            scanner.useDelimiter("[а-яА-ЯёЁ]+");
            while (scanner.hasNext()) {
                countWord++;
                scanner.next();
            }
            scanner.close();
            System.out.println("Количество знаков препинания: " + countPoint + "\nКоличество слов: " + countWord);

        } catch (FileNotFoundException e) {
            System.err.println("Ошибка файла: " + e);
            e.printStackTrace();

        }

    }
}

