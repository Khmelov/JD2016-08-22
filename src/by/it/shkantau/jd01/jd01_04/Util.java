package by.it.shkantau.jd01.jd01_04;

public class Util {
    /**
     * Matrix and vector multiplying.
     * @param matrix - matrix.
     * @param vector - vector.
     * @return -  result.
     */
     static double[] multiply(double[][] matrix, double[] vector) {
        double[] result = new double[vector.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < vector.length; j++) {
                result[i] += matrix[i][j] * vector[i];
            }
        }
        return result;
    }

    /**
     * Matrix and matrix multiplying
     * @param first - matrix.
     * @param second - next matrix.
     * @return - result.
     */
    public static double[][] multiply(double[][] first, double[][] second) {
        double[][] result = new double[first.length][second[0].length];
        for (int i = 0; i < first.length; i++) {
            for (int j = 0; j < second[0].length; j++) {
                for (int k = 0; k < second.length; k++) {
                    result[i][j] += first[i][k] * second[k][j];
                }
            }
        }
        return result;
    }

    public static double[] findRoot(double[][] matrix, double[] vector) {
        //Create matrix
        int size = matrix.length;
        double[][] m = new double[size][size + 1];
        for (int i = 0; i < size; i++) {

//            System.arraycopy(m[i], 0 , matrix[i] , 0, size);
            for (int j = 0; j < size; j++) {
                m[i][j] = matrix[i][j];
            }
        }
        for (int i = 0; i < size; i++) {
            m[i][size] = vector[i];
        }

        //Forward
        double k;
        for (int diag = 0; diag < size - 1; diag++) {
            for (int row = diag + 1; row < size; row++) {
                k = m[row][diag] / m[diag][diag];
                for (int col = 0; col < size + 1; col++) {
                    m[row][col] = m[row][col] - m[diag][col] * k;
                }
            }
        }

        //Reverse
        for (int diag = size-1; diag > 0; diag--) {
            for (int row = 0; row < diag; row++) {
                k = m[row][diag] / m[diag][diag];
                for (int col = 0; col < size + 1; col++) {
                    m[row][col] = m[row][col] - m[diag][col] * k;
                }
            }
        }


        for (int i = 0; i < size; i++) {
            k = 1/m[i][i];
            for (int j = 0; j < size + 1; j++) {
                m[i][j] = m[i][j] * k;
            }
        }


        double[] result = new double[size];
        for (int i = 0; i < size; i++) {
            result[i] = m[i][size];
        }

        return result;
    }

    static double findDeterminate(double[][] matrix) {
        System.out.println("Find matrix determinant:");

        int size = matrix.length;
        double[][] m = new double[size][size];
        for (int i = 0; i < size; i++) {
//            System.arraycopy(m[i], 0 , matrix[i] , 0, size);
            for (int j = 0; j < size; j++) {
                m[i][j] = matrix[i][j];
            }
        }
        double k;
        for (int diagonal = 0; diagonal < size; diagonal++) {
            for (int row = diagonal + 1; row < size; row++) {
                k = m[row][diagonal] / m[diagonal][diagonal];
                for (int col = 0; col < size; col++) {
                    m[row][col] = m[row][col] - m[diagonal][col] * k;
                }
            }
        }
        double[] arr = new double[size];
        for (int i = 0; i < size; i++) {
            arr[i] = m[i][i];
        }

        double result = 1;
        for(double d : arr) {
            result *= d;
        }
        return result;
    }
}
