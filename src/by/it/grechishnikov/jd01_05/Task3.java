package by.it.grechishnikov.jd01_05;

import static java.lang.Math.*;

public class Task3 {
    public static void print() {
        double x = 3; //Изменил x на 3, т.к. выдавало NaN
        System.out.println("┏━━━━━━━┳━━━━━━━━━━━━━━━━━━━━┓");
        System.out.println("┃ param ┃        value       ┃");
        System.out.println("┣━━━━━━━╋━━━━━━━━━━━━━━━━━━━━┫");
        for(double a = 3.5; a <= 25.5; a += 2.5) {
            double y = asin(x / 3) + (1.2 * a);
            System.out.println(String.format("%-2s%-6s%-2s%-19s%s", "┃", a, "┃", y, "┃"));
        }
        System.out.println("┗━━━━━━━┻━━━━━━━━━━━━━━━━━━━━┛");
    }
}
