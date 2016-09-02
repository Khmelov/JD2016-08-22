package by.it.grechishnikov.jd01_03;

import java.util.Scanner;

/**
 * Используется для ввода-вывода матриц и векторов.
 * @author Grechishnikov
 * @version 1.0
 */

public class InOut {
    /**
     * Поле класса для чтения с клавиатуры.
     * Создана единожды и работает во всех методах.
     */
    private static Scanner scanner = new Scanner(System.in);

    /**
     * Выводим массив на экран.
     * @param matrix - массив-вектор, который нужно вывести на консоль.
     * @param name - имя массива, которое указывается при его выводе.
     * @param cols - количество элементов, выводимых на 1 строку.
     */
    public static void printMatrix(double[] matrix, String name, int cols) {
        //Выводим одномерную матрицу на консоль
        System.out.println(name + ":");
        int col = 0;
        for (int i = 0; i < matrix.length; i++) {
            System.out.printf("[% -3d]=% -8.2f ", i ,matrix[i]);
            col++;
            if(col%cols == 0) {
                System.out.println();
            }
        }
        System.out.println();
    }

    /**
     * Перегруженная версия метода вывод массива на экран.
     * Работает с двумерными массивами (матрицами).
     * @param matrix - матрица, которая выводится на экран.
     * @param name - имя матрицы.
     */
    public static void printMatrix(double[][] matrix, String name) {
        //Выводим двумерную матрицу на консоль
        System.out.println(name + ":");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.printf("[% d,% -3d]=% -8.2f", i , j, matrix[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    /**
     * Метод для ввода массива с клавиатуры.
     * @return - возвращает массив чисел.
     */
    public static double[] getArray() {
        System.out.println("Для того, что бы получить одномерную матрицу, введите числа через пробел:");
        String[] tmpArray = scanner.nextLine().split(" ");
        double[] arr = new double[tmpArray.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Double.parseDouble(tmpArray[i]);
        }
        return arr;
    }

    /**
     * Метод для ввода матрицы с клавиатуры.
     * @return - возвращает матрицу.
     */
    public static double[][] getMatrix() {
        System.out.println("Для того, что бы получить двумерную матрицу, введите числа через пробел. Для перехода на новую строку" +
                "введите \" ! \". Для завершения ввода нажмите Enter:");
        String[] tmpArray = scanner.nextLine().split(" ");
        int lineCount = 1;
        int maxSize = 1;
        int size = 0;
        for (String s : tmpArray) {
            if (s.contains("!")) {
                size = 0;
                lineCount++;
                continue; /*переход к следующей итерации цикла, т.к. был введен условный разделитель строк. никаких операций
                          больше проводить не нужно на данной итерации.*/
            }
            size++;
            if(size > maxSize) {
                maxSize = size;
            }
        }
        int lineIndex = 0;
        int position = 0;
        double[][] result = new double[lineCount][maxSize];
        for (int i = 0; i < tmpArray.length; i++) {
            String s = tmpArray[i];
            if(!s.contains("!")) {
                result[lineIndex][position] = Double.parseDouble(s);
                position++;
            } else {
                lineIndex++;
                position = 0;
            }
        }
        return result;
    }
}
