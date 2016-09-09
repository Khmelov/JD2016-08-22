package by.it.dubatovka.jd01_05;

import static java.lang.Math.*;

/**
 * Created by Dubatovka Sergey on 07.09.2016.
 */
public class Task_3 {


    public static void task3() {

        double x = 12.1;
        double deltaC = 0.5;

        System.out.println("----------------------------");
        System.out.println("|   c   |      Результат   |");
        System.out.println("----------------------------");

        for (double c = -10; c <= 1; c += deltaC) {

            double modul = abs(2 * x - c);
            double a = pow(pow(modul, 3), 1 / 5);
            double y = a + 0.567;

            System.out.print("| ");
            System.out.printf("%5.1f", c);
            System.out.print(" | ");
            System.out.printf("%16.10f", y);
            System.out.print(" |");
            System.out.println();
        }
        System.out.println("----------------------------");
    }
}
