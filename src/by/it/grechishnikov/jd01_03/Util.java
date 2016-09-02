package by.it.grechishnikov.jd01_03;

import java.util.Arrays;
import java.util.Collections;

/**
 * @author Grechishnikov
 * @version 1.0
 */

public class Util {
    /**
     * Сортировка массива-вектора. Выводит время сортировки на экран.
     * @param arr - вектор.
     * @param up - сортировка по ворзастанию - true, по убыванию - false.
     * @return - возвращает уже отсортированный массив.
     */
    public static void sort(double[] arr, boolean up) {
        System.out.print("Сортируем массив " + (up ? "по возрастанию. " : "по убыванию. "));
        long l = System.currentTimeMillis();
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if((up && arr[i] > arr[j])
                        || (!up && arr[i] < arr[j])) {
                    double tmp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = tmp;
                }
            }
        }
        System.out.println("Время выполнения сортировки = " + (System.currentTimeMillis() - l) + " милисек.");
    }

    public static void standartSort(Double[] arr, boolean up) {
        //стандартная сортировка массива
        System.out.print("Сортируем массив " + (up ? "по возрастанию. " : "по убыванию. "));
        if(up) {
            Arrays.sort(arr);
        }
        else {
            Arrays.sort(arr,Collections.<Double>reverseOrder());
        }
    }

    /**
     * Поиск минимума в массиве.
     * @param arr - массив для перебора элементтов
     * @return - возвращает минимальный элемент.
     */
    public static double findMin(double[] arr) {
        double min = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if(min > arr[i]) {
                min = arr[i];
            }
        }
        return min;
    }

    /**
     * Поиск максимума в массиве.
     * @param arr - массив для перебора элементов.
     * @return - возвращает максимальный элемент.
     */
    public static double findMax(double[] arr) {
        double max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if(max < arr[i]) {
                max = arr[i];
            }
        }
        return max;
    }

    /**
     * Умножение матрицы на вектор.
     * @param matrix - матрица.
     * @param vector - вектор.
     * @return - возвращает результат в виде массива.
     */
    public static double[] multiply(double[][] matrix, double[] vector) {
        //Умножение матрицы на вектор
        double[] result = new double[vector.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < vector.length; j++) {
                result[i] += matrix[i][j] * vector[j];
            }
        }
        return result;
    }

    /**
     * Перегруженная версия умножения матрицы. Тут происходит умножени матрицы на другую матрицу.
     * @param first - первая матрица.
     * @param second - вторая матрица.
     * @return - рузультат умножения матриц в виде массива.
     */
    public static double[][] multiply(double[][] first, double[][] second) {
        //Умножение матрицы на матрицу
        double[][] result = new double[first.length][second[0].length];
        for (int i = 0; i < first.length; i++) {
            for (int j = 0; j < second[0].length; j++) {
                for (int k = 0; k < second.length; k++) {
                    result[i][j] += first[i][k] * second[k][j];
                }
            }
        }
        return result;
    }
}
