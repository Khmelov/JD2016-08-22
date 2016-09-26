package by.it.prymshyts.jd01.jd01_05;

import static java.lang.Math.pow;

public class Task6 {

    protected static double[] getArray(int size) {

        if (size > 40) {
            size = 40;
        } else if (size < 20) {
            size = 20;
        }

        int length = size;
        double[] array = new double[length];

        for (double x = 5.33, i = 0; x <= 9; x += ((9 - 5.33) / length), i++) {
            if (i == length - 1) {
                break;
            }

            array[(int)i] = pow(pow(x, 2) + 4.5, 1.0 / 3.0);
        }

        return array;
    }

    protected static void printArray(double[] array, String arrayName) {

        for (int i = 0; i < array.length; i++) {
            System.out.printf("%s[%2d] = %f\n", arrayName, i, array[i]);
        }
        System.out.println();
    }

    protected static double[] getNewArray(double[] array) {

        int compatibleElementCount = 0;

        for (double element : array) {
            if (element >= 3.5) {
                compatibleElementCount++;
            }
        }

        double[] newArray = new double[compatibleElementCount];

        for (int i = 0, j = 0; i < array.length; i++) {
            if (array[i] >= 3.5) {
                newArray[j++] = array[i];
            }
        }

        return newArray;
    }

    protected static double getGeometricMean(double[] array) {

        double mul = 1;

        for (double element : array) {
            mul *= element;
        }

        return pow(mul, 1.0 / array.length);
    }
}
