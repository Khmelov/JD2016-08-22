package by.it.aborisenok.JD01_03;

/**
* Класс содержит методы для работы с массивами
        * @author Aliaksei Borisenok
        * @version 1.0
        */
public class Solver {
    /**
    * Метод служит для min или max сортировки одномерного массива
     * @param arr одномерный массив типа double
     * @param direction направление сортировки массива, true - по возрастанию, false - по убыванию
     */
    public static void arraySort(double[] arr, boolean direction) {
        for (int i = 0; i < arr.length-1; i++){
            for (int j = i+1; j < arr.length; j++) {
                if((direction && arr[i] > arr[j]) ||
                        (!direction && arr[i] < arr[j]))
                {
                    double m = arr[i];
                    arr[i] = arr[j];
                    arr[j] = m;
                }
            }
        }
    }

     /** Поиск максимума для массива Double
     * @param arr одномерный массив
     * @return максимум или Integer.MAX_VALUE если массив пустой
     */
    public static double maxDoubArray(double[] arr) {
        if (0 == arr.length){
            return Integer.MAX_VALUE;
        } else {
            double max = arr[0];
            for (double m : arr) {
                if (max < m)
                    max = m;
            }
            return max;
        }
    }

    /** Поиск минимума для массива Double
     * @param arr одномерный массив
     * @return минимум или Integer.MIN_VALUE если массив пустой
     */
    public static double minDoubArray(double[] arr) {
        if (0 == arr.length){
            return Integer.MIN_VALUE;
        } else {
            double min = arr[0];
            for (double m : arr) {
                if (min > m)
                    min = m;
            }
            return min;
        }
    }

    /** Поиск минимума для массива Double
     * @param x двухмерный массив
     * @param y вектор
     * @return матрица
     */
    public static double[] arrayMulVector(double[][] x, double[] y){
        double[] z = new double[x.length];
        for (int i = 0; i < x.length; i++){
            for (int j = 0; j < y.length; j++)
                z[i] = z[i] + x[i][j] + y[j];
        }
        return z;
    }

    /** Поиск минимума для массива Double
     * @param x двухмерный массив
     * @param y двухмерный массив
     * @return матрица
     */
    public static double[][] arrayMulMatrix(double[][] x, double[][] y) {
        double[][] z = new double[x.length][y[0].length];
        for (int i = 0; i < x.length; i++)
            for (int j = 0; j < y[0].length; j++)
                for (int k = 0; k < y.length; k++)
                    z[i][j] = z[i][j] + x[i][k]*y[k][j];
    return z;
    }
}
