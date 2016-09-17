package by.it.opiga.JD01_06;

/**
 * Created by user on 02.09.2016.
 */
public class Runner {

    public static void main(String[] args) {
        System.out.println(Data.luk);

        System.out.println("\n Задание 1А \n");
        System.out.println(TaskA.z1(Data.luk));

        System.out.println("\n Задание 2А \n");
        TaskA.z2(Data.luk);

        System.out.println("\n Задание 3А \n");
        TaskA.z3(Data.luk);

        System.out.println("\n Задание 1В \n");
        System.out.println(TaskB.z4(Data.luk));

        System.out.println("\n Задание 2В \n");
        TaskB.z5(Data.luk);

        System.out.println("\n Задание 3В \n");
        TaskB.z6(Data.luk);

        System.out.println("\n Задание 3C \n");
        TaskC.z7(Data.luk);
    }
}
