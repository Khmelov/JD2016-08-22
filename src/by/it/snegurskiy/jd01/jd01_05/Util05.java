package by.it.snegurskiy.jd01.jd01_05;

/**
 * Created by snegurskiy.nn on 06.09.2016.
 */
public class Util05 {

    static protected void arrayOnePrint(double mas[]) {

            for (int i = 0; i < mas.length; i++) {
                System.out.print(" A ("+i+") "+mas[i]);
            }
        }

    static protected void arrayOnePrintHorizont(double mas[], String name, int colCount) {
        int currentCol = 0;
        for (int i = 0; i < mas.length; i++) {
            System.out.printf("%s[% -3d]=%-4.0f ", name, i, mas[i]);
            currentCol++;
            if (currentCol % colCount == 0)
                System.out.println();
        }
        System.out.println();
    }
    static protected void arrayOnePrintVertical(double mas[], String name, int colCount) {
        int currentStr = (int)mas.length/colCount;

        for (int i = 0, col=0; i <= currentStr; i++) {
            for (int j = 0, k=i; j <colCount ; j++) {

if (k<mas.length) {
    System.out.printf("%s[% -3d]=%-4.0f ", name, k, mas[k]);
    k += currentStr + 1;
    col++;
}
        }
        System.out.println();
    }}

}

