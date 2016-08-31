package by.it.voronovich.JD01_02;

/**
 * Класс содержит тела методов, предназначенных для решения задач блока B
 *
 * @author Dmitry Voronovich
 * @version 1.0
 */

public class Task_B {

    /**
     * Метод определяет принадлежность числа k интервалу[n,m]
     *
     * @param k - число интервала
     * @param n - нижняя граница интервала
     * @param m - верхняя граница интервала
     * @return возращает логическое значение в метод
     */
    protected static boolean getValue(int k, int n, int m) {
        if (k >= n && k <= m) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Метод объявляет и заполняет матрицу
     *
     * @param l - размер матрицы
     * @return возращает матрицу в метод
     */
    protected static int[][] getMatrix(int l) {
        int matrix[][] = new int[l][l];
        int n = 0;
        for (int i = 0; i < l; i++) {
            for (int j = 0; j < l; j++) {
                n += 1;
                matrix[i][j] = n;
            }
        }
        return matrix;
    }

    /**
     * Метод вычисляет корни квадратного уравнения
     *
     * @param a - параметр квадратного уравнения
     * @param b - параметр квадратного уравнения
     * @param c - параметр квадратного уравнения
     * @return возращает результат в виде строки
     */
    protected static String getRoots(int a, int b, int c) {
        double d = 0;
        double x1 = 0, x2 = 0;
        d = b * b - 4 * a * c;
        if (d > 0) {
            x1 = (-b + Math.sqrt(d)) / (2 * a);
            x2 = (-b - Math.sqrt(d)) / (2 * a);
            return "Корни квадратного уравнения: " + "x1 = " + x1 + ", x2 = " + x2;
        } else if (d == 0) {
            x1 = -b / 2 * a;
            return "Корень квадратного уравнения: " + "x1 = " + x1;
        } else {
            return "Уравнение с такими параметрами не имеет корней";
        }
    }

    /**
     * Метод определяет название месяца по календарному порядку
     * @param p - календарный номер месяца
     * @return возращает в метод результат в виде строки
     */
    protected static String getMonth(int p) {
        String h = null;
        switch (p) {
            case 1:
                h = "Январь";
                break;
            case 2:
                h = "Февраль";
                break;
            case 3:
                h = "Март";
                break;
            case 4:
                h = "Апрель";
                break;
            case 5:
                h = "Май";
                break;
            case 6:
                h = "Июнь";
                break;
            case 7:
                h = "Июль";
                break;
            case 8:
                h = "Август";
                break;
            case 9:
                h = "Сентябрь";
                break;
            case 10:
                h = "Октябрь";
                break;
            case 11:
                h = "Ноябрь";
                break;
            case 12:
                h = "Декабрь";
                break;
            default:
                h = "Месяца с таким номером не существует";
        }
        return h;
    }

}
