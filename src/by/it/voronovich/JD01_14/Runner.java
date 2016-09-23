package by.it.voronovich.JD01_14;

import java.io.IOException;

/**
 * Класс запускает все приложения тренеровочных заданий
 *
 * @author Voronovich Dmitry
 * @version 1.0
 */

public class Runner {

    public static void main(String[] args) throws IOException{

        System.out.println("Задание A: ");
        String src = System.getProperty("user.dir") + "/src/by/it/voronovich/";
        String filename = src + "jd01_14/integer_list.dat";
        Task_A.task_A_writing(filename);
        //------------------------------
        Task_A.task_A_reading(filename);
        //------------------------------
        System.out.println("Задание B: ");
        String src1 = System.getProperty("user.dir") + "/src/by/it/voronovich/";
        String filename1 = src1 + "jd01_14/text.txt";
        Task_B.task_B_count(filename1);
        //------------------------------
        System.out.println("Задание C: ");
        String src2 = System.getProperty("user.dir");
        Task_C.getDirection(src2);

    }
}
