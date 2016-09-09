package by.it.opiga.JD01_05;
import static java.lang.Math.pow;
/**
 * Created by Asus on 04.09.2016.
 */
public class Main {
    public static void main(String[]args)
    {
        //задача 1 8 вариант
        System.out.println("1 method y = "+Task1.part(0.3,-21.17));
        System.out.println("2 method y = "+Task1.whole(0.3,-21.17));

        //задача 2
        double x=2.57*Math.pow(10,3);
        double f=0.873;
        System.out.println(Task2.findY(x,f));
        System.out.println(Math.round(Task2.findY(x,f)));
        System.out.println(Math.ceil(Task2.findY(x,f)));
        System.out.printf("%e \n",Math.ceil(Task2.findY(x,f)));

        //задача 3
        Task3.printY();
    }

}
