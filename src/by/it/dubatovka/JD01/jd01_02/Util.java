package by.it.dubatovka.JD01.jd01_02;


import java.util.Scanner;

public class Util {


    static public String getLineConsole() {         //объявляем метод getLineConsole(), экземпляр класса не создаем ()
        Scanner scanner = new Scanner(System.in);   //тело метода, ({...} stin в шаблоне). Sistem.in сканирует консоль
        String line = scanner.nextLine();           //создаем line в ней храниться строка с клавиатуры.
        // scanner.close();                            //закрываем поток для чтения
        return line;                                //возвращаем line в то место, откуда вызывается метод
    }

    static public int[] getIntArray(String line) {          //создаем метод который создает числовой массив из строки
        String arrayString[] = line.split(" ");              //создаем массив строк, из элементов строки разделеных по пробелам
        int[] intArray = new int[arrayString.length];       //создаем массив чисел result длиной как массив строк
        for (int i = 0; i < arrayString.length; i++) {      //Цикл перебирающий элементы массива от первого до последнего
            intArray[i] = Integer.parseInt(arrayString[i]); //записываем в массив result числа из массива строк
        }
        return intArray;                                    //возвращаем нашему методу result
    }

    public static void printMatrix(int a[][]) {

        for (int i = 0; i < a.length; i++) {
            System.out.println();
            for (int j = 0; j < a[i].length; j++) {
                if (a[i][j] >= 0) System.out.print(" ");
                System.out.print(a[i][j] + " ");
            }
        }
    }
}
