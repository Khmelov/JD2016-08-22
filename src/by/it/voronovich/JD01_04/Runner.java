package by.it.voronovich.JD01_04;

import java.io.IOException;

public class Runner {

    public static void main(String[] args) throws IOException {

        double a[][] = {
                {2, 5, 4, 1},
                {1, 3, 2, 1},
                {2, 10, 9, 7},
                {3, 8, 9, 2}
        };

        double vec[] = {20, 11, 40, 37};

        //вычисление корней СЛАУ
        double roots[] = Util.findRoots(a, vec);
        System.out.print("Корни СЛАУ: ");
        InOut.massivePrint(roots);

        System.out.println(" ");

        //проверка метода findRoots
        System.out.println("Произведем проверку метода findRoots путем перемножения исходной матрицы на вектор корней: ");
        double check[]=Util.multiplyVecMatrix(a,roots);
        InOut.massivePrint(check);
        System.out.println(" ");

        //вычисление определителя матрицы
        double determinant = Util.findDeterminant(a);
        System.out.println("Определитель матрицы: " + determinant);

        //вычисление обратной матрицы
        System.out.println("Обратная матрица: ");
        double inverseMatrix[][]=Util.inverseMatrix(a);
        InOut.matrixPrint(inverseMatrix);

        //проверка метода inversMatrix
        System.out.println("Произведение исходной и обратной матриц: ");
        double result[][]=Util.multiplyTwoMatrix(a,inverseMatrix);
        InOut.matrixPrint(result);
    }
}
