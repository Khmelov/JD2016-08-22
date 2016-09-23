package by.it.voronovich.JD01_14;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Класс содержит тела методов решения 3-ого задания
 *
 * @author Voronovich Dmitry
 * @version 1.0
 */

public class Task_C {

    /**
     * Метод выводит структуру файлов и дирректорий на диске, объединяя их в соответстующие списки
     *
     * @param path
     */
    public static void getDirection(String path) {

        File way = new File(path);
        File[] arr = way.listFiles();
        ArrayList<File> list = new ArrayList<File>(Arrays.asList(arr));
        ArrayList<String> listFile = new ArrayList<>();
        ArrayList<String> listDir = new ArrayList<>();

        while (list.size() > 0) {
            File res = list.get(0);
            if (res.isFile()) {
                listFile.add(res.getName());
                list.remove(0);
            } else {
                Collections.addAll(list, res.listFiles());
                listDir.add(res.getName());
                list.remove(0);
            }
        }
        System.out.println("List dir:");
        for (String e : listDir) {
            System.out.println(e);
        }
        System.out.println("List file:");
        for (String e : listFile) {
            System.out.println(e);
        }
    }
}
