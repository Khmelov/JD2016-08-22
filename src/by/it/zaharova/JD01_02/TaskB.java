package by.it.zaharova.JD01_02;


import java.util.Scanner;

public class TaskB {
    public static void Testing() {
        Scanner scanner = new Scanner(System.in);
        int chislo;
        int x0;
        int x;
        System.out.println("Введите число и промежуток: ");
        chislo = scanner.nextInt();
        x0 = scanner.nextInt();
        x = scanner.nextInt();
        if (chislo <= x && chislo >= x0)
            System.out.println("Принадлежит");
        else
            System.out.println("Не принадлежит");
    }

    public static void Array() {
        System.out.println("Введите размер матрицы: ");
        Scanner scanner = new Scanner(System.in);
        int k;
        k = scanner.nextInt();
        int chislo = 1;
        for (int i = 0; i < Math.sqrt(k); i++) {
            for (int j = 0; j < Math.sqrt(k); j++) {
                System.out.print(chislo + "  ");
                chislo++;
            }
            System.out.println();
        }
    }

    public static void Yravnenie() {
        System.out.println("Введите параметры a,b,c: ");
        Scanner scanner = new Scanner(System.in);
        int a, b, c;
        double x1, x2, x0;
        a = scanner.nextInt();
        b = scanner.nextInt();
        c = scanner.nextInt();
        int D = b * b - 4 * a * c;
        double sqrtD = (double)Math.sqrt(D);
        if (D > 0) {
            x1 = (-b + sqrtD)/2*a;
            System.out.println(x1);
            x2 = (-b - sqrtD)/2*a;
            System.out.println(x2);
        }
        if (D == 0) {
            x0 = (double)-b/2*a;
            System.out.println(x0);
        } else if (D < 0)
            System.out.println("D меньше нуля");


    }

    public static void Mounth() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите число от 1 до 12 :\n");
        int num = scanner.nextInt();
        if (num < 1 || num > 12) System.out.println("Число введено неверно.");
        else {
            System.out.print("Месяц : ");
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

