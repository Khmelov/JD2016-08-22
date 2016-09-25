package by.it.aborisenok.JD01_15;

import java.io.*;

/**
 * Created by Лёша on 25.09.2016.
 */
public class TaskB {
    public static void run(){
        String isrc = System.getProperty("user.dir") + "\\src\\by\\it\\aborisenok\\";
        String is = isrc + "JD01_15\\TaskB.java";// исходный java файл
        String osrc = System.getProperty("user.dir") + "\\src\\by\\it\\aborisenok\\";
        String os = osrc + "JD01_15\\TaskB.txt//"; // файл// куда пишется текст программы
        javaFileRider(is, os);
    }
    /**
     * Метод служит для чтения текста из java файла
     *
     * @param is путь файла для чтения
     * @param os путь файла для записи
     */
    public static void javaFileRider(String is, String os){
        StringBuilder text = new StringBuilder();
        try(BufferedReader reader = new BufferedReader(new FileReader(is));
                BufferedWriter writer = new BufferedWriter(new FileWriter(os))) {
            while (reader.ready()){
                text.append(reader.readLine() + "\n");
            }
        } catch (IOException e){
            System.out.println("File error");
        }
        System.out.println(text);
    }
    /**
     * Метод служит удаления комментариев из текста
     *
     * @param string исходный текст
     */
//    public static String comentsDeliter(StringBuilder string){
//        // удаление однострочных коментариев
//        return text
//    }
}
