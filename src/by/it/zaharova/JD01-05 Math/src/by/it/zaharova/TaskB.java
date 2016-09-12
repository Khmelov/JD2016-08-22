package by.it.zaharova;


public class TaskB {
    public static void Proizv() {
        double k = 1;
        for (int i = 2; i <= 8; i++) {
            for (double a = 0; a <= 2; a += 0.2) {


                k = Math.pow(Math.E, i) - 2.11 * a;
                System.out.println(k);
            }

        }

    }

    ////////////////////////////////////////

    public static void Urav(){
        double m =0;
        double b =0;
        for (double x = -0.4; x <0.2 ; x+=0.1) {
            if(x>=0.5 && x<=-0.25){
                b=Math.pow(Math.sin(x+1),3);}
            if(x>= -0.25 && x<= 0.05){
                b=Math.cos(x*x + Math.pow(3.12,0.3));}
            if(x>0.05){
                b=Math.pow(Math.tan(x),4);
            }

            m= Math.pow(Math.abs(5*Math.pow(b,6)),1/3) + Math.pow(Math.E,Math.abs(b-2.04));
            System.out.println(m);
        }
    }
}
