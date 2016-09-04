package by.it.dubatovka.jd01_02;


import java.util.Random;

public class TaskC {

    public static int[][] randMatrixNN(int nn) { //создаем матрицу размером nn х nn, заполняем рандомом от -nn до nn

        int[][] a = new int[nn][nn];
        Random random = new Random();
        for (int i = 0; i < nn; i++) {
            for (int j = 0; j < nn; j++)
                a[i][j] = random.nextInt(2 * nn + 1) - nn;
        }
        return a;
    }

    public static int sumElem(int a[][]) {
        int sss = 0;
        for (int i = 0; i < a.length; i++) {
            int counter = 0;
            // System.out.println("sss1=" + sss1);
            int sss1 = 0;

            for (int j = 0; j < a.length; j++) {
                if (a[i][j] >= 0) counter++;
                if (counter == 2) {
                    sss = sss + sss1;
                    break;
                }
                if (1 == counter && a[i][j] < 0) sss1 = sss1 + a[i][j];
            }
        }
        return sss;
        //System.out.println("sss1=" + sss1);
    }

    public static int[][] matrixT(int[][] a) {
        int[][] b = new int[a.length][a.length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                b[j][i] = a[i][j];
            }
        }
        return b;
    }

    public static int[][] povorot90GradProtiv(int a[][]) {
        int b[][] = new int[a.length][a.length];
        for (int i = 0; i < a.length; i++) {
            for (int j = a.length-1; j >= 0; j--)
                b[a.length - 1 - j][i] = a[i][j];
        }
        return b;
    }

    public static double[][] matrixMinusSredArifmStoki(int a[][]) {
        double b[][] = new double[a.length][a.length];
        for (int i = 0; i < a.length; i++) {
            double sum = 0;
            for (int j = 0; j < a.length; j++) {
                sum = sum + a[i][j];
                if (j < a.length) continue;
            }  //продолжаем цикл (суммируем элементы строки), пока не дойдем до конца строки
            for (int k = 0; k < a.length; k++)
                b[i][k] = (double) a[i][k] - sum / a.length;
        }
        return b;
    }

    public static int[][] udalitStrKolMax(int a[][]) {
        //ищем максимум
        int[][] b = new int[a.length][a.length];
        int max = Integer.MIN_VALUE;    //max значение в матрице


        //ищем максимум
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                if (a[i][j] > max) max = a[i][j];
            }
        }
        int index = max + 1;            //метка INDEX. Буду помечать  строки и столбцы которые надо будет удалить (+1 к максимуму чтобы эта цифра не входила в диапазон чисел матрицы )

        //перебираем массив а[][] и записываем b[][], помечая все строки  и столбцы, которые надо удалить INDEX-ом
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                //если максимум, то в массив b[][]записываем index
                if (a[i][j] == max) {
                    for (int x = 0; x < a.length; x++) {
                        b[i][x] = index;
                        b[x][j] = index;
                    }
                }
                if (b[i][j] != index)
                    b[i][j] = a[i][j]; //если записывали index, значит столбец занулен и переносить a[i][j] нельзя
            }
        }

        //считаем количество строк и столбцов помеченные в b[][] index-м. пробегаем только
        int col = 0;
        int str = 0;
        for (int i = 0; i < b.length; i++) {
            if (col > 0) break;                   //выходим из цикла, потому что уже посчитали размер будущей матрицы c
            for (int j = 0; j < b[i].length; j++) {
                if (col > 0) break;                //выходим из цикла, потому что уже посчитали размер будущей матрицы c
                if (b[i][j] != index) {
                    for (int x = 0; x < b.length; x++) {
                        if (b[i][x] != index) col++;
                        if (b[x][j] != index) str++;
                    }
                }
            }
        }

        //создаем массив с[][] окончательного размера и переносим значения из b[][], которые не равны index
        int c[][] = new int[str][col];

        //записываем элементы из b[][] в c[][] непомеченные index
        int w = 0;
        for (int i = 0; i < b.length; i++) {
            int z = 0;
            for (int j = 0; j < b.length; j++) {
                if (b[i][j] == index) z++;
                else c[i - w][j - z] = b[i][j];
                if (z == b.length) w++;
            }
        }
        return c;
    }


    public static int[][] test(int a[][]) { //вывод матрицы с индексами на удаление, ДЛЯ ПРОМЕЖУТОЧНОЙ ПРОВЕРКИ
        //ищем максимум
        int[][] b = new int[a.length][a.length];
        int max = Integer.MIN_VALUE;    //max значение в матрице


        //ищем максимум
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                if (a[i][j] > max) max = a[i][j];
            }
        }
        int index = max + 1;            //метка INDEX. Буду помечать  строки и столбцы которые надо будет удалить (+1 к максимуму чтобы эта цифра не входила в диапазон чисел матрицы )

        //перебираем массив а[][] и записываем b[][], помечая все строки  и столбцы, которые надо удалить INDEX-ом
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                //если максимум, то в массив b[][]записываем index
                if (a[i][j] == max) {
                    for (int x = 0; x < a.length; x++) {
                        b[i][x] = index;
                        b[x][j] = index;
                    }
                }
                if (b[i][j] != index)
                    b[i][j] = a[i][j]; //если записывали index, значит столбец занулен и переносить a[i][j] нельзя
            }
        }

        return b;
    }
}



