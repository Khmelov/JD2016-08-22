package by.it.snegurskiy.jd01.jd01_04;

/**
 * Created by user on 26.08.2016.
 */
public class Runner04 {

    public static void main (String[] args) {

        double mas[] = {20, 11, 40, 37};
        //double mas[]=InOut.stringToDoubleOneArray();
        double masTwo[][] = {
            {2, 5, 4, 1},
            {1, 3, 2, 1},
            {2, 10, 9, 7},
            {3, 8, 9, 2}    };
        //double masTwo [][]=InOut.stringToDoubleTwoArray();


        Util.sortUpOneArray(mas);
        Util.sortDownOneArray(mas);
        Util.maxElemOneArray(mas);
        Util.minElemOneArray(mas);
        double masTwoMulMas[] =Util.arrayMulVector(masTwo,mas);
        double masTwoMulMasTwo[][]=Util.arrayMulArray(masTwo,masTwo);
        double[] x=Util.findRoot(masTwo,mas,true);
        InOut.arrayOnePrint(x,"m",4);
        double [] proverka1=Util.arrayMulVector(masTwo,x);
        InOut.arrayOnePrint(proverka1,"m",4);
        Util.findDeterminant(masTwo,true);
        System.out.println("Обратная матрица:");
        double[][]x1=Util.inverseMatrix(masTwo,mas,true);
        InOut.arrayTwoPrint(x1,"m",4);


    }

}
