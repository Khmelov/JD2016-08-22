package by.it.grechishnikov.jd01_04;


/**
 * Created by Evgeniy on 29.08.16.
 */
public class Util {
    public static double[] findRoot(double[][] matrix, double[] vector) {
        //Решение СЛАУ методом Жордана-Гаусса с произвольным размером СЛАУ
        //Создаем доп матрицу и заполняем ее
        int size = matrix.length;
        double[][] m = new double[size][size + 1];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                m[i][j] = matrix[i][j];
            }
        }
        for (int i = 0; i < size; i++) {
            m[i][size] = vector[i];
        }

        //Прямой ход по Гауссу
        double k;
        for (int diag = 0; diag < size - 1; diag++) {
            for (int row = diag + 1; row < size; row++) {
                k = m[row][diag] / m[diag][diag];
                for (int col = 0; col < size + 1; col++) {
                    m[row][col] = m[row][col] - m[diag][col] * k;
                }
            }
        }

        //Обратный ход по Гауссу

        for (int diag = size-1; diag > 0; diag--) {
            for (int row = 0; row < diag; row++) {
                k = m[row][diag] / m[diag][diag];
                for (int col = 0; col < size + 1; col++) {
                    m[row][col] = m[row][col] - m[diag][col] * k;
                }
            }
        }

        //Приводим главную диагональ к 1
        for (int i = 0; i < size; i++) {
            k = 1/m[i][i];
            for (int j = 0; j < size + 1; j++) {
                m[i][j] = m[i][j] * k;
            }
        }

        //Заполняем result
        double[] result = new double[size];
        for (int i = 0; i < size; i++) {
            result[i] = m[i][size];
        }

        return result;
    }

    public static double findDeterminate(double[][] matrix) {
        System.out.println("Находим определитель матрицы:");

        //Создаем доп матрицу и заполняем ее
        int size = matrix.length;
        double[][] m = new double[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                m[i][j] = matrix[i][j];
            }
        }
        //Прямой ход по Гауссу
        double k;
        for (int diag = 0; diag < size; diag++) {
            for (int row = diag + 1; row < size; row++) {
                k = m[row][diag] / m[diag][diag];
                for (int col = 0; col < size; col++) {
                    m[row][col] = m[row][col] - m[diag][col] * k;
                }
            }
        }
        //Поиск определителя матрицы
        double[] arr = new double[size];
        for (int i = 0; i < size; i++) {
            arr[i] = m[i][i];
        }

        double result = 1;
        for(double d : arr) {
            result *= d;
        }

        return result;
    }
}
