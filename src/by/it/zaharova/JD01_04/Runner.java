package by.it.zaharova.JD01_04;

public class Runner {

    public static void main(String[] args) {
//        double xn[][] = {
//                {1, 2},
//                {3, 4}
//        };
//
//        double y[][] = {
//                {7, 4, 3},
//                {5, 3, 9}
//        };
//
//        double v[] = {1, 2};
//
//        double z[][] = Util.arrayMulArray(xn, y);
//        double zv[] = Util.arrayMulVec(xn, v);

        double[][] a={
                {2, 5, 4, 1},
                {1, 3,2,1},
                {2,10,9,7},
                {3,8,9,2}
        };

       double[] yy={20,11,40,37};
       double[] x=Solver.findRoot(a,yy,false);
        Util.showArray(x);
        double[] yTest=Util.arrayMulVec(a,x);
        Util.showArray(yTest);
        Util.showArray(yy);


        System.out.println("-----------------------");
        Solver.findDeter();
    }
}
