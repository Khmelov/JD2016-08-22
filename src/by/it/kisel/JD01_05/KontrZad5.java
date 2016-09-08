package by.it.kisel.JD01_05;

public class KontrZad5 {
    public static void func(){
        double z=0, r=4.73, x=0;
        for (int p = -6; p < 25; p=p+4) {
            if (p+r<0.5) x=Math.pow(Math.sin(r),5);
            if (p+r<3 && p+r>=0.5) x=0;
            if (p+r>3) x=Math.sqrt(r+87.34);
            z=x+Math.pow(Math.E,r)/2;
            System.out.println(z);
        }
    }
}
