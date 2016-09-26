package by.it.shkantau.jd01_04;

public class InOut {

    protected static double[] stringTo1Darray(String line) {

        line = line.trim();
        String[] stringElement = line.split(" ");
        double[] array = new double[stringElement.length];

        for (int i = 0; i < stringElement.length; i++) {
            array[i] = Double.parseDouble(stringElement[i]);
        }

        return array;
    }

    protected static double[][] stringTo2Darray(String line, int rows, int cols) {

        line = line.trim();
        String[] stringElement = line.split(" ");

        if ((rows * cols) < stringElement.length)
            cols += stringElement.length - (rows * cols);

        double[][] array = new double[rows][cols];
        int elementCounter = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (elementCounter < stringElement.length)
                    array[i][j] = Double.parseDouble(stringElement[elementCounter++]);
            }
        }

        return array;
    }

    protected static void printArray(double[] array, String name, int cols) {

        int col = 0;

        for (int i = 0; i < array.length; i++) {
            System.out.printf("%s[% -3d]=%-4.1f ", name, i, array[i]);

            if ((++col % cols == 0) || (array.length - 1 == i))
                System.out.println();
        }
        System.out.println();
    }

    protected static void printArray(double[][] array) {

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                System.out.printf("%6.1f ", array[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    protected static void printArray(double[][] array, String name) {

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                System.out.printf("%s[%1d,%1d]=%-6.1f", name, i, j, array[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }
}
