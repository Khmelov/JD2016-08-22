package by.it.opiga.JD01_03;

import java.util.Arrays;

/**
 * Created by Asus on 28.08.2016.
 */
public class Runner {
    public static void main(String[] args) {

        System.out.println("вывод одномерного массива");
        double mas[] = {1.1, 2.4, 7.85, 6.5, 4.2, 1.2};
        // double mas2[] = InOut.stringLineVDoubleArray();
        InOut.ArrayPrint(mas, "m", 6);

        System.out.println("вывод многомерного массива");
        double mas2[][] = {{1.1, 2.4, 7.85}, {6.5, 4.2, 1.2}, {6.5, 5.2, 6.2}, {8.5, 4.0, 3.2}};
        InOut.ArrayPrintTwo(mas2, "m2");

        System.out.println("сортировка по убыванию");
        double mas3[] = {1.1, 2.4, 7.85, 6.5, 4.2, 1.2};
        Util.sortFromMaxToMin(mas3);
        InOut.ArrayPrint(mas3, "m3", mas3.length);

        System.out.println("сортировка по возрастанию");
        Util.sortFromMinToMax(mas3);
        InOut.ArrayPrint(mas3, "m3", mas3.length);

        System.out.println("сортировка  Arrays.sort");
        double sortMas[] = {1.1, 2.4, 7.85, 6.5, 4.2, 1.2};
        Arrays.sort(sortMas);
        InOut.ArrayPrint(sortMas, "sortMas", 6);

        System.out.println("минимум, максимум");
        double mas4[] = {1.1, 2.4, 7.85, 6.5, 4.2, 9.14, 1.2};
        System.out.println("max= " + Util.getMax(mas4));
        System.out.println("min= " + Util.getMin(mas4));
        System.out.println("");

        System.out.println("умножение массива на вектор");
        double mas5[][] = {{1.1, 2.4, 7.85}, {6.5, 4.2, 1.2}, {6.5, 5.2, 6.2}, {8.5, 4.0, 3.2}};
        double vect[] = {1.1, 2.4, 7.85};
        double mas6[] = Util.arrayMultVector(mas5, vect);
        InOut.ArrayPrint(mas6, "m6", mas5.length);

        System.out.println("умножение массива на массив");
        double mas7[][] = {{1.1, 2.4, 7.85}, {6.5, 4.2, 1.2}, {6.5, 5.2, 6.2}, {8.5, 4.0, 3.2}};
        double mas8[][] = {{0.1, 4.4, 5.5}, {1.1, 2.4, 7.85}, {1.1, 2.4, 7.85}};
        double mas9[][] = Util.arrayMultArray(mas7, mas8);
        InOut.ArrayPrintTwo(mas9, "m9");

        System.out.println("метод для решения слау методом Жордана-Гаусса");
        double[][] a = {
                {2.0, 5.0, 4.0, 1.0},
                {1.0, 3.0, 2.0, 1.0},
                {2.0, 10.0, 9.0, 7.0},
                {3.0, 8.0, 9.0, 2.0}
        };
        double[] y = {20.0, 11.0, 40.0, 37.0};
        double[] x=Util.findRoot(a,y);
        System.out.println("Решение СЛАУ");
        InOut.ArrayPrint(x,"X",1);

        System.out.println("Проверка A*X");
        InOut.ArrayPrint( Util.arrayMultVector(a,x),"y",1);

        System.out.println("Определитель матрицы М = "+Util.findDeterminant(a)+"\n");

        double inversMat[][]=Util.inverseMatrix(a);
        System.out.println("Обратная матрица M(-1)");
        InOut.PrintArray(inversMat);
        System.out.println("Проверка M*M(-1)");
        InOut.PrintArray(Util.arrayMultArray(inversMat,a));



    }


}
