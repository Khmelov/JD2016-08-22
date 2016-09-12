package by.it.snegurskiy.jd01_02;


import java.lang.*;

/**
 * Created by user on 24.08.2016.
 */
public class Runner02 {
    public static void main(String[] args) {



        String line = "11 22 -22 333 -333 12";
        //String line= Util.getLineConsole();
        System.out.println("Набор чисел " + line);
        System.out.println();


        //for (int i : arr) {
        //    System.out.println(i + " ");
        //Задание А1
        String strMas[] = line.split(" ");
        System.out.println("Задание А1:");
        System.out.println("MAX " + A.maxLength(strMas));
        System.out.println("MIN " + A.minLength(strMas));
        System.out.println();

        // Задание А2
        int arr[] = Util.getIntArray(line);
        int mean = A.mean(arr);
        System.out.println("Задание А2:");
        System.out.print("Числа меньше " + mean + " следующие:");
        for (int i : arr) {
            if (i < mean) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
        System.out.println();


        //Задание А3
        System.out.println("Задание А3");
                for (int i = 0; i <arr.length ; i++) {
            if (A.uniqueDigits(arr[i])){System.out.println("найдено число из разных цифр: " + arr[i]);
        } else if (i==arr.length-1){System.out.println("не найдено число из разных цифр");}
        }


        //Задание В1
        System.out.println("Задание B1");
        System.out.println("Введите начало и конец интервала");
        int start=Util.getIntConsole();
        int end=Util.getIntConsole();
        System.out.println("Введите искомое число");
        int x=Util.getIntConsole();
        if (x>start&x<end) System.out.println("число принадлежит интервалу");
        else System.out.println("число не принадлежит интервалу");


        // Задание В2
        System.out.println("Задание B2");
        System.out.println("Введите число до какого будет вывод чисел");
        int endNumber=Util.getIntConsole();
        System.out.println("Введите размер матрицы");
        int sizeArray=Util.getIntConsole();
        for (int i = 1; i <=endNumber ; i++) {
            System.out.print("  "+i+"  ");
            if (i%sizeArray==0) System.out.println();

        }
            // Задание В3
        System.out.println("Задание B3");
        System.out.println("Преобразуйте уравнение в формат ax^2+bx+c=0 и введите a,b,c");
        double [] Equation=new double[5];
        Equation[0]=Util.getIntConsole();
        Equation[1]=Util.getIntConsole();
        Equation[2]=Util.getIntConsole();
        B.searhRoot(Equation);

        // Задание В4
        System.out.println("Задание B4");
        System.out.println("Введите номер месяца");
        int xMonth=Util.getIntConsole();
        System.out.println(B.selectionMonth(xMonth));

//        //Задание С1
        System.out.println("Задание C1");
        double[][] masTwo = {
                {-1, -2, -8, 5, -8, 1},
                {4, -1, -1, 8, 0, 1},
                {11, 1, -11, 11, 1, 1},
                {7, -8, 8, 1, 1, 11},
                {7, -8, -8, 1, 1, 11},
                {7, -8, 8, 1, 1, 11},
        };


        double sumArray []= new double[masTwo.length];
        for (int i = 0; i <masTwo.length ; i++) {
            int score=0;
            double score1=0;
            for (int j = 0; j <masTwo[i].length ; j++) {
                if (masTwo[i][j]<0&score==1)score1=score1+masTwo[i][j];
                if (masTwo[i][j]>0) score++;
                    sumArray[i]=score1;
                    if (score==2) break;
            }
        }
        Util.arrayOnePrint(sumArray);

        //Задание С2
        System.out.println("Задание C2");
      double [][]copyС2MasTwo=new double[masTwo.length][masTwo[0].length];
        for (int i = 0; i <masTwo.length ; i++) {
            for (int j = 0; j < masTwo[0].length; j++) {
                copyС2MasTwo[i][j]=masTwo[j][i];
            }}
            Util.arrayTwoPrint(copyС2MasTwo);


        //Задание С3
        System.out.println("Задание C3");
        double [][]copyС3MasTwo=new double[masTwo.length][masTwo[0].length];
        for (int i = 0; i <masTwo.length ; i++) {
            for (int j = 0; j < masTwo.length; j++) {
                copyС3MasTwo[j][i]=masTwo[i][masTwo.length-j-1];


            }}
        Util.arrayTwoPrint(copyС3MasTwo);


        //Задание С4
        System.out.println("Задание C4");
        double [] c4Array=new double[masTwo.length];
        for (int i = 0; i <masTwo.length ; i++) {
            for (int j = 0; j < masTwo[0].length; j++) c4Array[i]=c4Array[i]+masTwo[i][j];
            c4Array[i]=c4Array[i]/masTwo[0].length;

        }
        double [][]copyС4MasTwo=new double[masTwo.length][masTwo[0].length];
        for (int i = 0; i <masTwo.length ; i++) {
            for (int j = 0; j < masTwo[0].length; j++){
                copyС4MasTwo[i][j]=masTwo[i][j]-c4Array[i];
            }}
        Util.arrayTwoPrint(copyС4MasTwo);

        //Задание С5

//        double maxC5 = Double.MIN_VALUE;
//        for (int i = 0; i < masTwo.length; i++) {
//            for (int j = 0; j < masTwo[0].length; j++) {
//                if (masTwo[i][j] >= maxC5) {
//                    maxC5 = masTwo[i][j];
//                }
//            }
//        }
//        int n = 0;
//        int[] sborStr = new int[masTwo.length];
//        int[] sborCol = new int[masTwo[0].length];
//        for (int i = 0; i < masTwo.length; i++) {
//            for (int j = 0; j < masTwo[0].length; j++) {
//                if (masTwo[i][j] >= maxC5) {
//                    sborStr[n] = i;
//                    sborCol[n] = j;
//                    n++;
//                }
//            }
//        }
//        int[] sborStr1 = new int[n];
//        for (int i = 0; i < n; i++) {
//            sborStr1[i] = sborStr[i];
//        }
//        int[] sborCol1 = new int[n];
//        for (int i = 0; i < n; i++) {
//            sborCol1[i] = sborCol[i];
//        }
//
//
//int[] sborStr2=new int [n];
//        int l=0;
//        for (int i = 0; i <sborStr1.length ; i++) {
//            int k=0;
//               for (int j = i+1; j <sborStr1.length ; j++) {
//                if (sborStr1[i]==sborStr1[j]) k++;}
//
//                        if (k==0){sborStr2[l]=sborStr1[i];
//                        l++;}
//
//
//            }
//            double[] sborStr3= new double[l];
//        for (int i = 0; i <sborStr3.length ; i++) {
//            sborStr3[i]=sborStr2[i];
//        }
//
//
//        double[] sborCol2=new double[n];
//        int l1=0;
//        for (int i = 0; i <sborCol1.length ; i++) {
//            int k=0;
//            for (int j = i+1; j <sborCol1.length ; j++) {
//                if (sborCol1[i]==sborCol1[j]) k++;}
//
//            if (k==0){sborCol2[l1]=sborCol1[i];
//                l1++;}
//
//
//        }
//        double [] sborCol3= new double[l1];
//        for (int i = 0; i <sborCol3.length ; i++) {
//            sborCol3[i]=  sborCol2[i];
//        }
//
//
//double [][] othStr=C.c5String(masTwo,sborStr3);
//        //Util.arrayTwoPrint(othStr);
//
//        C.c5Col(othStr,sborCol3);

        }}







