package by.it.opiga.JD01_02;

public class TaskA {

    static int[] lineToIntArray(String line) {

        String[] strArray = line.split(" ");
        int[] mas = new int[strArray.length];
        for (int i = 0; i < strArray.length; i++) {
            mas[i] = Integer.parseInt(strArray[i]);
        }
        return mas;
    }

    static String getMax(int[] mas) {
        Integer max = Integer.MIN_VALUE;
        for (int i : mas) {
            if (i > max) {
                max = i;
            }
        }
        return "Max = " + max + " length = " + max.toString().length();

    }

    static String getMin(int[] mas) {
        Integer min = Integer.MAX_VALUE;
        for (int i : mas) {
            if (i < min) {
                min = i;
            }
        }
        return "Min = " + min + " length = " + min.toString().length();
    }

    static double getMean(int[] mas) {
        double res;
        int sum = 0;
        for (int i : mas) {
            sum = i + sum;
        }
        res = sum / mas.length;
        System.out.println("Среднее чисел = " + res);
        return res;
    }

    //Проверка на различность цифр у числа
    static boolean getDiffNum(Integer num) {
        char ch[] = num.toString().toCharArray();
        for (int i = 0; i < ch.length; i++) {
            for (int j = i + 1; j < ch.length; j++) {
                if (ch[i] == ch[j])
                    return false;

            }
        }
        return true;
    }
    static void test(){
        int f = 0;
        while (f < 5) {
            f++;
        }
        do {
            f++;
        }while(f<8);
    }


}


