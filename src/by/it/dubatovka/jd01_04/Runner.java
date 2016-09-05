package by.it.dubatovka.jd01_04;

public class Runner {
    public static void main(String[] args) {


        double x[][] = {
                {1, 2},
                {3, 4}
        };
        double y[][] = {
                {7, 4, 3},
                {5, 3, 9}
        };
        double v[] = {1, 2};

        double z[][] = Util.arraMulArray(x, y);
        double zv[] = Util.arrayMulVec(x, v);

//        System.out.println("z");
//    Util.showArray(z);
//        System.out.println("zv");
//    Util.showArray(zv);

        double[][] a = {
                {2, 5, 4, 1},
                {1, 3, 2, 1},
                {2, 10, 9, 7},
                {3, 8, 9, 2}
        };
        double[] yy = {20, 11, 40, 37};
        double[] newm = Solver.findRoot(a, yy, true);
        Solver.findRoot(a, yy, false);
        Util.showArray(x);
        double[] yTest = Util.arrayMulVec(a, newm);
        Util.showArray(yTest);
        Util.showArray(yy);
    }


}

