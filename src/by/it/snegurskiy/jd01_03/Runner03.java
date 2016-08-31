package by.it.snegurskiy.jd01_03;

/**
 * Created by user on 26.08.2016.
 */
public class Runner03 {

    public static void main (String[] args) {

        double mas[] = {20, 11, 40, 37};
        //double mas[]=InOut.stringToDoubleOneArray();
        double masTwo[][] = {
            {2, 5, 4, 1},
            {1, 3, 2, 1},
            {2, 10, 9, 7},
            {3, 8, 9, 2}    };
        //double masTwo [][]=InOut.stringToDoubleTwoArray();


        //InOut.arrayOnePrint(mas,"m", 6);
        //InOut.arrayTwoPrint(masTwo,"m",3);
        // Util.sortUpOneArray(mas);
        //InOut.arrayOnePrint(mas,"m", 6);
        //Util.sortDownOneArray(mas);
        //InOut.arrayOnePrint(mas,"m", 6);
        //Util.maxElemOneArray(mas);
        // Util.minElemOneArray(mas);
        //double masTwoMulMas[] =Util.arrayMulVector(masTwo,mas);
        //InOut.arrayOnePrint(masTwoMulMas,"m",4);
        //double masTwoMulMasTwo[][]=Util.arrayMulArray(masTwo,masTwo);
        //InOut.arrayTwoPrint(masTwoMulMasTwo,"m",4);
//        double[] x=Util.findRoot(masTwo,mas,true);
//        double [] proverka1=Util.arrayMulVector(masTwo,x);
//        InOut.arrayOnePrint(proverka1,"m",4);
        //Util.findDeterminant(masTwo,true);
        Util.inverseMatrix(masTwo,mas,true);



    }

}
