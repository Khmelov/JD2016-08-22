package by.it.zaharova;

public class Main {

    public static void main(String[] args) {
        System.out.println("Задание 1");
        System.out.println("Значение выражения: "+ TaskA.Z());
        System.out.println("Значение выражения: "+ TaskA.PolnZ());

        /////////////////////////////////////////////////////

        System.out.println("Задание 2");
        System.out.println("Значение выражения: "+TaskA.ZapolnZ());
       TaskA.In();

        /////////////////////////////////////////////////////

        System.out.println("Задание 3");
        TaskA.Tabl();
        ///////////////////////////////////////////////////////

        System.out.println("Задание Б");
        System.out.println("Произведение: ");
        TaskB.Proizv();

        //////////////////////////////////////////////////////
        System.out.println("Задание 2");
        System.out.println("Произведение: ");
        TaskB.Urav();

    }
}
