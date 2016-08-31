package by.it.voronovich.JD01_04;

/**
 * Класс служит для сортировки одномерного массива по возрастанию и убыванию,
 * для нахождения минимального и максимального элемента одномерного массива,
 * для перемножения двумерного массива на двумерный массив или на вектор.
 *
 * @author Dmitry Voronovich
 * @version 1.0
 */

public class Util {

    /**
     * @param a входной одномерный массив
     * @return возвращает отсортированный одномерный массив по возрастанию
     */
    protected static double[] sortUp(double a[]) {

        for (int i = a.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (a[j] > a[j + 1]) {
                    double x = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = x;
                }
            }
        }
        return a;
    }

    /**
     * @param vec входной одномерный массив
     * @return возвращает отсортированный одномерный массив по убыванию
     */
    protected static double[] sortDown(double vec[]) {

        for (int i = vec.length - 1; i > 0; i--) {
            for (int j = vec.length - 1; j > 0; j--) {
                if (vec[j] > vec[j - 1]) {
                    double x = vec[j - 1];
                    vec[j - 1] = vec[j];
                    vec[j] = x;
                }
            }
        }
        return vec;
    }

    /**
     * @param a входной массив
     * @return возвращает минимальное значение одномерного массива
     */
    protected static String minValueArray(double a[]) {
        double x = Double.MAX_VALUE;
        for (int i = 0; i < a.length; i++) {
            if (a[i] < x) {
                x = a[i];
            }
        }
        return "Наименьшее значение в одномерном массиве: " + x;
    }

    /**
     * @param vec входной массив
     * @return возвращает максимальное значение одномерного массива
     */
    protected static String maxValueArray(double vec[]) {
        double x = Double.MIN_VALUE;
        for (int i = 0; i < vec.length; i++) {
            if (vec[i] > x) {
                x = vec[i];
            }
        }
        return "Наибольшее значение в одномерном массиве: " + x;
    }

    /**
     * @param a1 входной двумерный массив
     * @param a2 входной двумерный массив
     * @return возвращает результат произведения матрицы на матрицу в виде матрицы
     */
    protected static double[][] multiplyTwoMatrix(double a1[][], double a2[][]) {
        double resultMatrix[][] = new double[a1.length][a2[0].length];
        for (int i = 0; i < a1.length; i++) {
            for (int k = 0; k < a2[0].length; k++) {
                for (int j = 0; j < a2.length; j++) {
                    resultMatrix[i][k] += a1[i][j] * a2[j][k];
                }
            }
        }
        return resultMatrix;
    }

    /**
     * @param a входной двумерный массив
     * @param vec входной одномерный массив
     * @return возвращает результат произведения матрицы на вектор в виде вектора
     */
    protected static double[] multiplyVecMatrix(double a[][], double vec[]) {
        double resultVec[] = new double[a.length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < vec.length; j++) {
                resultVec[i] += a[i][j] * vec[j];
            }
        }
        return resultVec;
    }

    /**
     * @param a входной двумерный массив
     * @param vec входной одномерный массив
     * @return возвращает корни СЛАУ в виде вектора
     */
    protected static double[] findRoots(double a[][], double vec[]) {

        double m[][] = new double[a.length][a[0].length + 1];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                m[i][j] = a[i][j];
            }
        }
        for (int i = 0; i < a.length; i++) {
            m[i][a[0].length] = vec[i];
        }

        //прямой ход
        double k = 0;
        for (int diag = 0; diag < a.length - 1; diag++) {
            for (int i = diag + 1; i < a.length; i++) {
                k = m[i][diag] / m[diag][diag];
                for (int j = 0; j < a.length + 1; j++) {
                    m[i][j] = m[i][j] - m[diag][j] * k;
                }
            }
        }

        //обратный ход
        for (int diag = a.length - 1; diag > 0; diag--) {
            for (int i = 0; i < diag; i++) {
                k = m[i][diag] / m[diag][diag];
                for (int j = 0; j < a.length + 1; j++) {
                    m[i][j] = m[i][j] - m[diag][j] * k;
                }
            }
        }

        //приводим главную диагональ к 1
        for (int i = 0; i < a.length; i++) {
            k = 1 / m[i][i];
            for (int j = 0; j < a.length + 1; j++) {
                m[i][j] = m[i][j] * k;
            }
        }

        //возвращаем корни СЛАУ
        double x[] = new double[a.length];
        for (int i = 0; i < a.length; i++) {
            x[i] = m[i][a.length];
        }
        return x;
    }

    /**
     * Метод предназначен для вычисления определителя матрицы
     *
     * @param a входной двумерный массив
     * @return возвращает в метод значение определителя
     */
    protected static double findDeterminant(double a[][]) {

        double m[][]=new double[a.length][a[0].length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                m[i][j]=a[i][j];
            }
        }
        //прямой ход
        double k = 0;
        for (int diag = 0; diag < m.length; diag++) {
            for (int i = diag + 1; i < m.length; i++) {
                k = m[i][diag] / m[diag][diag];
                for (int j = 0; j < m.length; j++) {
                    m[i][j] = m[i][j] - m[diag][j] * k;
                }
            }
        }
        double determinant = 1;
        for (int i = 0; i < m.length; i++) {
            determinant *= m[i][i];
        }
        return determinant;
    }

    /**
     * Метод предназначен для вычисления обратной матрицы
     *
     * @param a входной двумерный массив
     * @return возвращает в метод обратную матрицу
     */
    protected static double[][] inverseMatrix(double a[][]) {

        double m[][] = new double[a.length][a.length * 2];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                m[i][j] = a[i][j];
            }
        }
        for (int i = 0; i < a.length; i++) {
            for (int j = a.length; j < a.length * 2; j++) {
                if (j == a.length + i) {
                    m[i][j] = 1;
                } else {
                    m[i][j] = 0;
                }
            }
        }

        //прямой ход
        double k = 0;
        for (int diag = 0; diag < a.length; diag++) {
            for (int i = diag + 1; i < a.length; i++) {
                k = m[i][diag] / m[diag][diag];
                for (int j = 0; j < a.length * 2; j++) {
                    m[i][j] = m[i][j] - m[diag][j] * k;
                }
            }
        }

        //обратный ход
        for (int diag = a.length - 1; diag > 0; diag--) {
            for (int i = 0; i < diag; i++) {
                k = m[i][diag] / m[diag][diag];
                for (int j = 0; j < a.length * 2; j++) {
                    m[i][j] = m[i][j] - m[diag][j] * k;
                }
            }
        }

        for (int i = 0; i < a.length; i++) {
            k = 1 / m[i][i];
            for (int j = 0; j < a.length*2; j++) {
                m[i][j] = m[i][j] * k;
            }
        }

        double invMatrix[][]=new double[a.length][a.length];
        for (int i = 0; i <a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                invMatrix[i][j]=m[i][j+a.length];
            }
        }
        return invMatrix;
    }
}
