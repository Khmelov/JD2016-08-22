package by.it.kisel.JD01_02;

import java.util.Scanner;

public class TaskB {

    public static void kConsist(int k) {
        Scanner scanner = new Scanner(System.in);
        int n, m;
        System.out.println("Введите границы ");
        n = scanner.nextInt();
        m = scanner.nextInt();
        String s1 = "Принадлежит";
        String s2 = "Не принадлежит";
        String result = (k >= n && k <= m) ? s1 : s2;
        System.out.println("Принадлежность числа " + k + " интервалу [" + n + ";" + m + "] : " + result);

    }

    public static void printMatr(int k) {
        System.out.println("Матрица : ");
        int n = 1;
        for (int i = 0; i < Math.sqrt(k); i++) {
            for (int j = 0; j < Math.sqrt(k); j++) {
                System.out.print(n + " ");
                n++;
            }
            System.out.println();
        }
    }

    public static void uravnAnswer() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите a, b, c\n");
        int a, b, c;
        a = scanner.nextInt();
        b = scanner.nextInt();
        c = scanner.nextInt();
        System.out.println("Квадратное уравнение : " + a + "x^2+(" + b + ")x+(" + c + ") = 0");
        double[] mas = new double[2];
        double Diskr = b * b - 4 * a * c;
        if (Diskr >= 0) {
            mas[0] = (-b + Math.sqrt(Diskr)) / (2 * a);
            mas[1] = (-b - Math.sqrt(Diskr)) / (2 * a);
            System.out.print("Корни квадратного уравнения : " + mas[0] + ", " + mas[1]);
        } else System.out.println("Отрицательный дискриминант. Корней нет");
    }

    public static void mounthNumber() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите число от 1 до 12 :\n");
        int num = scanner.nextInt();
        if (num < 1 || num > 12) System.out.println("Число не из диапазона. Повторите попытку");
        else {
            System.out.print("Месяц - ");
            switch (num) {
                case 1: {
                    System.out.println("Январь");
                    break;
                }
                case 2: {
                    System.out.println("Февраль");
                    break;
                }
                case 3: {
                    System.out.println("Март");
                    break;
                }
                case 4: {
                    System.out.println("Апрель");
                    break;
                }
                case 5: {
                    System.out.println("Май");
                    break;
                }
                case 6: {
                    System.out.println("Июнь");
                    break;
                }
                case 7: {
                    System.out.println("Июль");
                    break;
                }
                case 8: {
                    System.out.println("Август");
                    break;
                }
                case 9: {
                    System.out.println("Сентябрь");
                    break;
                }
                case 10: {
                    System.out.println("Октябрь");
                    break;
                }
                case 11: {
                    System.out.println("Ноябрь");
                    break;
                }
                case 12: {
                    System.out.println("Декабрь");
                    break;
                }
            }
        }
    }

}
