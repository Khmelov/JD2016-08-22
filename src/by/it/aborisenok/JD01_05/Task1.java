package by.it.aborisenok.JD01_05;

/**
 * Created by Лёша on 06.09.2016.
 */
public class Task1 {
    public static void partSolution(double a, double b){

        // step 1
        double step1 = Math.pow((a + b), 2);
        // step 2
        double step2 = Math.tan(step1);
        // step 3
        double step3 = Math.pow((a + 1.5), 1/3);
        // step 4
        double step4 = a*Math.pow(b, 5);
        // step 5
        double step5 = b/(Math.log(a*a));
        // final step
        double y = step2 - step3 + step4 - step5;
        System.out.printf("Результат Task1 c разбивкой = %.2f \n", y);

    }
    public static void fullSolution(double a, double b){

        double y = Math.tan(Math.pow((a + b),2)) - Math.pow((a + 1.5), 1/3) + a*Math.pow(b, 5) -  b/(Math.log(a*a));
        System.out.printf("Результат Task1 полныи выражением = %.2f \n", y);
    }
}
