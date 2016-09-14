package by.it.dubatovka.jd01_06;

/**
 * Created by Dubatovka Sergey on 13.09.2016.
 */
public class Runner {
    public static void main(String[] args) {
        String s = RuslanLudmila.dubzelenij;

        System.out.println("//Задание А1");
        ZadanieA1.zamenaSimvolov5i7(s);

        System.out.println();
        System.out.println("//Задание А2");
        ZadanieA2.povtorSlov(s);

        System.out.println();
        System.out.println("//Задание А3");
        ZadanieA3.poiskSlov(s);

        System.out.println("\n//Задание B1");
        ZadanieB1.soglasnaya(s);
    }
}
