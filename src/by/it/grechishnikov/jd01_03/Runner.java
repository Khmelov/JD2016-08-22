package by.it.grechishnikov.jd01_03;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by Evgeniy on 27.08.16.
 */
public class Runner {
    private static double[] vector;
    private static double[][] matrix;

    public static void main(String[] args) {
//        Ввод-Вывод матриц
//        input();
//        output();

//        тест сортировок

        vector = new double[1];
        vector[0] = 1;
        sort();

//        Поиск минимума и максимума
//        minAndMax();

//        Умножение матрицы на вектор и матрицы на матрицу
//        multiply();
    }

    public static void input() {
        //Ввод
        vector = InOut.getArray();
        matrix = InOut.getMatrix();
    }

    public static void output() {
        //Вывод
        InOut.printMatrix(vector, "вектор", 5);

        InOut.printMatrix(matrix, "матрица");
    }

    public static void sort() {
        Util.sort(vector, true);
        InOut.printMatrix(vector, "first", 5);
        Util.sort(vector, false);
        InOut.printMatrix(vector, "first", 5);

        //Тест производительности сортировок
        int count = 30000;
        double[] test1 = new double[count];
        double[] test2 = new double[count];
        for (int i = 0; i < count; i++) {
            test1[i] = ThreadLocalRandom.current().nextDouble();
            test2[i] = test1[i];
        }
        System.out.println("\n***Start first (Bubble sort) speed test***\n" + count + " elements");
        Util.sort(test1, true);
        Util.sort(test1, false);
        Util.sort(test1, true);
        System.out.println("***End test***\n");

        System.out.println("\n***Start second (Arrays.sort()) speed test***\n" + count + " elements");
        Util.sort(test2, true);
        Util.sort(test2, false);
        Util.sort(test2, true);
        System.out.println("***End test***\n");
    }

    private static void minAndMax() {
        double min = Util.findMin(vector);
        double max = Util.findMax(vector);
        System.out.printf("Минмальный элемент вектора = %.2f.\nМаксимальный элемент вектора = %.2f\n\n", min, max);
    }

    public static void multiply() {
        InOut.printMatrix(Util.multiply(matrix, vector), "Матрица на вектор", 5);
        double[][] secondMatrix = {
                {1, 3, 2},
                {0, 4, -1}
        };
        InOut.printMatrix(Util.multiply(matrix, secondMatrix), "Матрица на матрицу");
    }
}