package by.it.shkantau.jd01.jd01_04;

import java.util.Arrays;


public class Runner {
    public static void main(String[] args) {
        double[][] matrix = {
                {3, 5, 8, 2},
                {1, 5, 8, 6},
                {3, 2, 1, 7},
                {3, 4, 7, 2}
        };
        double[] vector = {22, 15, 31, 64};

        System.out.println("SLE solve:");
        double[] result = Util.findRoot(matrix, vector);
        System.out.println(Arrays.toString(result));

        InOut.printArray(Util.multiply(matrix, result), "Check method findRoot()", 5);

        System.out.println(Util.findDeterminate(matrix));
    }
}