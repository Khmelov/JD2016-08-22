package by.it.prymshyts.jd01_05;

import static java.lang.Math.*;

public class Task7 {

    protected static int[] getArrayA() {

        int[] array = new int[31];

        for (int i = 0; i < array.length; i++) {
            array[i] = 103 + (int)(random() * ((450 - 103) + 1));
        }

        return array;
    }

    protected static int[] getArrayB(int[] array) {

        int compatibleElementCount = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i] * 0.1 > i) {
                compatibleElementCount++;
            }
        }

        int[] tmpArray = new int[compatibleElementCount];

        for (int i = 0, j = 0; i < array.length; i++) {
            if (array[i] * 0.1 > i) {
                tmpArray[j++] = array[i];
            }
        }

        for (int i = 0; i < tmpArray.length - 1; i++) {
            for (int j = i + 1; j < tmpArray.length; j++) {
                if (tmpArray[i] > tmpArray[j]) {
                    int buffer = tmpArray[i];
                    tmpArray[i] = tmpArray[j];
                    tmpArray[j] = buffer;
                }
            }
        }

        return tmpArray;
    }

    protected static void printArrayA(int[] array) {

        for (int i = 0; i < array.length; i++) {

            System.out.printf("┃A(%2d)=%3d┃", i + 1, array[i]);

            if ((i + 1) % 5 == 0) {
                System.out.println();
            }
        }

        System.out.println("\n");
    }

    protected static void printArrayB(int[] array) {

        if (array.length % 2 == 0) {
            for (int i = 0, j = array.length / 2; i < array.length / 2; i++, j++) {
                System.out.printf("┃A(%2d)=%3d┃┃A(%2d)=%3d┃\n", i + 1, array[i], j + 1, array[j]);
            }
        } else {
            int counter = 0;
            int i = 0, j = array.length / 2 + 1;

            while (counter < ceil(array.length / 2)) {

                System.out.printf("┃A(%2d)=%3d┃┃A(%2d)=%3d┃\n", i + 1, array[i], j + 1, array[j]);
                i++;
                j++;
                counter++;
            }

            System.out.printf("┃A(%2d)=%3d┃\n\n", i + 1, array[i]);
        }
    }
}
