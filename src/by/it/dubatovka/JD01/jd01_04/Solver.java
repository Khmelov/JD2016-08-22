package by.it.dubatovka.JD01.jd01_04;

public class Solver {
    /**
     * @param a матрица коэффициентов СЛАУ
     * @param y вектор правой части
     * @return корни системы линейных уравнений СЛАУ
     */


    public static double[] findRoot(double[][] a, double[] y, boolean debug) {
//        double[][] m = {
//                {2, 5, 4, 1, 20},
//                {1, 3, 2, 1, 11},
//                {2, 10, 9, 7, 40},
//                {3, 8, 9, 2, 37},
//        };
        double[][] m = new double[a.length][a.length + 1];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                m[i][j] = a[i][j];
            }
            m[i][a.length] = y[i];

        }
        //прямой ход метода
        int n = m.length; //количество строк
        for (int diag = 0; diag < 3; diag++) {

            for (int i = diag + 1; i < n; i++) {
                double k = m[i][diag] / m[diag][diag];
                for (int j = 0; j < m[0].length; j++) {
                    m[i][j] = m[i][j] - m[diag][j] * k;
                }
            }
            if (debug) Util.showArray(m);
        }
        //обратный ход метода

        for (int diag = n - 1; diag > 0; diag--) {

            for (int i = 0; i < diag; i++) {
                double k = m[i][diag] / m[diag][diag];
                for (int j = 0; j < m[0].length; j++) {
                    m[i][j] = m[i][j] - m[diag][j] * k;
                }

            }
            if (debug) Util.showArray(m);

        }
        for (int i = 0; i < n; i++) {
            double k = 1 / m[i][i];
            for (int j = 0; j < m[0].length; j++) {
                m[i][j] = m[i][j] * k;
            }
            if (debug) Util.showArray(m);
        }
        //возврат результата
        double[] x = new double[m.length];
        for (int i = 0; i < n; i++) {
            x[i] = m[i][n];
        }
        return x;
    }
}
