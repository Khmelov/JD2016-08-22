package by.it.grechishnikov.jd01_02;

/**
 * Created by Evgeniy on 24.08.16.
 */
public class TaskB {
    public static void interval() {
        System.out.println("Введите числа: то, которое нужно найти; нижняя граница; верхняя граница.");
        int k = Util.getInt();
        int n = Util.getInt();
        int m = Util.getInt();
        if(k >= n && k <= m) {
            System.out.println("Число принадлежит интервалу");
        } else {
            System.out.println("Число не пренадлежит интервалу");
        }
    }

    public static void printMonth() {
        System.out.println("Введите число от 1 до 12 для поиска месяца:");
        int number;
        do {
            number = Util.getInt();
        } while(!(number <= 12 && number >= 1));
        System.out.print("Месяц под номером " + number + " = ");
        switch (number) {
            case 1 :
                System.out.println("Январь");
                break; /*break - т.к. без него все последующие операции так же будут выполнены, т.е. продолжится вывод:
                Февраль Март и т.д.*/
            case 2 :
                System.out.println("Февраль");
                break;
            case 3 :
                System.out.println("Март");
                break;
            case 4 :
                System.out.println("Апрель");
                break;
            case 5 :
                System.out.println("Май");
                break;
            case 6 :
                System.out.println("Июнь");
                break;
            case 7 :
                System.out.println("Июль");
                break;
            case 8 :
                System.out.println("Август");
                break;
            case 9 :
                System.out.println("Сентябрь");
                break;
            case 10 :
                System.out.println("Октябрь");
                break;
            case 11 :
                System.out.println("Ноябрь");
                break;
            case 12 :
                System.out.println("Декабрь");
                break;
            default:
                System.out.println("Ошибка");
        }
    }

    public static void getSqrt(String[] arr) {
        int a = Integer.parseInt(arr[0]);
        int b = Integer.parseInt(arr[1]);
        int c = Integer.parseInt(arr[2]);
        System.out.println("Ищем квадратные корни. Параметры: " + a + ", " + b + ", " + c);
        int d = (b*b) - (4*a*c);
        System.out.println("Дискриминант = " + d);
        if(d < 0) {
            //нет корней
            System.out.println("Дискриминант не имеет корней");
        } else if(d == 0) {
            //1 корень
            double x =(-b + Math.sqrt((double) d)) / (2*a);
            System.out.println("x = " + x);
        }
        else if(d > 0) {
            //2 корня
            double x1 =(-b + Math.sqrt((double) d)) / (2*a);
            double x2 =(-b - Math.sqrt((double) d)) / (2*a);
            System.out.println("x1 = " + x1 + "\nx2 = " + x2);
        }
    }

    public static void printMatrix() {
        System.out.println("Введите число для вывода матрицы: ");
        int i = Util.getInt();
        int[][] arr = new int[i][i];
        int counter = 1;
        for (int j = 0; j < i; j++) {
            for (int k = 0; k < i; k++) {
                arr[j][k] = counter++;
            }
        }
        for (int j = 0; j < i; j++) {
            for (int k = 0; k < i; k++) {
                System.out.print("\t" + arr[j][k]);
            }
            System.out.println();
        }
    }
}
