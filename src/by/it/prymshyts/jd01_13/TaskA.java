package by.it.prymshyts.jd01_13;

import by.it.prymshyts.jd01_02.Util;

public class TaskA {

    static void t1() {

        String str;
        Double num;
        Double sqrtSum = 0.0;

        System.out.println("Введите END для завершения.");

        while (true) {
            try {
                System.out.print("Введите число не меньше нуля: ");
                str = Util.getConsoleLine();

                if (str.equals("END")) {
                    System.out.println("Завершение программы.");
                    break;
                }

                num = getNumFromString(str);

                if (num < 0) {
                    throw new NumberLessThenZeroException();
                }

                sqrtSum += Math.sqrt(num);
                System.out.println("Число = " + num);
                System.out.println("Сумма корней всех чисел: " + sqrtSum);

            } catch (NumberLessThenZeroException e) {
                System.err.println("Введённое число меньше нуля.");
            } catch (NumberFormatException e) {
                System.err.println("Введённая строка не является числом.");
            }
        }
    }

    private static Double getNumFromString(String str) throws NumberFormatException {
        return new Double(str);
    }
}

class NumberLessThenZeroException extends ArithmeticException {
}
