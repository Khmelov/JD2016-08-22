package by.it.voronovich.JD01_15;

import java.io.*;

/**
 * Кдасс содержит решение первой задачи
 *
 * @author Voronovich Dmitry
 * @version 1.0
 */
public class Task_A1 {

    public static void task_A1() {
        int array[][] = new int[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                array[i][j] = -15+(int) (Math.random() *(15-(-15))+1);
            }
        }
    //----------------------------------------------------------------------------------
        String filename = System.getProperty("user.dir") + "/src/by/it/voronovich/" + "jd01_15/matrix_list.txt";

        File text = new File(filename);

        try (PrintWriter pw = new PrintWriter(new FileWriter(text))) {

            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    pw.printf("%3s ", array[i][j]);
                    System.out.printf("%3s ", array[i][j]);
                }
                pw.printf("\n");
                System.out.println(" ");
            }
        } catch (IOException e) {
            System.err.println("Ошибка файла: ");
        }
    }
}
