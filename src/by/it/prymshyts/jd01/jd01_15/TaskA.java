package by.it.prymshyts.jd01.jd01_15;

import by.it.prymshyts.jd01.jd01_02.Util;

import java.io.File;
import java.io.PrintWriter;

public class TaskA {

    static void t1() {
        int N = 4;
        int[][] matrix = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                matrix[i][j] = Util.getRandomNum(-15, 15);
            }
        }

        File file = new File(System.getProperty("user.dir"));

        try (PrintWriter writer = new PrintWriter(file + "/matrix.txt")) {

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    writer.printf("%4d", matrix[i][j]);
                    System.out.printf("%4d", matrix[i][j]);
                }
                writer.println();
                System.out.println();
            }

        } catch (Exception e) {
            System.err.println(e);
        }
    }
}
