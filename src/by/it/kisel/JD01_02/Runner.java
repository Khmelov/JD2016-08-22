package by.it.kisel.JD01_02;



import java.util.Scanner;

public class Runner {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String line = "11 123 -123 -1 5";
        // line = Util.getLineConsole();
        System.out.println("LINE = " + line);
        int mas[] = Util.getIntArray(line);
//        for (int i : mas) {
//            System.out.print(i + " ");
//        }

        String arrStr[] = line.split(" ");

        System.out.println("\n Задание 1 \n");
        String maxStr = TaskA.maxLength(arrStr);
        System.out.println("Самое длинное число = " + maxStr);
        System.out.println("Его длина = " + maxStr.length());
        String minStr = TaskA.minLength(arrStr);
        System.out.println("Самое короткое число = " + minStr);
        System.out.println("Его длина = " + minStr.length());

        System.out.println("\n Задание 2 \n");
        double mean = TaskA.mean(mas);
        System.out.println("Среднее арифметическое = " + mean);
        System.out.print("Числа, длина которых меньше среднего арифметического :   ");
        for (String s : arrStr) {
            if (s.length() < mean)
                System.out.print(s + " ");
        }
        System.out.println("\n\n Задание 3 \n");
        System.out.println("Первое число, с различными цифрами : " + TaskA.elemDifNumber(arrStr));

        System.out.println("\n---------------------------------------------------------\n");
        System.out.println("              Часть B\n");

        System.out.println("\n Задание 1 \n");
        System.out.println("Введите число ");
        int k = scanner.nextInt();
        TaskB.kConsist(k);

        System.out.println("\n Задание 2 \n");
        TaskB.printMatr(k);

        System.out.println("\n Задание 3 \n");
        TaskB.uravnAnswer();

        System.out.println("\n\n Задание 4 \n");
        TaskB.mounthNumber();


    }
}