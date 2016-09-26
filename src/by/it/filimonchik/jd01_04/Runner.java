package by.it.filimonchik.jd01_04;

import java.util.Arrays;

/**
 * Created by Raman.Filimonchyk on 12.09.2016.
 */
public class Runner {
    public static void main(String[] args) {
        double[][] MATR = {
                {2, 5, 4, 1},
                {1, 3, 2, 1},
                {2, 10, 9, 7},
                {3, 8, 9, 2}
        };
        double[] VECT = {20, 11, 40, 37};

        double[] x = Utils.findRoots(MATR, VECT);
        System.out.println("Решение СЛАУ: "+ Arrays.toString(x));
        double[] l = Utils.arrayMul(MATR, x);
        System.out.println("Проверка решения: "+Arrays.toString(l));
        double k =Utils.findDeterminant(MATR);
        System.out.println("Определитель: "+ k);
    }
}