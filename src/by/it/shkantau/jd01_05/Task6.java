package by.it.shkantau.jd01_05;
import static java.lang.Math.*;
/**
 * Created by Aliaksei on 20.09.2016.
 */
public class Task6 {
    public static double[] task6(int size, double min, double max){

        if (size > 40 || size < 20){
            size = 30;
        }

        double step = (max - min)/size;
        double [] array = new double[size];
        double x;

        for (int i = 0; i < size; i++) {
            x = min + step * i;
            array[i] = pow((pow(x,2) + 4.5), 1.0 / 3.0);
        }
        return  array;
    }

    public static void printArray(double[] array, String arrayName) {

        for (int i = 0; i < array.length; i++) {
            System.out.printf("%s[%02d] = %.5f\n", arrayName, i, array[i]);
        }
        System.out.println();
    }

    public  static  double [] trimArrayToValue(double [] array,double value){
        int morThanValueCounter = 0;
        for (int i = 0; i < array.length; i++) {
            if(array[i] > value){
                morThanValueCounter++;
            }
        }

        double [] newArray = new double[morThanValueCounter];
        int newArrayIndex = 0;
        for (int i = 0; i < array.length; i++) {
            if(array[i] > value) {
                newArray[newArrayIndex++] = array[i];
            }
        }
        return newArray;
    }

    public static double getGeometricMean (double [] array){
        double  geometricMean = 0;
        for (int i = 0; i < array.length; i++) {
            geometricMean += array[i];
        }
        return (geometricMean < 0 ? null : Math.pow(geometricMean, geometricMean));
    }
}
