package by.it.aborisenok.JD01_04;

import java.io.IOException;


public class Runner {
    public static void main(String[] args) throws IOException {

        // вводим одномерный массив
         double[] array = InOut.inputLineArray();
        //или
//        double[] array = {1.1, 2.2, 3.3, 4.4 ,5.5};

        // вводим двухмерный массив
         double[][] doubleArray = InOut.inputDoubleArray();
        // или
//        double[][] doubleArray = {
//                {1, 2, 3, 4, 5},
//                {1, 2, 3, 4, 5},
//                {1, 2, 3, 4, 5},
//                {1, 2, 3, 4, 5},
//                {1, 2, 3, 4, 5},
//        };
        // выводим одномерный массив на печать
        InOut.printLineArray(array, "M");
        // выводим двухмерный массив на печать
        InOut.printDoubleArray(doubleArray, "M");
    }
}
