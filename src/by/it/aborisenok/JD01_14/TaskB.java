package by.it.aborisenok.JD01_14;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Лёша on 25.09.2016.
 */
public class TaskB {
    public static void run(){
        String src = System.getProperty("user.dir") + "\\src\\by\\it\\aborisenok\\";
        String is = src + "JD01_14\\text.txt";
        File file = new File(is);
        wordCounter(file);
        punctuationCounter(file);
    }

    public static void wordCounter(File file){
        ArrayList<String> words = new ArrayList<>();

        try(Scanner scanner = new Scanner(file)) {
            while (scanner.hasNext()){
                String s = scanner.nextLine();
                Pattern pattern = Pattern.compile("[a-zA-Z]+");
                Matcher matcher = pattern.matcher(s);
                while (matcher.find()) {
                    words.add(matcher.group());
                }
            }
        } catch (Exception e){
            System.out.println("Error!!!");
        }
        System.out.println("Число слов в тексте - " + words.size());
    }

    public static void punctuationCounter(File file){

        ArrayList<String> punctuations = new ArrayList<>();

        try(Scanner scanner = new Scanner(file)) {
            while (scanner.hasNext()){
                String s = scanner.nextLine();
                Pattern pattern = Pattern.compile("[.,!?;:]+");
                Matcher matcher = pattern.matcher(s);
                while (matcher.find()) {
                    punctuations.add(matcher.group());
                }
            }
        } catch (Exception e){
            System.out.println("Error!!!");
        }
        System.out.println("Число знаков пунктуации в тексте - " + punctuations.size());
    }
}
