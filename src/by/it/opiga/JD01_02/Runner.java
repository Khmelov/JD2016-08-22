package by.it.opiga.JD01_02;

import java.util.Arrays;
import java.util.Scanner;

public class Runner {

    public static void main(String[] args) {
        String line = "11 15686 5 65 8 88 93 -45";
        int mas[] = TaskA.lineToIntArray(line);

        //А1 Найти самое короткое и самое длинное число. Вывести эти числа и их длину
        System.out.println(TaskA.getMax(mas));
        System.out.println(TaskA.getMin(mas));

        //A2 Вывести на консоль те числа, длина которых меньше среднего арифметического
        double mean = TaskA.getMean(mas);
        for (int i : mas) {
            if (i < mean) {
                System.out.print(i + " ");
            }
        }

        //A3 Найти число, состоящее только из различных цифр. Если таких чисел несколько,
        //найти первое из них.
        for (int i : mas) {
            if (TaskA.getDiffNum(i)) {
                System.out.println("Число с различными цифрами " + i);
                break;
            }
        }

        //B1 Определить принадлежность некоторого числа к интервалу [n, m]
        int k = 8;
        int n = 4, m = 9;
        if (TaskB.inInterval(k, n, m))
            System.out.println("k принадлежит интервалу " + "\n");
        else System.out.println("не принадлежит " + "\n");

        //B2 Вывести числа от 1 до b в виде матрицы N x N слева направо и сверху вниз
        //(b выберите квадратом целого числа
        System.out.println("ввод b - квадрат целого числа ");
        Scanner scan = new Scanner(System.in);
        String b = scan.nextLine();
//        scan.close();
        double doubb = Double.parseDouble(b);
        double i = Math.sqrt(doubb);
        int num = 1;
        for (int j = 1; j <= i; j++) {
            num = TaskB.printNum(num, (int) i);
            System.out.println("");
        }

        //B3 Найти корни квадратного уравнения. Параметры уравнения передавать с
        // командной строкой ax2 + bx + c = 0
        System.out.println("ввод параметров квадратного уравнения ");

        String a1 = scan.nextLine();
        String a2 = scan.nextLine();
        String a3 = scan.nextLine();


        double a11 = Double.parseDouble(a1);
        double a22 = Double.parseDouble(a2);
        double a33 = Double.parseDouble(a3);
//        double dmas[]=new double[2];
        double dmas[] = TaskB.calc(a11, a22, a33);
        System.out.println("x1 = " + dmas[0] + "  x2 = " + dmas[1] + "\n");

        //B4 Ввести число от 1 до 12. Вывести на консоль название месяца,
//        соответствующего данному числу. Осуществить проверку корректности
//        ввода чисел.
        System.out.println("ввод числа от 1 до 12 ");
        String c = scan.nextLine();

        System.out.println(TaskB.printMonth(c));

        //C1 Найти сумму элементов матрицы, расположенных между первым и
        //вторым положительными элементами каждой строки
        System.out.println("ввести размерность матрицы ");
        String x = scan.nextLine();
        int y = Integer.parseInt(x);
        int mas2[][];
        mas2 = TaskC.fullMas(y);
        int sum[] = TaskC.sumElem(mas2, y);
        System.out.println("Сумма между положит эл-тами матрицы:");
        for (int j = 0; j < y; j++) {
            System.out.print(" " + sum[j] + " ");
        }
        System.out.println(" ");
        scan.close();

        // C4  Построить матрицу, вычитая из элементов каждой строки матрицы ее
        // среднее арифметическое.
        System.out.println("матрица без среднего арифметического");
        int mas3[][] = TaskC.delMean(mas2, y);
        for (int j = 0; j < y; j++) {
            for (int t = 0; t < y; t++) {
                System.out.print(" " + mas3[j][t] + " ");
            }
            System.out.println(" ");
        }

        // C2 Транспонировать матрицу.
        System.out.println("Транспонированная матрица");
        int tranmas[][] = new int[y][y];
        tranmas = TaskC.transMas(tranmas, mas2, y);
        for (int j = 0; j < y; j++) {
            for (int l = 0; l < y; l++) {
                System.out.print(tranmas[j][l] + " ");
            }
            System.out.println("\n");
        }

        //C3 Повернуть матрицу на 90 градусов против часовой стрелки.
        System.out.println("матрица исходная");
        int turnMas[][] = TaskC.turnMas(mas2, y);
        for (int h = 0; h < y; h++) {
            for (int l = 0; l < y; l++)
                System.out.print(mas2[h][l] + " ");
            System.out.println("");
        }
        System.out.println("матрица на 90 градусов ");
        System.out.println("");
        for (int j = 0; j < y; j++) {
            for (int l = 0; l < y; l++) {
                System.out.print(turnMas[j][l] + " ");
            }
            System.out.println("");
        }




    }
}
