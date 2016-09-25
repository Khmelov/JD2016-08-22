package by.it.voronovich.JD01_15.Task_C;

import java.io.*;
import java.util.*;
import java.text.SimpleDateFormat;

/**
 * Класс предназначен для отображения информации древа и файлов и дирректорий текущего адреса
 *
 * @author Voronovich Dmitry
 * @version 1.0
 */
public class Dir {

    /**
     * @param path переменная текущего адреса
     */
    protected static String path = System.getProperty("user.dir");

    /**
     * Метод возвращает текущий адрес
     *
     * @return path
     */
    public static String getPath() {
        return path;
    }

    /**
     * Метод в форматированном виде осушествляет вывод информации о файлах и папках указанной дирректории
     *
     */
    public static void dir() {

        File folder = new File(path);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm");

        if (folder.isDirectory()) {
            File[] files = folder.listFiles();
            System.out.println("Содержимое папки " + path);
            int countFls = 0;
            int countFlrs = 0;
            int sum = 0;
            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        System.out.printf("%-16s           %7d %-27s \n",
                                dateFormat.format(new Date(file.lastModified())), file.length(), file.getName());
                        countFls++;
                        sum += file.length();
                    } else {
                        System.out.printf("%-16s    <DIR>          %-27s \n",
                                dateFormat.format(new Date(file.lastModified())), file.getName());
                        countFlrs++;
                    }
                }
            }
            System.out.println(">>>>>>>>>>>>>>>>>>-" + countFls + " Файлов " + sum + " байт" + "-<<<<<<<<<<<<<<<<<<<<<<<<");
            System.out.println(">>>>>>>>>>>>>>>>>>-" + countFlrs + " папок " + "-<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
        }
    }
}