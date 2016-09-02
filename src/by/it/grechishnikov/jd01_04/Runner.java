package by.it.grechishnikov.jd01_04;

import  static by.it.grechishnikov.jd01_03.Util.*;
import  by.it.grechishnikov.jd01_03.InOut;

import java.util.Arrays;

/**
 * Created by Evgeniy on 29.08.16.
 */
public class Runner {
    public static void main(String[] args) {
        double[][] matrix = {
                {2, 5, 4, 1},
                {1, 3, 2, 1},
                {2, 10, 9, 7},
                {3, 8, 9, 2}
        };
        double[] vector = {20, 11, 40, 37};

        System.out.println("Решение СЛАУ:");
        double[] result = Util.findRoot(matrix, vector);
        System.out.println(Arrays.toString(result));

        InOut.printMatrix(multiply(matrix, result), "Проверка метода findRoot() умножением матрицы на результат", 5);

        System.out.println(Util.findDeterminate(matrix));
    }
}