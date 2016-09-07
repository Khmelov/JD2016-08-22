package by.it.aborisenok.JD01_05;

/**
 * Created by Лёша on 06.09.2016.
 */
public class Task3 {
    public static void solution() {
        double t =0.1;
        System.out.println("|-------|-----------|");
        System.out.println("| param |   value   |");
        System.out.println("|-------|-----------|");
        for(double a = 2; a <= 3; a += t) {
            double y = Math.log(Math.abs(1.3 + t)) - Math.pow(Math.E,t);
            System.out.println(String.format("%s %+.2f %s %+7.6f %s", "|", a, "|", y, "|"));
        }
        System.out.println("|-------|-----------|");
    }
}
