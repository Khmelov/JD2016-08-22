package by.it.filimonchik.jd01_13;

import java.io.IOException;
import java.util.Scanner;

import static java.awt.Event.END;

/**
 * Created by Raman.Filimonchyk on 25/09/2016.
 */
public class Runner {
    public static void main(String[] args) {
        double Sum = 0;
        Scanner sc = new Scanner(System.in);            // Считываем данные с консоли
        while (true) {
            String a = sc.nextLine();                   // Считываем данные построчно
            if (a.equalsIgnoreCase("END")) {            // В случае ввода слова "END" - завершение выполнения программы
                break;
            }
            try {
                double b = Double.valueOf(a);           //Перевод из String в double
                double result = Math.sqrt(b);           //Сумма корней всех ранее введенных чисел
                System.out.println(b + ": " + result);
            } catch (NumberFormatException e) {         //Обработка ошибок
                System.out.println("Введите число: ");

            } catch (Exception e) {
                    System.out.println("Данные введены некорректно: ");
            }
        }
    }
}