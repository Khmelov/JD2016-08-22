package by.it.snegurskiy.jd01.jd01_02;

/**
 * Created by snegurskiy.nn on 01.09.2016.
 */
public class C {

//    public static double[][] c5String(double [][] masTwo, double[]sbor1){
//
//        double [][]copy5MasTwo=new double[masTwo.length-sbor1.length][masTwo[0].length];
//        for (int i = 0; i <sbor1.length ; i++) {
//            for (int j = 0, col1=0; j<copy5MasTwo.length; j++, col1++) {
//            if (j==sbor1[i]) col1++;
//                for (int k = 0; k <copy5MasTwo[0].length ; k++) {
//                    copy5MasTwo[j][k]=masTwo[col1][k];
//                }
//
//
//            }
//
//        }
//        Util.arrayTwoPrint(copy5MasTwo);
//        return copy5MasTwo;
//    }
//
//    public static double[][] c5Col(double [][] masTwo, double[]sbor1){
//
//        double [][]copy5MasTwo=new double[masTwo.length][masTwo[0].length-sbor1.length];
//        for (int i = 0; i <sbor1.length ; i++) {
//            for (int j = 0, col1=0; j<copy5MasTwo.length; j++, col1++) {
//                if (j==sbor1[i]) col1++;
//                for (int k = 0; k <copy5MasTwo[0].length ; k++) {
//                    copy5MasTwo[j][k]=masTwo[k][col1];
//                }
//
//
//            }
//
//        }
//        Util.arrayTwoPrint(copy5MasTwo);
//        return copy5MasTwo;
//    }
    public static double maxArrayC5 (double masTwo [][]){
    double maxC5=Double.MIN_VALUE;
    int n=0,m=0;
       for (int i = 0; i <masTwo.length ; i++) {
        for (int j = 0; j < masTwo[0].length; j++){
            if (masTwo[i][j]>maxC5) {
                maxC5=masTwo[i][j];
                n=i;
                m=j;
            }}}
            return maxC5;

}}
