package by.it.dubatovka.jd01_02;

import java.util.Scanner;

public class Runner {

    public static void main(String[] args) {
        System.out.print("ЗАДАНИЕ JD01_02A:" + '\n' + "Введите числа через пробел: ");
        //String line = "-1 -2 15";
        String line = Util.getLineConsole();
        int[] mas = Util.getIntArray(line);

        String arrStr[] = line.split(" ");
        String maxString = TaskA.maxLength(arrStr);
        String minString = TaskA.minLength(arrStr);

        System.out.println("Самое длинное число: " + maxString);
        System.out.println("Его длина: " + maxString.length());
        System.out.println("Самое короткое число: " + minString);
        System.out.println("Его длина: " + minString.length());

        double mean = TaskA.mean(mas);
        System.out.println("Среднее арифметическое число: " + mean);

        System.out.print("ДЛИНА этих чисел меньше чем " + mean + ": ");
        for (String s : arrStr) {
            if (s.length() < mean) System.out.print(s + " ");
        }
        System.out.println();
        for (int i : mas) {
            if (TaskA.uniqe(i)) {
                System.out.println("Число " + i + " состоит из разных чисел");
                break;

            }

        }

        //Задание JD01_02(B)
        //1.Определить принадлежность числа некоторого значения k интервалу [n,m]
        System.out.println();
        System.out.println('\n' + "ЗАДАНИЕ JD01_02(B):" + '\n');
        int k = 14;
        int n = 4;
        int m = 15;

        if (n <= m) {                                   //проверка интервала, если задан по возрастанию
            if (n <= k && k <= m) {
                System.out.println("Ответ: Число " + k + " входит в заданный интервал [" + n + "," + m + "]");
            } else System.out.println("Ответ: Число " + k + " не входит в заданный интервал [" + n + "," + m + "]");
        } else if (m <= k && k <= n) {                  //если интервал задан в обратном порядке (по убыванию чисел)
            System.out.println("Ответ: Число " + k + " входит в заданный интервал [" + n + "," + m + "]");
        } else System.out.println("Ответ: Число " + k + " не входит в заданный интервал [" + n + "," + m + "]");


        //2. Вывести числа от 1 до k в виде матрицы NxN слева направо и сверху вниз
        System.out.println();
        int kk = 49;
        System.out.println("2. Вывести числа от 1 до k в виде матрицы NxN слева направо и сверху вниз" + '\n' + "Число k=" + kk);
        int count = 0;
        int s = 1;

        for (int i = 0; kk > i * i; i++) {
            count++;
        }
        do {
            for (int i = 0; i < count; i++) {
                if (s <= kk) {
                    System.out.print('\t' + "" + s);
                }
                s++;
            }
            System.out.println();
        }
        while (s <= kk);

        //3. Найти корни квадратного уравнения
        System.out.println();
        System.out.println("3. Найти корни квадратного уравнения ax2 + bx + c =0." + '\n' + "Введите коэффициенты a, b, c через пробел:");
        // String abc = "-1 -2 15";
        String abc = Util.getLineConsole();
        int mas1[] = Util.getIntArray(abc);
        double[] x = TaskB.kvadrUravn(mas1);    //корни квадратного уравнения {x0,x1,x2} где x0-первый корень, x1-второй корень, x2- количество корней уравнения.

        System.out.println();
        switch ((int) x[2]) {
            case 0:
                System.out.println("Данное квадратное уравнение не имеет решений");
                break;
            case 1:
                System.out.println("Корень квадратного уравнения равен x=" + x[0]);
                break;
            case 2:
                System.out.println("Корни квадратного уравнения:" + '\n' + "x1=" + x[0] + '\n' + "x2=" + x[1]);
                break;
        }

        //4. Ввести число от 1 до 12. вывести на консоль название месяца.

        System.out.println('\n' + "4. Ввести число от 1 до 12. вывести на консоль название месяца.");

        int nomerMonth = 4;
        String month = TaskB.month(nomerMonth);
        System.out.println("Числу " + nomerMonth + " соответствует месяц: " + month);

        //Задание JD01_02(C)
        //Ввести с консоли n- размерность матрицы а[n][n]
        System.out.print('\n' + "Задание JD01_02(C)" + '\n' + "Введите число n - размер матрицы a[n][n]: ");

        Scanner scanner = new Scanner(System.in);
        int nn = scanner.nextInt();
        System.out.println();

        //печатаем матрицу
        //  int nn = 6;
        System.out.println("Замолняем матрицу Random из диапазона -n,n");
        int[][] a = TaskC.randMatrixNN(nn);

        Util.printMatrix(a);
        System.out.println();

        // Найти сумму  элементов матрицы, расположенных между первыми и вторыми положительными элементами каждой строки

        int sss = TaskC.sumElem(a);
        System.out.println("Сумма  элементов матрицы, расположенных между первыми и вторыми положительными элементами каждой строки:" + '\n' + "RESULT=" + sss);
        System.out.println();

        //транспонированная матрица
        int[][] b = TaskC.matrixT(a);
        System.out.print("2. Транспонированная матрица a[][]:");
        Util.printMatrix(b);
        System.out.println();

        //повернули транспонированную матрицу
        int c[][] = TaskC.povorot90GradProtiv(b);
        System.out.print("3. Повернули против часовой стрелки ТРАНСПОНИРОВАННУЮ матрицу b[][]:");
        Util.printMatrix(c);
        System.out.println();

        // построили матрицу, вычитая из элементов каждой строки матрицы ее среднее арифметическое
        double d[][] = TaskC.matrixMinusSredArifmStoki(c);
        System.out.println();
        System.out.println("4.Построили матрицу, вычитая из элементов каждой строки матрицы ее среднее арифметическое(строки) ,");
        System.out.println("Работаем над последней, повернутой матрицей");
        for (int i = 0; i < a.length; i++) {
            System.out.println();
            for (int j = 0; j < a.length; j++) {
                if (d[i][j] >= 0) System.out.print(" ");
                System.out.print(d[i][j] + " ");
            }
        }
        //удалить строки и столбцы с максимумами
        System.out.println();
        System.out.println();

        System.out.println("5.Вывести матрицу с удаленными строками и столбцами содержавшие макс число");
        System.out.println("Исходная матрица a[n][n]");
        Util.printMatrix(a);
        System.out.println();

        int[][] e = TaskC.test(a);
        System.out.println("Предварительная таблица, перед удалением Строк и Столбцов:");
        System.out.print("В ней числом max+1  отмечены строки и столбцы, которые удаляться");
        Util.printMatrix(e);

        System.out.println();
        System.out.print("5.Выводим матрицу с удаленными строками и столбцами содержавшие макс число");
        int f[][] = TaskC.udalitStrKolMax(c);
        Util.printMatrix(f);

        System.out.println();
        System.out.print("Оставшиеся две задачи из JD01_02(С) скоро доделаю, На пятую из (С) все силы ушли :)");

        System.out.println();
        System.out.println("6.В матрице найти минимальный элемент и переместить его на место [1,1] путем перестановки строк и столбцов");
        System.out.println("ИСХОДНАЯ МАТРИЦА а[][]:");
        Util.printMatrix(a);
        System.out.println();

        System.out.print("РЕЗУЛЬТАТ. Матрица с переставленным в позицию 1,1 минимумом:");
        System.out.println("Между собой сразу переставились строки номер 1 и с строка с минимумом");
        System.out.println("затем столбец номер 1 и столбец с минимумом:");
        int g[][]=TaskC.minPerestavit11(a);
        Util.printMatrix(g);
        System.out.println();

        System.out.print("7. Преобразовать строки матрицы таким образом,");
        System.out.println("чтобы элементы равные нулю, распологались после всех остальных.");
        System.out.println("Используем последнюю матрицу, с минимумом в 1,1. Результат ниже: ");

        int h[][]=TaskC.nuliPostavitVkonec(g);
        Util.printMatrix(h);
        System.out.println();
    }

        // 4 ночи пора поспать :))
}
