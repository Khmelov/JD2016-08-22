package by.it.dubatovka.JD01.jd01_05;

/**
 * Created by Dubatovka Sergey on 08.09.2016.
 */

import static java.lang.Math.*;

public class Task_5 {
    public static void task_5() {

        double lambda = 0;
        System.out.println("Заменил функцию arcsin(x) на sin(x), arcsin (x) вычисляется только в диапазоне -1<x<1");
        System.out.println();

        for (double x = -1.8; x < 0.3; x += 0.2) {
            double n = x * x;

            if (-2 < x && x <= -1) {
                lambda = sin(n);
            }
            if (-1 < x && x < 0.2)
                lambda = acos(n);
            if (0.2 == x)
                lambda = atan(n);

            if (lambda > 0) {
                double y = lambda / 3 + sqrt(lambda);
                System.out.printf("%-3s%-4.1f%-6s%-8.3f", "x=", x, "--> y=", y);

            } else
                System.out.printf("%-3s%-4.1f%-6s%-60s", "x=", x, "--> ", "lambda<0, выражение sqrt(lambda) решений не имеет");
            System.out.println();

        }
    }
}
