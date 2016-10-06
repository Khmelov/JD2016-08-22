package by.it.opiga.JD01_13;

/**
 * Created by Asus on 04.10.2016.
 */
public class TaskB {
    private static int div = 0;
    private static int a = (int) (Math.random() * 5 - 5);
    private static int b = 0;
    private static int mas[] = new int[4];

    public static void main(String[] arg) {
        try {
            procedure1();
        } catch (Exception e) {
            System.out.println("other exception " + e.getMessage());
        }
    }


    public static void procedure1() throws Exception {
        try {
            calc1();

        } catch (ArithmeticException e) {
            System.out.println("Деление на нуль #1 " + e.getMessage());
        }
        calc2();
        procedure2();
    }

    public static void procedure2() throws Exception {
        try {
            calc1();

        } catch (ArithmeticException e) {
            System.out.println("Деление на нуль #2 " + e.getMessage());
        }
        calc2();
        procedure3();
    }

    public static void procedure3() throws Exception {
        try {
            calc1();

        } catch (ArithmeticException e) {
            System.out.println("Деление на нуль #3" + e.getMessage());
        }
        calc2();
    }

    public static void calc1() {
        div = a / b;
    }

    public static void calc2() {
        for (int i = 0; i < 5; i++)
            mas[i] = div;
    }
}
