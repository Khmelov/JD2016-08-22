package by.it.prymshyts.jd01.jd01_13;

import by.it.prymshyts.jd01.jd01_02.Util;

public class TaskB {

    static void t1() {

        try {
            proc_1();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }


    private static void proc_1() throws Exception {
        System.out.println("Foo 1 started.");

        try {
            doSomething(25);
        } catch (ArithmeticException e) {
            throw new Proc1Exception("Ощибка в первой процедуре.");
        }

        proc_2();

        System.out.println("Foo 1 finished.");
    }

    private static void proc_2() throws Exception {
        System.out.println("Foo 2 started.");

        try {
            doSomething(50);
        } catch (ArithmeticException e) {
            throw new Proc2Exception("Ошибка во второй процедуре.");
        }

        proc_3();

        System.out.println("Foo 2 finished.");
    }

    private static void proc_3() throws Exception {
        System.out.println("Foo 3 started.");

        try {
            doSomething(75);
        } catch (ArithmeticException e) {
            throw new Proc3Exception("Ошибка в третьей процедуре.");
        }

        System.out.println("Foo 3 finished.");
    }

    private static void doSomething(int chancePercent) {
        try {
            int a = Util.getRandomNum(0, 1);
            int b = getZeroByChance(chancePercent);
            int c = a / b;
        } catch (ArithmeticException e) {
            System.err.println("Деление на ноль словлено.");
            throw e;
        }
    }

    private static int getZeroByChance(int chance) {
        switch (chance) {
            case 25:
                return Util.getRandomNum(0, 3);
            case 50:
                return Util.getRandomNum(0, 1);
            case 75:
                return Util.getRandomNum(0, Util.getRandomNum(0, 1));
            case 100:
                return 0;
            default:
                return 1;
        }
    }
}

class Proc1Exception extends Exception {
    public Proc1Exception(String message) {
        super(message);
    }
}

class Proc2Exception extends Exception {
    public Proc2Exception(String message) {
        super(message);
    }
}

class Proc3Exception extends Exception {
    public Proc3Exception(String message) {
        super(message);
    }
}
