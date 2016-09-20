package by.it.grechishnikov.jd01_13;

public class TaskB {
    static void start() {
        try {
            f1();
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }

    private static void f1() throws InterruptedException{
        System.out.println("Start in f1");
        f2();
        System.out.println("End in f1");
    }

    private static void f2() throws InterruptedException {
        System.out.println("Start in f2");
        try {
            if (System.currentTimeMillis() % 2 == 0) {
                int i = 2 / 0;
            }
        } catch (ArithmeticException e) {
            System.out.println("Деление на 0");
        }
        f3();
        System.out.println("End in f2");
    }

    private static void f3() throws InterruptedException {
        System.out.println("Start in f3");
        if(true) throw new InterruptedException();
        System.out.println("End in f3");
    }
}
