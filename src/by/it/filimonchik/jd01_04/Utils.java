package by.it.filimonchik.jd01_04;

/**
 * Created by Raman.Filimonchyk on 12.09.2016.
 */

public class Utils {
    public static double[] findRoots(double MATR[][], double VECT[]) {
        double m[][] = new double[MATR.length][MATR[0].length + 1];
        for (int i = 0; i < MATR.length; i++) {
            for (int j = 0; j < MATR[i].length; j++) {
                m[i][j] = MATR[i][j];
            }
        }
        for (int i = 0; i < MATR.length; i++) {
            m[i][MATR[0].length] = VECT[i];
        }
        double k = 0;
        for (int diag = 0; diag < MATR.length - 1; diag++) {
            for (int i = diag + 1; i < MATR.length; i++) {

                k = m[i][diag] / m[diag][diag];
                for (int j = 0; j < MATR.length + 1; j++) {
                    m[i][j] = m[i][j] - m[diag][j] * k;
                }
            }
        }
        for (int diag = MATR.length - 1; diag > 0; diag--) {
            for (int i = 0; i < diag; i++) {

                k = m[i][diag] / m[diag][diag];
                for (int j = 0; j < MATR.length + 1; j++) {
                    m[i][j] = m[i][j] - m[diag][j] * k;
                }
            }
        }
        for (int i = 0; i < MATR.length; i++) {
            k = 1 / m[i][i];
            for (int j = 0; j < MATR.length + 1; j++) {
                m[i][j] = m[i][j] * k;
            }
        }
        double x[] = new double[MATR.length];
        for (int i = 0; i < MATR.length; i++) {
            x[i] = m[i][MATR.length];
        }
        return x;
    }

    public static double[] arrayMul(double[][] MATR, double[] VECT) {
        double[] z = new double[MATR.length];
        for (int i = 0; i < MATR.length; i++) {
            for (int j = 0; j < VECT.length; j++) {
                z[i] = z[i] + MATR[i][j] * VECT[j];
            }
        }
        return z;
    }

    public static double findDeterminant(double[][] MATR) {
        int n = MATR.length;
        double[][] m = new double[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                m[i][j] = MATR[i][j];
            }
        }
        double k;
        for (int diag = 0; diag < n; diag++) {
            for (int i = diag + 1; i < n; i++) {
                k = m[i][diag] / m[diag][diag];

                for (int j = 0; j < n; j++) {
                    m[i][j] = m[i][j] - m[diag][j] * k;
                }
            }
        }
        double[] h = new double[n];
        for (int i = 0; i < n; i++) {
            h[i] = m[i][i];
        }
        double result = 1;
        for (double d : h) {
            result *= d;
        }
        return result;
    }
}