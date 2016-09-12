package by.it.kisel.JD01_05;


public class KontrZad4 {
    public static void proizved(){
        double u=1;
        for (int i = 12; i <= 43; i++) {
            for (double t = 2; t <= 3; t=t+0.1) {
                u*=Math.pow(t,Math.E-3);
                System.out.println(u);
            }
        }
    }
}
