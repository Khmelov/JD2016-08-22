package by.it.voronovich.JD01_15.Task_C;

import java.io.File;
import static by.it.voronovich.JD01_15.Task_C.Dir.path;

/**
 * Класс содержит метод изменения текущей дирректории
 *
 * @author Voronovich Dmitry
 * @version 1.0
 */
public class Cd {

    /**
     * Метод меняет текущую дирректорию
     *
     * @param order
     */
    public static void changeDir(String order) {
        String path1 = Util.readDir(order);
        if (new File(path1).isDirectory()) {
            path = path1;
        } else if (new File(path + "\\" + path1).isDirectory())
            path = path + "\\" + path1;
        else
            System.out.println("Таковой дирректории не существует...");
    }
}
