package by.it.aborisenok.JD01_05;

/**
 * Created by Лёша on 08.09.2016.
 */
public class Task5 {
    public static void solution(){
        System.out.println("Task 5");
        double r = 4.73;
        for (double p = -8; p < 22; p+=3.5) {
            double x = 0;

            if ((p + r) < 0.5) {
                x = Math.pow(Math.sin(p), 5);
            }
            if ((p + r) >= 0.5 && (p + r) < 3) {
                x = Math.pow(Math.E, Math.abs(p + 3));
            }
            if ((p + r) > 3) {
                x = Math.sqrt(Math.abs(Math.pow((p + 7),5)));
            }

            double z =2*x + Math.pow(Math.E, r)/2;

            System.out.printf("Pезультат z = %.2f  т.к p = %.1f \n", z, p);
        }

    }

}
