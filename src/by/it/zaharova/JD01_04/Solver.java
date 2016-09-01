package by.it.zaharova.JD01_04;


public class Solver {
    /**
     * @param a матрица коэффициентов
     * @param y вектор правой части
     * @return корни системы лин ур-ний (СЛАУ)
     */
    public static double[] findRoot(double[][] a, double[] y, boolean debug) {
//        double[][] m = {
//                {2, 5, 4, 1, 20},
//                {1, 3, 2, 1, 11},
//                {2, 10, 9, 7, 40},
//                {3, 8, 9, 2, 37}
//        };

        double[][] m = new double[a.length][a.length + 1];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                m[i][j] = a[i][j];
            }
            m[i][a.length] = y[i];
        }
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

        //Прямой ход метода


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

        double[] x = new double[m.length];
        for (int i = 0; i < n; i++) {
            x[i] = m[i][n];


        }
        return x;
    }

    //Нахождение определителя
    public static void findDeter() {
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
        double res= 1;
        for (int k = 0; k < n; k++) {
            for (int l = 0; l < n; l++) {
                if (k == l) {

                        res = m[k][l] *res;




                }

            }
        }
        System.out.println(res);
    }
}