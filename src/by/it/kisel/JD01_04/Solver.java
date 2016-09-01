package by.it.kisel.JD01_04;


public class Solver {

    /**
     * @param
     * @param
     * @return корни системы линейных уравнений (СЛАУ)
     */

    public static double[] findRoot() {
        double[][] m = {
                {2, 5, 4, 1, 20},
                {1, 3, 2, 1, 11},
                {2, 10, 9, 7, 40},
                {3, 8, 9, 2, 37}
        };
        Util.showArray(m);
//        double[][] m = new double[a.length][a.length + 1];
//        for (int i = 0; i < a.length; i++) {
//            for (int j = 0; j < a.length; j++) {
//                m[i][j] = a[i][j];
//            }
//            m[i][a.length] = y[i];
//
//        }
//        if (debug) Util.showArray(m);


        //Прямой ход метода
        int n = m.length;
        for (int diag = 0; diag < 3; diag++) {
            for (int i = diag + 1; i < n; i++) {
                double k = m[i][diag] / m[diag][diag];
                for (int j = 0; j < m[0].length; j++) {
                    m[i][j] = m[i][j] - m[diag][j] * k;
                }
            }
            Util.showArray(m);
        }

        //Обратный ход метода
        for (int diag = n - 1; diag > 0; diag--) {
            for (int i = 0; i < diag; i++) {
                double k = m[i][diag] / m[diag][diag];
                for (int j = 0; j < m[0].length; j++) {
                    m[i][j] = m[i][j] - m[diag][j] * k;
                }
            }
            Util.showArray(m);
        }

        for (int i = 0; i < n; i++) {
            double k = 1 / m[i][i];
            for (int j = 0; j < m[0].length; j++) {
                m[i][j] = m[i][j] * k;
            }
            Util.showArray(m);
        }

        //возврат результата (корни СЛАУ)
        double[] x = new double[m.length];
        for (int i = 0; i < n; i++) {
            x[i] = m[i][n];
        }
        return x;
    }

    public static void findDeterminant() {
        double[][] m = {
                {2, 5, 4, 1, 20},
                {1, 3, 2, 1, 11},
                {2, 10, 9, 7, 40},
                {3, 8, 9, 2, 37}
        };
        Util.showArray(m);

        int n = m.length;
        for (int diag = 0; diag < 3; diag++) {
            for (int i = diag + 1; i < n; i++) {
                double k = m[i][diag] / m[diag][diag];
                for (int j = 0; j < m[0].length; j++) {
                    m[i][j] = m[i][j] - m[diag][j] * k;
                }
            }
            Util.showArray(m);
        }

        int res = 1;
        for (int i = 0; i < m.length; i++) {
            res *= m[i][i];

        }

        System.out.println("Определитель = " + res);


    }
}
