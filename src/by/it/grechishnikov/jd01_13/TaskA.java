package by.it.grechishnikov.jd01_13;

import java.util.*;

public class TaskA {
    static void start() {
        Scanner scanner = new Scanner(System.in);
        double sqrtSum = 0;
        while(true) {
            String s = scanner.nextLine();
            if(s.equalsIgnoreCase("end")) {
                break;
            }
            try {
                double d = Double.parseDouble(s);
                if(d < 0) {
                    throw new ArithmeticException();
                }
                sqrtSum += Math.sqrt(d);
                System.out.println(d + " : " + sqrtSum);
            } catch (NumberFormatException e) {
                System.err.println("Введите число:");
            } catch (ArithmeticException e) {
                System.err.println("Введите число больше нуля:");
            }
        }
        System.out.println("Сумма всех корней: " + sqrtSum);
        scanner.close();
    }
}
