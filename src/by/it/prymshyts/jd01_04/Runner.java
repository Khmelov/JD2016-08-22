package by.it.prymshyts.jd01_04;

public class Runner {

    public static void main(String[] args) {

        double[] y = {20, 11, 40, 37};

        double[][] m = {
                {2,  5, 4, 1},
                {1,  3, 2, 1},
                {2, 10, 9, 7},
                {3,  8, 9, 2}
        };

        double[] x = Solver.findRoot(m, y);
        InOut.printArray(x, "X", 1);

        InOut.printArray(Util.matrixMulVector(m, x), "yy", 4);

        System.out.println("Определитель матрицы: " + Solver.getDeterminant(m) + "\n");

        System.out.println("Обратная матрица:");
        InOut.printArray(Solver.inverseMatrix(m));
    }
}
