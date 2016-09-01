package by.it.kisel.JD01_04;


public class Util {
    public static double[][] arrayMulArray(double[][] x, double[][] y) {
        double z[][] = new double[x.length][y[0].length];
        for (int i = 0; i < z.length; i++) {             //номер строки буд массива
            for (int j = 0; j < z[0].length; j++) {        // номер столбца буд массива
                for (int k = 0; k < x.length; k++) {       // или y.length - они равны
                    z[i][j] = z[i][j] + x[i][k] + y[k][j];
                }
            }
        }
        return z;
    }

    public static double[] arrayMulVec(double[][] x, double[] y) {
        double z[] = new double[x.length];
        for (int i = 0; i < z.length; i++) {             //номер строки буд массива
            for (int k = 0; k < x.length; k++) {       // или y.length - они равны
                z[i] = z[i] + x[i][k] + y[k];
            }
        }
        return z;
    }

    public static void showArray(double[][] m) {
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                System.out.printf("%-10.4f ", m[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void showArray(double[] m) {
        for (int i = 0; i < m.length; i++) {
            System.out.printf("%-10.4f ", m[i]);
            System.out.println();
        }
    }
}
