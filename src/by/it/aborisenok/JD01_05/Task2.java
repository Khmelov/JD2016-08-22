package by.it.aborisenok.JD01_05;

/**
 * Created by Лёша on 06.09.2016.
 */
public class Task2 {
    public static void solution(double a, double x) {

        double z = -Math.sqrt((x*Math.pow(a, 3))) + Math.log(Math.abs((a - 1.2*x)/4));
        System.out.printf("Результат Task 2 = %.2f \n", z);
    }
}
