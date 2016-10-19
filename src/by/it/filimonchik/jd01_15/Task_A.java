package by.it.filimonchik.jd01_15;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Raman.Filimonchyk on 18/10/2016.
 */
public class Task_A {
    public static void A() throws Exception {
        int mtrx[][] = new int[4][4];
        for (int i = 0; i < mtrx.length; i++) {
            for (int j = 0; j < mtrx[i].length; j++) {
                mtrx[i][j] = (int) (Math.random() * 31 - 15);
            }
        }
        String src = System.getProperty( "user.dir" ) + "/src/by/it/filimonchik/";
        String fileout = src + "jd01_15/Task_A.txt";
        try (PrintWriter printer = new PrintWriter( new FileWriter(fileout) )) {
            printer.println("Task A. Создание матрицы 4 на 4. Вывод матрицы в консоль и текстовый файл: ");
            System.out.println("Task A. Создание матрицы 4 на 4. Вывод матрицы в консоль и текстовый файл: ");
            for (int i = 0; i < mtrx.length; i++) {
                for (int j = 0; j < mtrx[i].length; j++) {
                    printer.printf( "%4s", mtrx[i][j] );

                    System.out.printf( "%4s", mtrx[i][j]);
                }
                System.out.println();
                printer.println();

            }
            System.out.println();
        }
    }
}
