package by.it.filimonchik.jd01_14;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * Created by Raman.Filimonchyk on 03/10/2016.
 */
public class ScanText {
    public static void B() throws Exception {
        int sumWords = 0;
        int sumSimbols = 0;
        String src = System.getProperty("user.dir") + "/src/by/it/filimonchik/";
        String filename = src + "jd01_14/TestFile.txt";
        try {
            Scanner scan = new Scanner(new File(filename));
            scan.useDelimiter("[^а-яА-яЁёA-Za-z0-9]+");
            while (scan.hasNext()){
                scan.next();
                sumSimbols++;
            }
            scan.close();
            System.out.println("Task B.");
            System.out.println("Количество слов в тексте: " + sumSimbols);
            Scanner scanner = new Scanner(new File(filename));
            {
                scanner.useDelimiter("[а-яА-яЁёA-Za-z0-9 ]+");
                while (scanner.hasNext()){
                    scanner.next();
                    sumWords++;
                }
            System.out.println("Количество знаков препинания тексте: " + sumWords);
                scan.close();
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("Файл не найден");
        }
        catch (IllegalStateException e){
            System.out.println("Сканнер закрыт для чтения");
        }
        catch (Exception e){
            System.out.println("Что-то пошло не так, повторите попытку позже");
        }
    }
}