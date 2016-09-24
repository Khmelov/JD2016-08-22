package by.it.dubatovka.jd01_13;

import by.it.dubatovka.jd01_02.TaskA;
import by.it.dubatovka.jd01_02.Util;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Dubatovka Sergey on 23.09.2016.
 */
class TaskA_1 {

    public String GetConsole() {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine().trim();
        //scanner.close();
        return line;
    }


    static void aException() throws ArithmeticException {
        System.out.println("Открыли консоль;\n" +
                "считываем данные из консоли построчно:" +
                "переводит каждую строку в число и выводит в консоль данное число и сумму корней всех\n" +
                "ранее введенных чисел, включая введенное;\n" +
                "если перевести ввод в число невозможно или невозможно извлечь корень, то программа\n" +
                "обрабатывает ошибку и показывает на русском языке соответствующее сообщение в\n" +
                "консоли;\n" +
                "закрывается при вводе в консоль слова END.\n");
        System.out.print("Введите данные:");
        String lineConsole = "";

        double y = 0;

        while (!lineConsole.equals("END")) {
            lineConsole = new TaskA_1().GetConsole();
            if (lineConsole.equals("END")) break;
            try {
                Double x = Double.parseDouble(lineConsole);
                if (0 <= x) {
                    y = y + Math.sqrt(x);
                    System.out.print("Данное число: " + x + ", " + " Cумма корней: " + y);
                } else {
                    throw new ArithmeticException();
                }
            } catch (NumberFormatException e) {
                System.err.println("Некорректно введено число: " + lineConsole + " | " + e);
            } catch (ArithmeticException e) {
                System.err.println("Корень из отрицательного числа: " + lineConsole + " | " + e);
            }finally {
                System.out.println("Введите число заново: ");
            }
        }
        Scanner scanner = new Scanner(System.in);
        scanner.close();
    }
}
