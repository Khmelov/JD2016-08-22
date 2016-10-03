package by.it.prymshyts.jd01.jd01_04;

/**
 * Класс решает ряд задач для матриц.
 */

public class Solver {

    /**
     * Решает СЛАУ.
     * @param mA квадратная матрица коэффициентов
     * @param mY вектор правых частей уравнений СЛАУ
     * @return вектор-решение
     */

    protected static double[] findRoot(double[][] mA, double[] mY) {

        int n = mA.length;
        double[][] m = new double[n][n + 1];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                m[i][j] = mA[i][j];
            }
        }

        for (int i = 0; i < n; i++) {
            m[i][n] = mY[i];
        }

        double k;

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                k = m[j][i] / m[i][i];

                for (int l = 0; l < n + 1; l++) {
                    m[j][l] = m[j][l] - m[i][l] * k;
                }
            }
        }

        for (int i = n - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                k = m[j][i] / m[i][i];

                for (int l = 0; l < n + 1; l++) {
                    m[j][l] = m[j][l] - m[i][l] * k;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            k = 1 / m[i][i];

            for (int j = 0; j < n + 1; j++) {
                m[i][j] = m[i][j] * k;
            }
        }

        double[] x = new double[n];

        for (int i = 0; i < n; i++) {
            x[i] = m[i][n];
        }

        return x;
    }

    /**
     * Ищет определитель квадратной матрицы.
     * @param arr квадратная матрица
     * @return определитель переданной матрицы
     */

    protected static double getDeterminant(double[][] arr) {

        int n = arr.length;
        double[][] m = new double[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                m[i][j] = arr[i][j];
            }
        }

        double k;

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                k = m[j][i] / m[i][i];

                for (int l = 0; l < n; l++) {
                    m[j][l] = m[j][l] - m[i][l] * k;
                }
            }
        }

        double determinant = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j)
                    determinant *= m[i][j];
            }
        }

        return determinant;
    }

    /**
     * Ищет обратную матрицу.
     * @param mA квадратная матрица
     * @return обратная матрица от переданной
     */

    protected static double[][] inverseMatrix(double[][] mA) {

        int n = mA.length;
        double[][] mE = new double[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j)
                    mE[i][j] = 1;
            }
        }

        double k;

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                k = mA[j][i] / mA[i][i];

                for (int l = 0; l < n; l++) {
                    mA[j][l] = mA[j][l] - mA[i][l] * k;
                    mE[j][l] = mE[j][l] - mE[i][l] * k;
                }
            }
        }

        for (int i = n - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                k = mA[j][i] / mA[i][i];

                for (int l = 0; l < n; l++) {
                    mA[j][l] = mA[j][l] - mA[i][l] * k;
                    mE[j][l] = mE[j][l] - mE[i][l] * k;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            k = 1 / mA[i][i];

            for (int j = 0; j < n; j++) {
                mA[i][j] = mA[i][j] * k;
                mE[i][j] = mE[i][j] * k;
            }
        }

        return mE;
    }
}
