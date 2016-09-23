package by.it.voronovich.JD01_14;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * Класс содержит тела методов решения 2-ого задания
 *
 * @author Voronovich Dmitry
 * @version 1.0
 */

public class Task_B {

    /**
     * Метод выполняет подсчет слов и знаков пунктуации в указанном в параметре файле
     *
     * @param filename
     * @throws IOException
     */
    public static void task_B_count(String filename) throws IOException{

        File txt = new File(filename);
        int countWords = 0;
        int countPunctuation = 0;

        Scanner scanner = null;

        try {
            scanner = new Scanner(txt);
            scanner.useDelimiter("[^а-яА-ЯёЁ]+");
            while(scanner.hasNext()){
                scanner.next();
                countWords++;
            }
            System.out.println("Количество слов: " + countWords);
            scanner.close();

            scanner = new Scanner(txt);
            scanner.useDelimiter("[а-яА-ЯёЁ ]+");
            while(scanner.hasNext()){
                scanner.next();
                countPunctuation++;
            }
            System.out.println("Количество знаков препинания: " + countPunctuation);
        } catch (IOException e){
            System.err.println("Ошибка файла...");
        } finally {
            if(scanner==null){
                scanner.close();
            }
        }
    }
}
