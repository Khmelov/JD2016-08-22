package by.it.kisel.JD01_05;

public class KontrZad3 {
    public static void Tabul(){
        double x = 3.67;
        double y = 0;
        for (double c = -10; c <= 1; c=c+1.25) {
            y = Math.pow(Math.abs(2*x-c),3/5)+0.567;
            System.out.println("y = " + y);
        }
    }
}
