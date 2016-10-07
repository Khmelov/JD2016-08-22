package by.it.shkantau.jd01.jd01_02;

import java.util.Scanner;

class Task_JD01_02B {

    public static void b(String[] args){
//1. Определить принадлежность некоторого значения k интервалу [n, m].
        isBelongTo(5, 7, 8);
//2. Вывести числа от 1 до k в виде матрицы N x N слева направо и сверху вниз (k выберите квадратом целого числа).
        printMatrix();
//3. Найти корни квадратного уравнения. Параметры уравнения передавать с командной строкой
        calcQuadricEquation(args);
//4. Ввести число от 1 до 12. Вывести на консоль название месяца, соответствующего данному числу. Осуществить проверку корректности ввода чисел.
        getDate(4);
    }

    private static void isBelongTo(double min, double max, double number){
        if (min >= max) {
            System.out.println("Wrong interval");
            return;
        }
        System.out.print("number " + number +" is ");
        if (number < min || number > max){
            System.out.print("don't ");
        }

        System.out.println("belong to interval [" + min + " ; " + max + "]" );
    }

    public static void printMatrix() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Type number i (dimension of matrix [i][i]) : ");
        int i ;

        while(true) {
            String str = scanner.nextLine();
            try {
                i =  Integer.parseInt(str);
                break;
            } catch (Exception e) {
                System.out.println(e.toString() + ".\nPlease, type again a right number");
            }
        }

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

    private static void calcQuadricEquation(String[] args) {

        double a, b, c ;
        if (args.length < 3) {
            System.out.println("Wrong numbers of argument");
            return;
        }else{
            try {
                a = Double.parseDouble(args[0]);
                b = Double.parseDouble(args[1]);
                c = Double.parseDouble(args[2]);
            }catch (NumberFormatException e){
                System.out.println(e.toString() +  " is not valid number");
                return;
            }
        }
        System.out.println("QuadricEquation y(x) = "+a+"*x^2 + " + b+ "*x + " + c);
        double D = Math.sqrt((Math.pow(b, 2.0) - 4 * a * c));
        if (D > 0) {
            System.out.println("Quadric roots is  [" + (-b + D) / (2 * a) + ";" + (-b - D) / (2 * a) +"]");
        } else if (D == 0){
            System.out.println("Quadric root is  " + (-b ) / (2 * a));
        }else {
            System.out.println("There is no roots");
        }
    }

    private static String getDate(int month) {

        String currentMonth;

        switch (month) {
            case 1:
                currentMonth = "January";
                break;
            case 2:
                currentMonth = "February";
                break;
            case 3:
                currentMonth = "March";
                break;
            case 4:
                currentMonth = "April";
                break;
            case 5:
                currentMonth = "May";
                break;
            case 6:
                currentMonth = "June";
                break;
            case 7:
                currentMonth = "July";
                break;
            case 8:
                currentMonth = "August";
                break;
            case 9:
                currentMonth = "September";
                break;
            case 10:
                currentMonth = "October";
                break;
            case 11:
                currentMonth = "November";
                break;
            case 12:
                currentMonth = "December";
                break;
            default:
                currentMonth = "Wrong month number";
                break;
        }

        return currentMonth;
    }

}
