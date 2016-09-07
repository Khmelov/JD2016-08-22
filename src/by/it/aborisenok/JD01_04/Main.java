package by.it.aborisenok.JD01_04;

/**
 * Created by Лёша on 06.09.2016.
 */
public class Main {
    public static void main(String[] args) {
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

        // поиск корней
        double[] roots = Utils.findRoot(doubleArray,array);
        // вывод результата в консоль
        InOut.printLineArray(roots, "R");
    }
}
