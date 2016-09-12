package by.it.prymshyts.jd01_04;

import java.util.Scanner;

public class Util {

    private static Scanner scanner = new Scanner(System.in);

    protected static String getConsoleLine() {

        return scanner.nextLine();
    }

    protected static double[] sortArray(double[] array, boolean upDirection) {

        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if ((upDirection && array[i] > array[j]) || (!upDirection && array[i] < array[j])) {
                    double buffer = array[i];
                    array[i] = array[j];
                    array[j] = buffer;
                }
            }
        }

        return array;
    }

    protected static double findMax(double[] array) {

        double max = Double.MIN_VALUE;

        for (int i = 0; i < array.length; i++) {
            if (array[i] > max)
                max = array[i];
        }

        return max;
    }

    protected static double findMin(double[] array) {

        double min = Double.MAX_VALUE;

        for (int i = 0; i < array.length; i++) {
            if (array[i] < min)
                min = array[i];
        }

        return min;
    }

    protected static double[] matrixMulVector(double[][] x, double[] y) {

        double[] z = new double[x.length];

        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < y.length; j++) {
                z[i] = z[i] + x[i][j] * y[j];
            }
        }

        return z;
    }

    protected static double[][] matrixMulMatrix(double[][] x, double[][] y) {

        double[][] z = new double[x.length][y[0].length];

        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < y[0].length; j++) {
                for (int k = 0; k < y.length; k++) {
                    z[i][j] = z[i][j] + x[i][k] * y[k][j];
                }
            }
        }

        return z;
    }
}
