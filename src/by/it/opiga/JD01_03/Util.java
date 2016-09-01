package by.it.opiga.JD01_03;

/**
 * Created by Asus on 29.08.2016.
 *
 * @author Olga Piga
 * @version 1.0
 */

public class Util {
    /**
     * сортировка пузырьком
     *
     * @param mas
     * @return double[]
     */
    static double[] sortFromMinToMax(double[] mas) {
        double temp;
        int last = mas.length - 1;
        boolean swap;
        do {
            swap = false;
            for (int i = 0; i < last; i++) {
                if (mas[i] > mas[i + 1]) {
                    temp = mas[i];
                    mas[i] = mas[i + 1];
                    mas[i + 1] = temp;
                    swap = true;
                }
            }
            last--;
        } while (swap);
        return mas;
    }

    static double[] sortFromMaxToMin(double[] mas) {
        double temp;
        int last = mas.length - 1;
        boolean swap;
        do {
            swap = false;
            for (int i = 0; i < last; i++) {
                if (mas[i] < mas[i + 1]) {
                    temp = mas[i];
                    mas[i] = mas[i + 1];
                    mas[i + 1] = temp;
                    swap = true;
                }
            }
            last--;
        } while (swap);
        return mas;
    }

    /**
     * найти максимум
     *
     * @param mas
     * @return double
     */
    static double getMax(double[] mas) {
        double max = mas[0];
        for (int i = 0; i < mas.length; i++) {
            if (mas[i] > max)
                max = mas[i];
        }
        return max;
    }

    //найти минимум
    static double getMin(double[] mas) {
        double min = mas[0];
        for (int i = 0; i < mas.length; i++) {
            if (mas[i] < min)
                min = mas[i];
        }
        return min;
    }

    /**
     * массив*вектор
     *
     * @param mas
     * @param vec
     * @return double[]
     */
    static double[] arrayMultVector(double[][] mas, double[] vec) {
        double[] multMas = new double[mas.length];

        for (int i = 0; i < mas.length; i++) {
            for (int j = 0; j < mas[0].length; j++) {
                multMas[i] = multMas[i] + mas[i][j] * vec[j];
            }
        }
        return multMas;
    }

    /**
     * массив*массив
     *
     * @param mas,mas2
     * @return double[][]
     */
    static double[][] arrayMultArray(double[][] mas, double[][] mas2) {
        double[][] multMas = new double[mas.length][mas2[0].length];
        for (int i = 0; i < mas.length; i++) {
            for (int j = 0; j < mas2.length; j++) {
                for (int k = 0; k < mas2.length; k++) {
                    multMas[i][j] = multMas[i][j] + mas[i][k] * mas2[k][j];
                }
            }
        }
        return multMas;

    }

    // метод для решения слау методом Жордана-Гаусса

    public static double[] findRoot(double m[][], double[] y) {

        double[][] mA = new double[m.length][m.length + 1];
        for (int i = 0; i < mA.length; i++) {
            for (int j = 0; j < mA.length; j++) {
                mA[i][j] = m[i][j];
            }
            mA[i][mA.length] = y[i];
        }
        double k = 1;
        int n = mA.length;
        //прямой ход
        for (int diag = 0; diag < mA.length - 1; diag++) {
            for (int row = diag + 1; row < mA.length; row++) {
                k = mA[row][diag] / mA[diag][diag];
                for (int col = 0; col < mA[0].length; col++)
                    mA[row][col] = mA[row][col] - mA[diag][col] * k;
            }
        }
        //InOut.PrintArray(mA);
        //обратный ход
        for (int diag = n - 1; diag > 0; diag--) {
            for (int row = 0; row < diag; row++) {
                k = mA[row][diag] / mA[diag][diag];
                for (int col = 0; col < n + 1; col++) {
                    mA[row][col] = mA[row][col] - mA[diag][col] * k;
                }
            }
        }
       // InOut.PrintArray(mA);
        //привести главную диагональ к 1
        for (int i = 0; i < mA.length; i++) {
            k = 1 / mA[i][i];
            for (int j = 0; j <= mA.length; j++) {
                mA[i][j] = mA[i][j] * k;
            }
        }
        InOut.PrintArray(mA);
        //вернуть результат Х
        double[] x = new double[mA.length];
        for (int i = 0; i < n; i++) {
            x[i] = mA[i][n];
        }
        return x;
    }

    //определитель матрицы
    public static double findDeterminant(double mA[][]) {
        double k;
        double det = 1;
        //прямой ход
        for (int diag = 0; diag < mA.length - 1; diag++) {
            for (int row = diag + 1; row < mA.length; row++) {
                k = mA[row][diag] / mA[diag][diag];
                for (int col = 0; col < mA[0].length; col++)
                    mA[row][col] = mA[row][col] - mA[diag][col] * k;
            }
        }
        //InOut.PrintArray(mA);
        //определитель матрицы
        for (int i = 0; i < mA.length; i++) {
            for (int j = 0; j < mA[0].length; j++) {
                if (i == j)
                    det = det * mA[i][j];
            }
        }
        return det;
    }


    //обратная матрица
    public static double[][] inverseMatrix(double[][] m) {

        double [][] mE=new double[m.length][m.length];
        for (int i = 0; i <mE.length ; i++) {
            for (int j = 0; j < mE.length; j++) {
                if(i==j)
                    mE[i][j]=1;
                else
                    mE[i][j]=0;
            }

        }
        int g=0;
        double[][] mA = new double[m.length][m.length*2];
        for (int i = 0; i < mA.length; i++) {
            for (int j = 0; j < mA[0].length; j++) {
                if(j<mA.length)
                     mA[i][j] = m[i][j];
                else
                    {mA[i][j]=mE[i][g];g++;}
            }g=0;
        }
        double k = 1;
        int n = mA.length;
        //прямой ход
        for (int diag = 0; diag < mA.length - 1; diag++) {
            for (int row = diag + 1; row < mA.length; row++) {
                k = mA[row][diag] / mA[diag][diag];
                for (int col = 0; col < mA[0].length; col++)
                    mA[row][col] = mA[row][col] - mA[diag][col] * k;
            }
        }
        //InOut.PrintArray(mA);

        //обратный ход
        for (int diag = n - 1; diag > 0; diag--) {
            for (int row = 0; row < diag; row++) {
                k = mA[row][diag] / mA[diag][diag];
                for (int col = 0; col < mA[0].length; col++) {
                    mA[row][col] = mA[row][col] - mA[diag][col] * k;
                }
            }
        }
        //InOut.PrintArray(mA);

        //привести главную диагональ к 1
        for (int i = 0; i < mA.length; i++) {
            k = 1 / mA[i][i];
            for (int j = 0; j < mA[0].length; j++) {
                mA[i][j] = mA[i][j] * k;
            }
        }

        g=0;
        double inversMat[][]=new double[m.length][m.length];
        for (int i = 0; i <mA.length ; i++) {
            for (int j = 0; j <mA[0].length ; j++) {
               if(j>=mA.length)
               {inversMat[i][g]=mA[i][j];g++;}
            }g=0;
        }//InOut.PrintArray(inversMat);
        return inversMat;
    }

}






