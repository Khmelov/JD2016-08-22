package by.it.aborisenok.JD01_04;

/**
 * Created by Лёша on 06.09.2016.
 */
public class Utils {
    public static double[] findRoot(double[] [] mA, double[] mY) {
        int n = mA.length; //размер системы уравнения
        double[][] m = new double[n][n+1];
        // перенос матрицы mA в операционную матрицу m
        for (int row = 0; row < n; row++)
            for (int col = 0; col < n; col++)
                m[row][col] = mA[row][col];
        // перенос вектора mY в операционную матрицу m
        for (int row = 0; row < n; row++)
            m[row][n] = mY[row];
        // прямой ход
        double k;
        for (int diag = 0; diag < n-1; diag++) {
            for (int row = diag + 1; row < n; row++) {
                k = m[row][diag]/m[diag][diag];
                for (int col = 0; col < n+1; col++)
                    m[row][col] = m[row][col] - m[diag][col]*k;
            }
        }
        // обратный ход
        for (int diag = n-1; diag > 0; diag--){
            for (int row = 0; row < diag; row++){
                k = m[row][diag]/m[diag][diag];
                for (int col = 0; col < n+1; col++)
                    m[row][col] = m[row][col] - m[diag][col]*k;
            }
        }
        // приводим главную диогональ к 1
        for (int i =0; i < n; i++) {
            k = 1/m[i][i];
                for (int j = 0; j < n+1; j++)
                    m[i][j] = m[i][j]*k;
        }
        // заполняем массив корнями и возвращаем в качестве результата
        double[] x = new double[n];
        for (int i = 0; i < n; i++)
            x[i] = m[i][n];
        return x;
    }
}
