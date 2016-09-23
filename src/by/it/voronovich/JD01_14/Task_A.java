package by.it.voronovich.JD01_14;

import java.io.*;

/**
 * Класс содержит тела методов решения 1-ого задания
 *
 * @author Voronovich Dmitry
 * @version 1.0
 */

public class Task_A {

    /**
     * Метод записывает в двоичном формате числа в файл
     *
     * @param filename
     */
    public static void task_A_writing(String filename) {

        File f = new File(filename);

        try (DataOutputStream data = new DataOutputStream(new FileOutputStream(f))) {
            for (int i = 0; i < 20; i++) {
                data.writeInt((int) (Math.random() * 10 + 10));
            }
        } catch (IOException e) {
            System.err.println("Ошибка записи файла...");
        }
    }

    //--------------------------->>>>>>>>>>>>>><<<<<<<<<<<<<<<<-----------------------------

    /**
     *Метод читает числа из файла и находит их среднее арифметическое
     *
     * @param filename
     */
    public static void task_A_reading(String filename) {

        File f = new File(filename);

        try (DataInputStream data = new DataInputStream(new FileInputStream(f))) {
            double sum = 0;
            double x = 0;
            int count = 0;
            while (data.available() > 0) {
                x = data.readInt();
                System.out.print(x + "; ");
                sum += x;
                count++;
            }
            sum = sum / count;
            System.out.println(" ");
            System.out.println("Среднее арифметическое: " + sum);
        } catch (IOException e) {
            System.err.println("Ошибка чтения файла...");
        }
    }
}
