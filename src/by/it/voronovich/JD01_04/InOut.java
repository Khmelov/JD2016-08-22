package by.it.voronovich.JD01_04;

/**
 * Класс служит для ввода-вывода одномерного массива,
 * для ввода-вывода двумерного массива.
 *
 * @author Dmitry Voronovich
 * @version 1.0
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InOut {

    /**
     * @return возвращает в метод одномерный массив
     */
    protected static double[] getMassive() throws IOException {
        BufferedReader l = new BufferedReader(new InputStreamReader(System.in));
        String line = l.readLine();
        l.close();
        line = line.trim();
        String arrayStr[] = line.split(" ");
        double array[] = new double[arrayStr.length];
        for (int i = 0; i < arrayStr.length; i++) {
            array[i] = Double.parseDouble(arrayStr[i]);
        }
        return array;
    }

    /**
     * Метод служит для вывода на консоль одномерного массива
     *
     * @param array входной одномерный массив
     */
    protected static void massivePrint(double array[]) {
        for (double i : array) {
            System.out.printf("%4.2f ", i);
        }
    }

    /**
     * @return возвращает в метод двумерный массив
     */
    protected static double[][] getMatrix() throws IOException {
        System.out.println("Введите количество строк матрицы a : ");
        BufferedReader z1 = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(z1.readLine());

        System.out.println("Введите количество столбцов матрицы b : ");
        BufferedReader z2 = new BufferedReader(new InputStreamReader(System.in));
        int b = Integer.parseInt(z2.readLine());

        double matrix[][] = new double[a][b];
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                System.out.println("Введите элемент matrix[" + i + "][" + j + "]");
                BufferedReader z3 = new BufferedReader(new InputStreamReader(System.in));
                matrix[i][j] = Double.parseDouble(z3.readLine());
            }
        }
        return matrix;
    }

    /**
     * Метод служит для вывода на консоль двумерного массива
     *
     * @param matrix входной двумерный массив
     */
    protected static void matrixPrint(double matrix[][]) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.printf("%7.2f ", matrix[i][j]);
            }
            System.out.println(" ");
        }
    }
}
