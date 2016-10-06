package by.it.shkantau.jd01.jd01_05;

import static java.lang.Math.*;

public class Task3 {
    public static void task3(double min, double max, double step) {
        int stepCount = (int)((max-min)/step);
        double s;
        System.out.println("Task3");
        System.out.println("┏━━━━┳━━━━━━━━━━━┓");
        System.out.println("┃ arg   ┃      result       ┃");
        System.out.println("┣━━━━╋━━━━━━━━━━━┫");
        for (int i = 0; i <= stepCount ; i++) {
            s = log(1.3+(min + i*step)) - pow(E, min + i*step);
            System.out.printf("%-2s%6s%-2s%-18.15s%s\n", "┃", min +i*step, "┃", s, "┃");
        }
        System.out.println("┗━━━━┻━━━━━━━━━━━┛");
    }
}
