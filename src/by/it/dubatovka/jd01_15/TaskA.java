package by.it.dubatovka.jd01_15;

import java.io.*;
import java.util.Random;

public class TaskA {

    static void taskA() throws IOException {
        System.out.println("Вариант А.\n" +
                "§ Создайте матрицу 4 на 4 из целых случайных чисел от -15 до 15.\n" +
                "§ Выведите матрицу на консоль и в текстовый файл matrix.txt, расположенный в папке задания\n" +
                "JD01_15. При выводе для каждого числа рекомендуется предусмотреть для него три\n" +
                "знакоместа, а между числами – один пробел. Итого: матрица займет 4 строки по 16 символов.");

        //создаем матрицу
        String[][] arr = new String[4][4];
        Random random = new Random();

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                Integer x = random.nextInt(31) - 15;
                arr[i][j]=x.toString();
            }
        }

        String src = System.getProperty("user.dir") + "/src/by/it/dubatovka";
        String filename = src + "/jd01_14/matrix.txt";
        File file = new File(filename);

        try (PrintWriter printer=
                     new PrintWriter(
                             new FileWriter(filename, true))){
            for (String[] s : arr) {
                System.out.println();
                for (String s1 : s) {
                    System.out.printf("%4s", s1);
                    printer.printf("%4s", s1);
                }
            }
        } catch (IOException e) {
            System.err.println("Ошибка файла: "+ e);
        }
    }
}





