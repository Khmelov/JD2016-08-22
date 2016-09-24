package by.it.aborisenok.JD01_13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Лёша on 24.09.2016.
 */
public class TaskA {
    public static void run() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        boolean isWork = true;
        double rootSum = 0;

        while (isWork) {
            try {
                System.out.println("Введите число:");
                String s = reader.readLine();
                if (!s.equals("END")) {
                    double value = Integer.parseInt(s);
                    if (value > 0) {
                        rootSum += Math.sqrt(value);
                        System.out.println("Введённое число - " + value);
                        System.out.println("Сумма корней введённых чисел - " + rootSum);
                    } else {
                        throw new IllegalArgumentException();
                    }
                } else {
                    System.out.println("Конец работы программы...");
                    isWork = false;
                }
            } catch (IOException e) {
                System.out.println("Введена пустая строка.");
            } catch (NumberFormatException e) {
                System.out.println("Введёное значение не является числом.");
            } catch (IllegalArgumentException e) {
                System.out.println("Невозможно получить корень отрицательного числа.");
            }
        }
        try {
            reader.close();
        } catch (IOException e) {
            System.out.println("Невозможно закрыть поток чтения.");
        }
    }
}
