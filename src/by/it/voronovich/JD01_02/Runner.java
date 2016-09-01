package by.it.voronovich.JD01_02;

/**
 * Класс служит для выполнения методов пакета
 *
 * @author Dmitry Voronovich
 * @version 1.0
 */

import java.io.IOException;

public class Runner {

    public static void main(String[] args) throws IOException {

        //String line = 12 421 1451254 -421 121;
        //int[] arr = Util.lineToArrayInt(line);
        //String[] arrStr = Util.lineToArrayStr(line);

        System.out.println("Введите строку чисел:");
        String line = Util.getOneLine();

        int[] arr = Util.lineToArrayInt(line);
        String[] arrStr = Util.lineToArrayStr(line);

        System.out.println("Введите значение переменной k:");
        int k = Util.getK();
        System.out.println("Введите значение нижнего предела интервала n:");
        int n = Util.getN();
        System.out.println("Введите значение верхнего предела интервала m:");
        int m = Util.getM();

        System.out.println("Введите количество строк(столбцов) l матрицы :");
        int l = Util.getL();

        System.out.println("Введите параметры a,b и c квадратного уравнения ax2+bx+c=0 соответственно через пробел:");
        int a = Util.getА();
        int b = Util.getB();
        int c = Util.getC();

        System.out.println("Введите календарный номер месяца в пределах [1,12]:");
        int p = Util.getP();

        System.out.println("Введите размерность матрицы f:");
        int f =Util.getF();

        //Найти самое короткое и самое длинное число.
        // Вывести найденные числа и их длину.
        System.out.println("Задание 1А:");
        String min = Task_A.getMin(arrStr);
        System.out.println(min);
        String max = Task_A.getMax(arrStr);
        System.out.println(max);

        //Вывести на консоль те числа, длина которых
        // меньше среднего арифметического.
        System.out.println("Задание 2А:");
        System.out.print("Числа, строковые длины которых меньше иx среднеарифметического: ");
        double mean = Task_A.mean(arr);
        for (String i : arrStr) {
            if ((double) i.length() < mean) {
                System.out.print(i + " ");
            }
        }
        System.out.println(" ");

        //Найти число, состоящее только из различных цифр.
        // Если таких чисел несколько, найти первое из них.
        System.out.println("Задание 3А:");
        for (String i : arrStr) {
            if (Task_A.getUniqueDigit(i)) {
                System.out.println("Найдено число из разных цифр: " + i);
                break;
            }
        }

        //Определить принадлежность некоторого значения k интервалу [n, m].
        System.out.println("Задание 1B:");
        if (true == Task_B.getValue(k, n, m)) {
            System.out.println("Число " + k + " лежит в интервале [" + n + "," + m + "]");
        } else {
            System.out.println("Число " + k + " не лежит в интервале [" + n + "," + m + "]");
        }

        //Вывести числа от 1 до k в виде матрицы N x N
        // слева направо и сверху вниз(k выберите квадратом целого числа).
        System.out.println("Задание 2B:");
        int matrix[][] = Task_B.getMatrix(l);
        for (int i = 0; i < l; i++) {
            for (int j = 0; j < l; j++) {
                System.out.printf("%4.2s ",matrix[i][j]);
            }
            System.out.println("");
        }

        //Найти корни квадратного уравнения. Параметры уравнения
        // передавать командной строкой.
        System.out.println("Задание 3B:");
        String result = Task_B.getRoots(a, b, c);
        System.out.println(result);

        //Ввести число от 1 до 12. Вывести на консоль название месяца,
        //соответствующего данному числу. Осуществить проверку корректности
        //ввода чисел.
        System.out.println("Задание 4B:");
        String month = Task_B.getMonth(p);
        System.out.println("Числу " + p + " соответствует месяц " + month);
        System.out.println("");


        System.out.println("Матрица случайных чисел для раздела задач C");
        int arrNew[][] = new int[f][f];
        for (int i = 0; i < f; i++) {
            for (int j = 0; j < f; j++) {
                int random = -f + (int) (Math.random() * ((f - (-f)) + 1));
                arrNew[i][j] = random;
            }
        }
        for (int i = 0; i < f; i++) {
            for (int j = 0; j < f; j++) {
                System.out.printf("%4.2s ",arrNew[i][j]);
            }
            System.out.println("");
        }

        //Найти сумму элементов матрицы, расположенных между первым и
        //вторым положительными элементами каждой строки.
        System.out.println("Задание 1C:");
        int sum = Task_C.getSumNonPositive(arrNew,f);
        System.out.println(sum);

        //Транспонировать матрицу.
        System.out.println("Задание 2C:");
        int arrayT[][]=Task_C.getTMatrix(arrNew,f);
        for(int j = 0; j<f; j++){
            for(int i =0; i<f; i++){
                System.out.printf("%4.2s ",arrayT[j][i]);
            }
            System.out.println(" ");
        }

        //Повернуть матрицу на 90 градусов против часовой стрелки.
        System.out.println("Задание 3C:");
        int arrayR[][]=Task_C.getRotatedMatrix(arrNew,f);
        for(int i = 0; i<f; i++){
            for(int j =0; j<f; j++){
                System.out.printf("%4.2s ",arrayR[i][j]);
            }
            System.out.println(" ");
        }

        //Построить матрицу, вычитая из элементов каждой строки матрицы ее
        // среднее арифметическое.
        System.out.println("Задание 4C:");
        double arrayM[][]=Task_C.getModifiedMatrix(arrNew,f);
        for(int i = 0; i<f; i++) {
            for (int j = 0; j < f; j++) {
                System.out.printf("%6.2f ", arrayM[i][j]);
            }
            System.out.println(" ");
        }

        //В матрице найти минимальный элемент и переместить его на место
        //[1,1] путем перестановки строк и столбцов.
        System.out.println("Задание 6C:");
        int ar[][]=Task_C.changePositionRowCols(arrNew,f);
        for(int i = 0; i<f; i++) {
            for (int j = 0; j < f; j++) {
                System.out.printf("%6.2s ", ar[i][j]);
            }
            System.out.println(" ");
        }

        //Преобразовать строки матрицы таким образом, чтобы элементы,
        //равные нулю, располагались после всех остальных.
        System.out.println("Задание 7C:");
        int arrayX[][]=Task_C.changePositionNull(arrNew,f);
        for(int i = 0; i<f; i++) {
            for (int j = 0; j < f; j++) {
                System.out.printf("%6.2s ", arrayX[i][j]);
            }
            System.out.println(" ");
        }
    }
}
