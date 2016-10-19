package by.it.dubatovka.JD01.jd01_14;

import java.io.*;

import static java.lang.Math.*;


/**
 * Решение задачи А. Записать в двоичный файл 20 случайных чисел.
 * Прочитать записанный файл, распечатать числа и их среднеарифметическое.
 */
public class TaskA {


    /**
     * Запись в двоичный файл 20 случайных числе
     *
     * @throws IOException FileNotFoundException
     */
     static void taskA() throws IOException {
        System.out.println("Задание А. Записать в двоичный файл 20 случайных чисел.\n" +
                "Прочитать записанный файл, распечатать числа и их среднеарифметическое.\n" +
                "-----------------------------------------------------------------------");

        String src = System.getProperty("user.dir") + "/src/by/it/dubatovka";
        String filename = src + "/jd01_14/dubatovka.dat";
        File f = new File(filename);

        DataOutputStream dos = null;
        try {
            dos = new DataOutputStream(new FileOutputStream(f));
            for (int i = 0; i < 20; i++) {
                dos.writeInt((int) (Math.random() * 10));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Файл не найден");
        } finally {
            if (dos != null) dos.close();
        }


        try (DataInputStream inp = new DataInputStream(new BufferedInputStream(new FileInputStream(filename)))) { //закрывать поток в finally не надо
            double sum = 0;
            double count = 0;

            while (inp.available() > 0) {
               int i = inp.readInt();
                sum += i;
                count++;
                System.out.print(i+" ");
            }
            System.out.println();
            System.out.println("Average=" + sum / count);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
