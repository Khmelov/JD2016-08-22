package by.it.kisel.JD01_04;


public class Runner {
    public static void main(String[] args) {
        double x1[][] = {
                {1, 2},
                {3, 4}
        };
        double y[][] = {
                {7, 4, 3},
                {5, 3, 9}
        };
        double v[] = {1, 2};
        double z[][] = Util.arrayMulArray(x1, y);
        double zv[] = Util.arrayMulVec(x1, v);

        System.out.println("z");
        Util.showArray(z);
        System.out.println("zv");
        Util.showArray(zv);
        System.out.println();

        double[][] a = {
                {2, 5, 4, 1},
                {1, 3, 2, 1},
                {2, 10, 9, 7},
                {3, 8, 9, 2}
        };
        double[] yy = {20, 11, 40, 37};
        double[] x = Solver.findRoot();
        Util.showArray(x);
        double[] yTest = Util.arrayMulVec(a, x);
        Util.showArray(yTest);
        Util.showArray(yy);

        System.out.println("-------------------");
        Solver.findDeterminant();
    }
}
