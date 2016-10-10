package by.it.aborisenok.JD01_15;

import java.io.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Лёша on 25.09.2016.
 */
public class TaskB {
    public static void run(){
        String isrc = System.getProperty("user.dir") + "\\src\\by\\it\\aborisenok\\";
        String is = isrc + "JD01_15\\TaskB.java";// исходный java файл
        String osrc = System.getProperty("user.dir") + "\\src\\by\\it\\aborisenok\\";
        String os = osrc + "JD01_15\\TaskB.txt//"; // файл// куда пишется текст программы
        String text = comentsDeliter(javaFileRider(is));
        System.out.println(text); // вывод отредактированого текста в консоль
        javaFileWriter(os, text);
    }
    /**
     * Метод служит для чтения текста из java файла
     *
     * @param is путь файла для чтения
     */
    public static StringBuilder javaFileRider(String is){
        StringBuilder text = new StringBuilder();
        try(BufferedReader reader = new BufferedReader(new FileReader(is))) {
            while (reader.ready()){
                text.append(reader.readLine() + "\n");
            }
        } catch (IOException e){
            System.out.println("File error");
        }
        return  text;
    }
    /**
     * Метод служит удаления комментариев из текста
     *
     * @param string исходный текст
     */
    public static String comentsDeliter(StringBuilder string){
        // удаление однострочных коментариев
        String text = string.toString();
        String s = text.replaceAll("\\/\\/.+", "");
        text = s.replaceAll("\\/\\*\\*\\n(( *\\*.*)\\n)*", "");
        return text;
    }

    /**
     * Метод служит для записи текста программы без комментариев в файл
     *
     * @param os путь файла для записи
     * @param text текст который нужно записать
     */
    public static void javaFileWriter(String os, String text){
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(os))) {
            ArrayList<String> arrayList = textMakeUp(text);
            int count = 1;
            for (String str : arrayList){
                writer.write(count + ": " + str);
                writer.newLine();
               count++;
            }

        } catch (IOException e){
            System.out.println("File error");
        }
    }

    public static ArrayList<String> textMakeUp(String text){
        String[] array = text.split("\n");
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i = 0; i < array.length; i++){
            if (!array[i].equals("")){
                arrayList.add(array[i]);
            }
        }
        return arrayList;
    }

}
