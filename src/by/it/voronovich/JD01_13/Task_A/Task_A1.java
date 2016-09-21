package by.it.voronovich.JD01_13.Task_A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Класс демонстрирует использование исключений
 *
 * @author Voronovich Dmitry
 * @version 1.0
 */

public class Task_A1 {

    public static void main(String[] args) throws IOException {

        double result = 0;
        double sum = 0;

        while (true) {
            BufferedReader read = new BufferedReader(new InputStreamReader((System.in)));
            String str = read.readLine();
            int number = 0;
            if (str.equals("END")) {
                read.close();
                break;
            } else {
                try {
                    number = Integer.parseInt(str);
                    if (number > 0) {
                        result = Math.sqrt(number);
                        sum += result;
                        System.out.println(number + " : " + sum);
                    } else {
                        throw new ArithmeticException();
                    }
                } catch (NumberFormatException e) {
                    System.err.print("Некорректный ввод данных, попробуйте ввести число...");
                } catch (ArithmeticException e) {
                    System.err.print("Неккорректный ввод числа, введите число больше нуля...");
                }
            }
        }
    }
}
