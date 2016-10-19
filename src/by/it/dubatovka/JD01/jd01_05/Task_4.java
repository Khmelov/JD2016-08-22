package by.it.dubatovka.JD01.jd01_05;

/**
 * Created by Dubatovka Sergey on 07.09.2016.
 */

import static java.lang.Math.*;

public class Task_4 {

    public static void task_4() {

        for (double t = 2; t <= 3; t = t + 0.1) {
            double m = 1;
            for (int d = 23; d <= 39; d++)
                m *= log10(abs(d - t));

            System.out.printf("%-2s%-4.1f%-7s%-8.3f", "t=", t, " -->  m=", m);
            System.out.println();
        }
    }
}