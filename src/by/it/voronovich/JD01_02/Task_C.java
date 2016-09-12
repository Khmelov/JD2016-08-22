package by.it.voronovich.JD01_02;

/**
 * Класс содержит тела методов, предназначенных для решения задач блока C
 *
 * @author Dmitry Voronovich
 * @version 1.0
 */

public class Task_C {

    /**
     * Метод вычисдяет умму элементов матрицы, расположенных между первым и
     * вторым положительными элементами каждой строки.
     * @param a входная матрица
     * @param f размер входной матрицы
     * @return возрвращает в метод сумму
     */
    protected static int getSumNonPositive(int a[][], int f){
        int sumMain=0;
        for(int i = 0; i<a.length; i++){
            int n = 0;
            int sum = 0;
            for(int j = 0; j< f; j++){
                if (n==0 && a[i][j]>0) {
                    n++;
                } else if (n==1 && a[i][j]>0){
                    n++;
                }
                else if(n==1 && a[i][j]<=0){
                    sum+=a[i][j];
                }
                else if (n==2){
                    break; //окончание подсчета суммы отрицательных элементов
                }
            }
            if (n==2) {
                sumMain+= sum;
            }
        }
        return sumMain;
    }

    /**
     * Метод вычисляет транспонированную матрицу
     *
     * @param a входная матрица
     * @param f размер матрицы
     * @return возращает в метод транспонированную матрицу
     */
    protected static int[][] getTMatrix(int a[][], int f){
        int arrayT[][] = new int[f][f];
        for(int i = 0; i< f; i++){
            for(int j = 0; j<f; j++){
               arrayT[j][i]=a[i][j];
            }
        }
        return arrayT;
    }

    /**
     * Метод поворачивает матрицу на 90 градусов против часовой стрелки
     *
     * @param a входная матрица
     * @param f размер матрицы
     * @return возращает в метод повернутую матрицу
     */
    protected static int[][] getRotatedMatrix(int a[][], int f){
        int arrayR[][] = new int[f][f];
        for(int i = 0; i< f; i++){
            for(int j = 0; j<f; j++){
                arrayR[i][j]=a[j][f-1-i];
            }
        }
        return arrayR;
    }

    /**
     * Метод вычитает из элементов каждой строки матрицы их среднеарифметическое
     *
     * @param a входная матрица
     * @param f размер матрицы
     * @return возращает в метод пересчитанную матрицу
     */
    protected static double[][] getModifiedMatrix(int a[][], int f){
        double arrayM[][] = new double[f][f];
        for(int i = 0; i< f; i++){
            double average = 0;
            for(int j = 0; j<f; j++){
                average+=a[i][j];
            }
            average = average/f;
            for(int j = 0; j<f; j++){
                arrayM[i][j] = a[i][j]-average;
            }
        }
        return arrayM;
    }

    /**
     * Метод переносит элемень матрицы с минимальным значением на место элемента [1][1]
     * путем перестановуи строк и столбцов
     *
     * @param a входная матрица
     * @param f размер матрицы
     * @return возращает в метод новую матрицу
     */
    protected static int[][] changePositionRowCols(int a[][], int f){

        int a1[][]=new int[f][f];
        for (int i = 0; i < f; i++) {
            for (int j = 0; j < f ; j++) {
                a1[i][j]=a[i][j];
            }
        }
        int minDigit = Integer.MAX_VALUE;
        for(int i = 0; i< f; i++){
            for(int j = 0; j<f; j++){
                if(a1[i][j]<minDigit){
                    minDigit=a1[i][j];
                }
            }
        }
        for (int i = 0; i < f; i++) {
            for (int j = 0; j < f; j++) {
                if(a1[i][j]==minDigit){
                        int p=0;
                        for (int l = 0; l < f; l++) {
                            p=a1[1][l];
                            a1[1][l]=a1[i][l];
                            a1[i][l]=p;
                    }
                }
            }
        }
            for (int j = 0; j < f; j++) {
                if (a1[1][j] == minDigit) {
                    int p = 0;
                    for (int i = 0; i < f; i++) {
                            p = a1[i][1];
                            a1[i][1] = a1[i][j];
                            a1[i][j] = p;
                    }
                }
            }
        return a1;
    }

    /**
     * Метод переносит нулевые элементы каждой строки в их конец
     *
     * @param a входная матрица
     * @param f размер матрицы
     * @return возращает в метод новую матрицу
     */
    protected static int[][] changePositionNull(int a[][], int f){

        int a2[][]=new int[f][f];
        for (int i = 0; i < f; i++) {
            for (int j = 0; j < f ; j++) {
                a2[i][j]=a[i][j];
            }
        }
        for(int i = 0; i< f; i++) {
            int p = 0;
            for (int g = f - 1; g > 0; g--) {
                for (int j = 0; j < g; j++) {
                    if (a2[i][j] == 0) {
                        p = a2[i][j+1];
                        a2[i][j+1] = a2[i][j];
                        a2[i][j] = p;
                    }
                }
            }
        }
        return a2;
    }

}
