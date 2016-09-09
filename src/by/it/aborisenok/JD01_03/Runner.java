package by.it.aborisenok.JD01_03;

import java.io.IOException;


public class Runner {
    public static void main(String[] args) throws IOException {

        // вводим одномерный массив
        // double[] array = InOut.inputLineArray(); //ввод через консоль
        double[] array = {3, 1, 3, 4};

        // вводим двухмерный массив
        // double[][] doubleArray = InOut.inputDoubleArray(); //ввод через консоль
        double[][] doubleArray = {
                {2, 5,  4, 1},
                {1, 3,  2, 1},
                {2, 10, 9, 7},
                {3, 8,  9, 2},
        };
        // выводим одномерный массив на печать
        InOut.printLineArray(array, "M");
        // выводим двухмерный массив на печать
        InOut.printDoubleArray(doubleArray, "M");
        // сортируем одномерный массив
        Solver.arraySort(array, false);
        // выводим отсортированный одномерный массив на печать
        InOut.printLineArray(array, "M");
        // выводим максимлаьное величину в массивеэ
        System.out.println("Максимально значение - " + Solver.maxDoubArray(array));
        // выводим минимальную величину в массиве
        System.out.println("МИнимальное Значение - " + Solver.minDoubArray(array));
        // пермноение матрицы и вектора
        double[] arr = Solver.arrayMulVector(doubleArray, array);
        System.out.println("Результат перемножения матрицы на вектор");
        InOut.printLineArray(arr, "M");
        // перемножение двух матриц
        double[][] doubleArr = Solver.arrayMulMatrix(doubleArray, doubleArray);
        System.out.println("Результат пермножения двух матриц");
        InOut.printDoubleArray(doubleArr, "M");
    }
}
