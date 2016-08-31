package by.it.prymshyts.jd01_02;

public class TaskC {

    protected static void printArray(int[][] array) {

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                System.out.printf("%4d", array[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    protected static void printArray(int[] array) {

        for (int element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    protected static int getRowSum(int[][] a, int row) {

        int sum = 0;
        boolean firstElement = false, secondElement = false;

        for (int i = 0; i < a[0].length; i++) {
            if (!firstElement && a[row][i] > 0) {
                firstElement = true;
                continue;
            }

            if (firstElement && a[row][i] > 0) {
                secondElement = true;
                break;
            }

            if (firstElement) {
                sum += a[row][i];
            }
        }

        if (!secondElement)
            sum = 0;

        return sum;
    }

    protected static int[][] transposeArray(int[][] arr) {

        int[][] tmpArr = new int[arr[0].length][arr.length];

        for (int i = 0; i < arr[0].length; i++) {
            for (int j = 0; j < arr.length; j++) {
                tmpArr[i][j] = arr[j][i];
            }
        }

        return tmpArr;
    }

    protected static int[][] turnArray(int[][] arr) {

        int[][] tmpArr = new int[arr.length][arr[0].length];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                tmpArr[i][j] = arr[j][arr[0].length - i - 1];
            }
        }

        return tmpArr;
    }

    protected static double getMatrixMean(int[][] arr) {

        double mean = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                mean += arr[i][j];
            }
        }

        mean /= (arr.length * arr[0].length);

        return mean;
    }

    protected static int[][] recreateWithoutMax(int[][] a) {

        int max = Integer.MIN_VALUE;

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                if (a[i][j] > max)
                    max = a[i][j];
            }
        }

        int maxElementCount = getMaxElementCount(a, max);
        int[] rowsWithMax = new int[maxElementCount];
        int[] columnsWithMax = new int[maxElementCount];

        int index = 0;

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                if (a[i][j] == max) {
                    rowsWithMax[index] = i;
                    columnsWithMax[index] = j;
                    index++;
                }
            }
        }

        int[][] tmpArr = new int[a.length - uniqueNumbersInArray(rowsWithMax)][a[0].length - uniqueNumbersInArray(columnsWithMax)];

        return copyWithoutMax(a, tmpArr, max, rowsWithMax, columnsWithMax);
    }

    protected static int[][] minToOneOne(int[][] a) {

        if (a.length < 2 || a[0].length < 2) {
            System.out.println("Размер массива не соответствует заданию.");
        } else {

            int min = Integer.MAX_VALUE;

            for (int i = 0; i < a.length; i++) {
                for (int j = 0; j < a[0].length; j++) {
                    if (a[i][j] < min)
                        min = a[i][j];
                }
            }

            if (a[1][1] != min) {

                boolean swapped = false;

                for (int i = 0; i < a.length; i++) {
                    for (int j = 0; j < a[0].length; j++) {
                        if (a[i][j] == min) {

                            int rowCounter = i, columnCounter = j;

                            if (rowCounter > 1) {
                                while (rowCounter-- > 1) {
                                    for (int k = 0; k < a[0].length; k++) {
                                        int buffer = a[rowCounter][k];
                                        a[rowCounter][k] = a[rowCounter + 1][k];
                                        a[rowCounter + 1][k] = buffer;
                                    }
                                }
                            } else if (rowCounter < 1) {
                                while (rowCounter++ < 1) {
                                    for (int k = 0; k < a[0].length; k++) {
                                        int buffer = a[rowCounter][k];
                                        a[rowCounter][k] = a[rowCounter - 1][k];
                                        a[rowCounter - 1][k] = buffer;
                                    }
                                }
                            }

                            if (columnCounter > 1) {
                                while (columnCounter-- > 1) {
                                    for (int k = 0; k < a.length; k++) {
                                        int buffer = a[k][columnCounter];
                                        a[k][columnCounter] = a[k][columnCounter + 1];
                                        a[k][columnCounter + 1] = buffer;
                                    }
                                }
                            } else if (columnCounter < 1) {
                                while (columnCounter++ < 1) {
                                    for (int k = 0; k < a.length; k++) {
                                        int buffer = a[k][columnCounter];
                                        a[k][columnCounter] = a[k][columnCounter - 1];
                                        a[k][columnCounter - 1] = buffer;
                                    }
                                }
                            }
                            swapped = true;
                            break;
                        }
                    }
                    if (swapped)
                        break;
                }
            }
        }

        return a;
    }

    protected static int[][] zeroToEnd(int[][] a) {

        int[] tmpArr = new int[a.length * a[0].length];
        int index = 0;

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                if (a[i][j] != 0)
                    tmpArr[index++] = a[i][j];
            }
        }

        int[][] newArr = new int[a.length][a[0].length];
        boolean moved = false;
        index = 0;

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                if (tmpArr[index] != 0) {
                    newArr[i][j] = tmpArr[index++];
                } else {
                    moved = true;
                    break;
                }
            }
            if (moved)
                break;
        }

        return newArr;
    }

    private static int getMaxElementCount(int[][] arr, int max) {

        int counter = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] == max)
                    counter += 1;
            }
        }

        return counter;
    }

    private static int uniqueNumbersInArray(int[] array) {

        int uniqueNumbers = 1, currentElement;
        boolean unique;

        for (int i = 0; i < array.length - 1; i++) {
            unique = true;
            currentElement = array[i];

            for (int j = i + 1; j < array.length; j++) {
                if (currentElement == array[j])
                    unique = false;
            }

            if (unique)
                uniqueNumbers++;
        }

        return uniqueNumbers;
    }

    private static int[][] copyWithoutMax(int[][] copyFrom, int[][] copyTo, int max, int[] rowsWithMax, int[] columnsWithMax) {

        int rowIndex = 0, columnIndex;

        for (int i = 0; i < copyFrom.length; i++) {

            columnIndex = 0;

            if (isInArray(rowsWithMax, i))
                continue;

            for (int j = 0; j < copyFrom[0].length; j++) {
                if (isInArray(columnsWithMax, j))
                    continue;

                copyTo[rowIndex][columnIndex] = copyFrom[i][j];
                columnIndex++;
            }
            rowIndex++;
        }

        return copyTo;
    }

    private static boolean isInArray(int[] array, int num) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == num)
                return true;
        }

        return false;
    }
}
