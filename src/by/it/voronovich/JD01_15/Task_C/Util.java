package by.it.voronovich.JD01_15.Task_C;

import java.io.*;
import java.util.regex.*;

/**
 * Класс осуществляет ввод данных с клавиатуры и их дальнейшую обработку для передачи в методы
 *
 * @author Voronovich Dmitry
 * @version 1.0
 */
public class Util {

    public static String reader() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        return reader.readLine();
    }

    public static String readerC(String order){
        Matcher matcher = Pattern.compile("[\\w]+").matcher(order);
        String str = "";
        if (matcher.find())
            str = matcher.group();
        return str;
    }

    public static String readDir(String order){
        Matcher matcher = Pattern.compile("[\\w]+").matcher(order);
        StringBuilder sb = new StringBuilder(order);
        if (matcher.find())
            sb.delete(0, matcher.end());
        return sb.toString().trim();
    }
}