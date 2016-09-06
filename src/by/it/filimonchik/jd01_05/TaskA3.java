package by.it.filimonchik.jd01_05;

import static java.lang.Math.cos;
import static java.lang.Math.pow;
import static java.lang.Math.sin;

/**
 * Created by Raman.Filimonchyk on 06.09.2016.
 */
public class TaskA3 {
    public static void Table() {
        double x = 3.567;
        System.out.println("┏━━━━━━━━┳━━━━━━━━━━━━━━━━━━━━━━━━┓");
        System.out.println("┃ param ┃        value       ┃");
        System.out.println("┣━━━━━━━━╋━━━━━━━━━━━━━━━━━━━━━━━┫");

        for (double a = -5; a <= 12; a += 2.5) {
           double y = cos(pow(x, 3)) / sin(pow(x, 3)) + 2.24 * a * x;
            System.out.println(String.format("%-2s%-6s%-2s%-19s%-22s", "┃", a, "┃", y, "┃") );
        }
        System.out.println("┗━━━━━━━━┻━━━━━━━━━━━━━━━━━━━━━━━┛");
    }
}
