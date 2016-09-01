package by.it.opiga.JD01_02;

import java.util.Random;

public class TaskC {
    static int[][] fullMas(int y) {
        int mas2[][] = new int[y][y];
        Random rnd = new Random(System.currentTimeMillis());
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < y; j++) {
                mas2[i][j] = rnd.nextInt(y * 2) - y;
            }
        }
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < y; j++) {
                System.out.print(mas2[i][j] + " ");
            }
            System.out.println(" ");
        }
        return mas2;
    }

    static int[] sumElem(int mas[][], int y) {
        int sum[] = new int[y];
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < y; j++) {
                if (mas[i][j] > 0) {
                    for (int k = j + 1; k < y; k++) {
                        if (mas[i][k] > 0) {
                            for (int l = j; l <= k; l++)
                                sum[i] = sum[i] + mas[i][l];
                            k = y;
                            j = y;
                        }
                    }
                }
            }
        }
        return sum;
    }

    static int[][] delMean(int mas[][], int y) {
        int sum = 0;
        double mean;
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < y; j++) {
                sum = sum + mas[i][j];
                if (j == (y - 1)) {
                    mean = (double) sum / (double) y;
                    for (int k = 0; k < y; k++)
                        mas[i][k] = mas[i][k] - (int) mean;
                    // System.out.println(mas[i][k]);}
                }
                sum = 0;
            }

        }
        return mas;

    }

    static int[][] transMas(int [][]tranmas, int [][] mas, int y) {

        for (int i = 0; i < y; i++) {
            for (int j = 0; j < y; j++) {
               tranmas[j][i]=mas[i][j];
              }
        }
        return tranmas;
    }

    static int[][] turnMas(int [][] mas, int y) {
        int turnMas[][]=new int[y][y];
        for (int i = 0; i <y; i++) {
            for (int j = 0; j <y; j++) {
            turnMas[j][i]=mas[i][j];
                //System.out.println(turnMas[j][i]+" "+mas[i][j]);
            }
            }
            System.out.println("");

            return turnMas;
        }


    static void test(){
        int f = 0;
        while (f < 10) {
            f++;
            for (int i = 0; i <5 ; i++)
                for (int j = 0; j <2 ; j++)
                {
                    if(j==1)
                    {/*выход из цикла */break;}
                    else
                    {/*переход к следующей итерации*/  continue;}
                }
        }
    }

}