package by.it.kisel.JD01_05;

public class Runner {
    public static void main(String[] args) {
        System.out.println("    Задание 1");
        System.out.println("Значение выражения : "+KontrZad1.polnV());
        System.out.println("Значение выражения c разбивкой : "+KontrZad1.razbV());
        System.out.println("    Задание 2");
        System.out.println("Значение выражения при заданных a и b : "+KontrZad2.zad());
        KontrZad2.vvod();
        System.out.println("    Задание 3");
        KontrZad3.Tabul();
        System.out.println("    Задание 4");
        KontrZad4.proizved();
        System.out.println("    Задание 5");
        KontrZad5.func();
    }
}
