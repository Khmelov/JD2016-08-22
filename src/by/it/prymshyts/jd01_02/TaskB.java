package by.it.prymshyts.jd01_02;

public class TaskB {

    protected static void checkValueInRange(int value) {

        System.out.print("Введите минимальное значение: ");
        int minRange = Util.getConsoleNumber();
        System.out.print("Введите максимальное значение: ");
        int maxRange = Util.getConsoleNumber();

        if (minRange > maxRange) {
            System.out.println("Минимальное значение больше максимального, поэтому они были свапнуты...");
            int buffer = maxRange;
            maxRange = minRange;
            minRange = buffer;
        }

        for (int i = minRange; i <= maxRange; i++) {
            if (value == i) {
                System.out.println("Число " + value + " входит в диапазон [" + minRange + ", " + maxRange + "]");
                return;
            }
        }

        System.out.println("Число " + value + " не входит в диапазон [" + minRange + ", " + maxRange + "]");
    }

    protected static void printMatrix(int maxValue) {

        int N = (maxValue % 2 == 0) ? (maxValue / 2) : ((maxValue / 2) + 1);
        int[][] matrix = new int[N][N];
        int counter = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (++counter > maxValue)
                    break;
                else
                    matrix[i][j] = counter;
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    protected static void countQuadraticEquation(double a, double b, double c) {

        double xWithPlus, xWithMinus;
        double D = Math.sqrt((Math.pow(b, 2.0) - 4 * a * c));

        if (D >= 0) {
            xWithPlus = (-b + D) / (2 * a);
            xWithMinus = (-b - D) / (2 * a);
            System.out.println("Корни квадратного уравнение: " + xWithPlus + " и " + xWithMinus);
        } else {
            System.out.println("Уравнение не имеет корней");
        }
    }

    protected static String getDate(int month) {

        String currentMonth;

        switch (month) {
            case 1:
                currentMonth = "Январь";
                break;
            case 2:
                currentMonth = "Февраль";
                break;
            case 3:
                currentMonth = "Март";
                break;
            case 4:
                currentMonth = "Апрель";
                break;
            case 5:
                currentMonth = "Май";
                break;
            case 6:
                currentMonth = "Июнь";
                break;
            case 7:
                currentMonth = "Июль";
                break;
            case 8:
                currentMonth = "Август";
                break;
            case 9:
                currentMonth = "Сентябрь";
                break;
            case 10:
                currentMonth = "Октябрь";
                break;
            case 11:
                currentMonth = "Ноябрь";
                break;
            case 12:
                currentMonth = "Декабрь";
                break;
            default:
                currentMonth = "Такого нету";
                break;
        }

        return currentMonth;
    }
}
