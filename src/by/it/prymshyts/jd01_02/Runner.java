package by.it.prymshyts.jd01_02;

public class Runner {

    public static void main(String[] args) {

        //* Task A
        System.out.println("Задания А\n-----------");
        System.out.print("Введите строку из чисел: ");
        String line = Util.getConsoleLine();
        //String line = "3 11 22 343 123 67 4565 333 22 853";

        //1
        String longestNum = TaskA.getLongestNum(line);
        System.out.println("Самое длинное число = " + longestNum + " с длинной = " + longestNum.length());

        String shortestNum = TaskA.getShortestNum(line);
        System.out.println("Самое короткое число = " + shortestNum + " с длинной = " + shortestNum.length());
        System.out.println();

        //2
        TaskA.printShorterThanMean(line, Util.getMean(Util.stringToIntArr(line)));
        System.out.println();

        //3
        TaskA.printUniqueDigitsNumber(Util.stringToIntArr(line));
        System.out.println("-----------\nЗадания А завершены\n");

        //* Task B
        System.out.println("Задания В\n-----------");
        System.out.print("Введите значение k: ");
        int k = Util.getConsoleNumber();
        //int k = 8;

        //1
        TaskB.checkValueInRange(k);
        System.out.println();

        //2
        TaskB.printMatrix(k);
        System.out.println();

        //3
        System.out.print("Введите a: ");
        double a = Util.getConsoleNumber();
        System.out.print("Введите b: ");
        double b = Util.getConsoleNumber();
        System.out.print("Введите c: ");
        double c = Util.getConsoleNumber();
        TaskB.countQuadraticEquation(a, b, c);
        System.out.println();

        //4
        System.out.print("Введите номер месяца: ");
        int month = Util.getConsoleNumber();
        System.out.println("Месяц под номером " + month + ": " + TaskB.getDate(month));
        System.out.println("-----------\nЗадания В завершены\n");

        //* Task C
        System.out.println("Задания С\n-----------");
        System.out.print("Введите n матрицы a[n][n]: ");
        int n = Util.getConsoleNumber();
        //int n = 3;
        int[][] arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = Util.getRandomNum(-n, n);
            }
        }

        System.out.println("Матрица:");
        TaskC.printArray(arr);

        //1
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += TaskC.getRowSum(arr, i);
        }

        System.out.println("1 задание: " + sum + "\n");

        //2
        System.out.println("Транспонированная матрица:");
        arr = TaskC.transposeArray(arr);
        TaskC.printArray(arr);

        //3
        System.out.println("Матрица, повёрнутая против часовой стрелки на 90 градусов:");
        arr = TaskC.turnArray(arr);
        TaskC.printArray(arr);

        //4
        double mean = TaskC.getMatrixMean(arr);

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] -= mean;
            }
        }

        System.out.println("Матрица после задания 4 (среднее арифметическое = " + mean + "):");
        TaskC.printArray(arr);

        //5
        System.out.println("Матрица после задания 5:");
        arr = TaskC.recreateWithoutMax(arr);
        TaskC.printArray(arr);

        //6
        System.out.println("Матрица после задания 6:");
        arr = TaskC.minToOneOne(arr);
        TaskC.printArray(arr);

        //7
        System.out.println("Матрица после задания 7:");
        arr = TaskC.zeroToEnd(arr);
        TaskC.printArray(arr);

        // Цикл do..while() для бота.
        do {
            break;
        } while(false);
    }
}
