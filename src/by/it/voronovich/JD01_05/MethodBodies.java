package by.it.voronovich.JD01_05;

/**
 * Класс содержит тела методов для проведения операций с различными математискими функциями
 *
 * @author Voronovich Dmitry
 * @version 1.0
 */

public class MethodBodies {

    /**
     * Метод вычисляет значения выражения первого задания
     *
     * @param a входное значение переменной a метода
     * @param x входное значение переменной x метода
     * @return возращеет в метод результат в виде строки
     */
    protected static String taskOne(double a, double x) {

        double zFull = 0;
        double zParts = 0;
        double z1 = 0;
        double z2 = 0;
        double z3 = 0;

        z1 = Math.atan(Math.pow(x, 2));
        z2 = Math.sqrt((x + Math.pow(1.43, 3)));
        z3 = Math.pow(Math.cos(Math.PI / (2 * a)), 3) / Math.abs(x - Math.pow(a, 0.2));
        zParts = z1 - z2 + z3;
        zFull = Math.atan(Math.pow(x, 2)) - Math.sqrt((x + Math.pow(1.43, 3))) + Math.pow(Math.cos(Math.PI / (2 * a)), 3) / Math.abs(x - Math.pow(a, 0.2));
        return "Результаты вычисления выражения записанного по частям и сразу соответственно равны:" + zParts + " и " + zFull;
    }

    /**
     * Метод вычисляет значения выражения второго задания
     *
     * @param x входной параметр функции
     * @return возвращает значение выражения
     */
    protected static double taskTwo(double x) {

        double y = 0;
        y = (Math.pow(Math.sin(x + 1), 2) + x * Math.pow((3 + Math.pow(x, 2)), 0.25)) / Math.atan(x / 2);
        return y;
    }

    /**
     * Метод вычисляет значения выражения третьего задания
     *
     * @param x входной параметр функции
     */
    protected static void taskThree(double x) {

        double y = 0;
        double a = 0;
        for (a = 3.5; a <= 25.5; a += 3.75) {
            y = (1.0 / Math.tan(Math.pow(x, 3))) + (2.24 * a * x);
            System.out.printf("a = %5.2f ---> y = %5.2f ", a, y);
            System.out.println(" ");
        }
    }

    /**
     * Метод вычисляет значения выражения четвертого задания
     *
     * @param a входной параметр функции
     */
    protected static void taskFour(double a) {

        double z = 0;
        double c = 0;
        double b = 0;

        for (b = 2e-1; b <= 4e-1; b += 2e-2) {
            b = b * 100;
            b = Math.round(b);
            b = b / 100;
            double g = 0;
            for (c = 1; c <= 12; c++) {
                g += c - b;
            }
            z = 1.38 * a + g;
            System.out.printf("b = %5.2f ---> z = %5.2f ", b, z);
            System.out.println(" ");
        }
    }

    /**
     * Метод вычисляет значения выражения пятого задания
     *
     * @param r входной параметр функции
     */
    protected static void taskFive(double r) {
        double z = 0;
        double x = 0;
        double p = 0.5;
        do {
            p += 3.5;
            if (p > 20)
                break;
            if (Math.pow(p, 2) < 5) {
                x = Math.pow(Math.sin(p), 5);
            } else if (Math.pow(p, 2) >= 5 && Math.pow(p, 2) < 13) {
                x = Math.pow(7, p + 3);
            } else if (Math.pow(p, 2) > 13) {
                x = Math.log1p(Math.abs(Math.pow(p+4.7,5)));
            }
            z = x+r/2;
            System.out.printf("z = %7.2f при p2 = %5.2f ", z, Math.pow(p,2));
            System.out.println(" ");
        }
        while (p > 0.5 && p < 20);
    }

    /**
     * @param name входящее значение строки
     */
    protected static void taskSix(String name, String name1) {
        double v = 0;
        int count = 0;
        double c = -1.5;
            do {
                c += 0.2;
                if(c>6) {
                    break;
                }
                c = c * 10;
                c = Math.round(c);
                c = c / 10;
                count++;
            }
            while(c<6);

        double arr[] = new double[count];
        int a = 0;
        for (c = -1.5+0.2; c < 6; c += 0.2) {
            c = c * 10;
            c = Math.round(c);
            c = c / 10;

                v = 7.28/(c+4);
                arr[a] = v;
                a++;
            }
        System.out.print("Массив элементов, сформированных из результатов вычисления функции");
        int column = 0;
        for (int i = 0; i < count; i++) {

            if (column % 4 == 0) {
                System.out.println(" ");
            }
            System.out.printf("%4s[%2s] = %6.2f || ", name, i, arr[i]);
            column += 1;
        }

        double multiply = 1;
        for (int i = 0; i < count; i++) {
            if(i%2==0){
                multiply*=arr[i];
            }
        }
        System.out.println(" ");
        System.out.printf("Произведение элементов, имеющих четный индекс: %4.2f ", multiply);

        int count1 = 0;
        for (double i : arr) {
            if(i>2){
                count1++;
            }
        }

        int u = 0;
        double arrNew[] = new double[count1];
        for (int i = 0; i < count; i++) {
            if(arr[i]>2){
                arrNew[u]=arr[i];
                u++;
            }
        }
        System.out.println(" ");
        System.out.print("Массив элементов, сформированный из элементов, значения которых больше 2");
        int column1 = 0;
        for (int i = 0; i < count1; i++) {
            if (column1 % 2 == 0) {
                System.out.println(" ");
            }
            System.out.printf("%4s[%1s] = %6.2f || ", name1, i, arrNew[i]);
            column1 ++;
        }



    }

    protected static void taskSeven() {

        double arrM[] = new double[24];
        for (int i = 0; i < 24; i++) {
            double random = -7 + (Math.random() * (45 -(- 7)));
            random = random * 10;
            random = Math.round(random);
            random = random / 10;
            arrM[i] = random;
        }
        System.out.print("┏-━-━--━-┳-┳-━--━-━-┳-┳━-━--━━┳-┳-━━--━━┓");
        int column2 = 0;
        for (int i = 0; i < 24; i++) {
            if (column2%4 == 0){
                System.out.println(" ");
            }
            System.out.printf("┃M[%2s]=%4.1f┃ ", i, arrM[i]);
            column2++;
        }
        System.out.println(" ");


        int count = 0;
        for (int i = 0; i < 24; i++) {
            if (Math.abs(arrM[i]) > i) {
                count++;
            }
        }

        double arrB[] = new double[count];
        int l = 0;
        for (int i = 0; i < 24; i++) {
            if (Math.abs(arrM[i]) > i) {
                arrB[l] = arrM[i];
                l++;
            }
        }

        for (int i = count - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arrB[j] > arrB[j + 1]) {
                    double g = arrB[j + 1];
                    arrB[j + 1] = arrB[j];
                    arrB[j] = g;
                }
            }
        }

        System.out.println("┏-━-━--━-╋-╋-━--━-━-╋-╋-━--━━━╋-╋━-━--━━┫");
        for (int i = 0; i < 5; i++) {
            for (int j = i; j < count; j+=5) {
                System.out.printf("┃B[%2s]=%4.1f┃ ", j, arrB[j]);
            }
            System.out.println(" ");
        }
        System.out.print("┗-━-━--━-┻-┻-━--━-━-┻-┻━-━--━━┛");
    }
}
