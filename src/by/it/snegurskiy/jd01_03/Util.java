package by.it.snegurskiy.jd01_03;

/**
 * Created by snegurskiy.nn on 27.08.2016.
 */
public class Util {

    public static double [] sortUpOneArray (double [] args){
        for (int i = 0; i <args.length ; i++) {
            for (int j = i+1; j <args.length ; j++) {
                if (args[i]>args[j]) {
                    double z=args[i];
                    args[i]=args[j];
                    args[j]=z;
                }
            }
        }
        return args;
    }

    public static double [] sortDownOneArray (double [] args){
        for (int i = 0; i <args.length ; i++) {
            for (int j = i+1; j <args.length ; j++) {
                if (args[i]<args[j]) {
                    double z=args[i];
                    args[i]=args[j];
                    args[j]=z;
                }
            }
        }
        return args;
    }

    public static void maxElemOneArray (double[] args){
        double max=Double.MIN_VALUE;
        for (int i = 0; i <args.length ; i++) {
            if (args[i]>max) max=args[i];}
        System.out.println("Максимальный элемент массива = "+max);


        }

    public static void minElemOneArray (double[] args){
        double min=Double.MAX_VALUE;
        for (int i = 0; i <args.length ; i++) {
            if (args[i]<min) min=args[i];}
        System.out.println("Минимальный элемент массива = "+min);
    }

    public static double [] arrayMulVector (double[][] x, double[]y){
        double [] z=new double[x.length];
        for (int i = 0; i <x.length ; i++) {
            for (int j = 0; j <y.length ; j++) {
                z[i]=z[i]+x[i][j]*y[j];}
          }
        return z;
        }
    public static double[][] arrayMulArray (double[][]x, double[][]y){
        double[][] z=new double[x.length][y[0].length];
        for (int i = 0; i <x.length ; i++) {
            for (int j = 0; j <y[0].length ; j++) {
                for (int k = 0; k <y.length ; k++) {
                    z[i][j]=z[i][j]+x[i][k]*y[k][j];

                }

            }
        }
    return z;
    }

    public static double[] findRoot (double[][]mA, double []mY, boolean showSteps){
        int n=mA.length;
        double [][]m=new double[n][n+1];

        for (int i = 0; i <n ; i++) {
            for (int j = 0; j <n ; j++) {
                m[i][j]=mA[i][j];}
               }
        for (int i = 0; i <n ; i++) {
            m[i][n]=mY[i];
        }
        double k;

        for (int i = 0; i <n-1 ; i++) {
            for (int j = i+1; j <n ; j++) {
                k=m[j][i]/m[i][i];
                for (int l = 0; l <n+1 ; l++) {
                    m[j][l]=m[j][l]-m[i][l]*k;}}}





        for (int i = n-1; i >0 ; i--) {
            for (int j = 0; j <i ; j++) {
                k=m[j][i]/m[i][i];
                for (int l = 0; l <n+1 ; l++) {
                    m[j][l]=m[j][l]-m[i][l]*k;}}}




        for (int i = 0; i <n ; i++) {
            k=1/m[i][i];
            for (int j = 0; j <n+1 ; j++) {
                m[i][j]=m[i][j]*k;
            }
        }



        double[]x=new double[n];
        for (int i = 0; i <n ; i++) {
            x[i]=m[i][n];


        }


        return x;
    }

    public static double findDeterminant (double[][]mA, boolean showSteps){
        int n=mA.length;
        double [][]m=new double[n][n];

        for (int i = 0; i <n ; i++) {
            for (int j = 0; j <n ; j++) {
                m[i][j]=mA[i][j];}
        }
                double k;


        for (int i = 0; i <n-1 ; i++) {
            for (int j = i+1; j <n ; j++) {
                k=m[j][i]/m[i][i];
                for (int l = 0; l <n ; l++) {
                    m[j][l]=m[j][l]-m[i][l]*k;
                    }}}
        if (showSteps) InOut.arrayTwoPrint(m,"m",n);



        double x=1;
        for (int i = 0; i <n ; i++) {
            x=m[i][i]*x;
        }
        System.out.println(x);
        return x;
        }

    public static double[] inverseMatrix (double[][]mA, double []mY, boolean showSteps){
        int n=mA.length;
        double [][]m=new double[n][2*n+1];

        for (int i = 0; i <n ; i++) {
            for (int j = 0; j <n ; j++) {
                m[i][j]=mA[i][j];}
            m[i][m.length+i+1]=1;
        }

        for (int i = 0; i <n ; i++) {
            m[i][n]=mY[i];
        }
        double k;

        for (int i = 0; i <n-1 ; i++) {
            for (int j = i+1; j <n ; j++) {
                k=m[j][i]/m[i][i];
                for (int l = 0; l <2*n+1 ; l++) {
                    m[j][l]=m[j][l]-m[i][l]*k;}}}

        if (showSteps) InOut.arrayTwoPrint(m,"m",2*n+1);



        for (int i = n-1; i >0 ; i--) {
            for (int j = 0; j <i ; j++) {
                k=m[j][i]/m[i][i];
                for (int l = 0; l <n+1 ; l++) {
                    m[j][l]=m[j][l]-m[i][l]*k;}}}




        for (int i = 0; i <n ; i++) {
            k=1/m[i][i];
            for (int j = 0; j <n+1 ; j++) {
                m[i][j]=m[i][j]*k;
            }
        }



        double[]x=new double[n];
        for (int i = 0; i <n ; i++) {
            x[i]=m[i][n];


        }


        return x;
    }

    }

