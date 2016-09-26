package by.it.shkantau.jd01_13;

import java.util.Scanner;

public class TaskA {

    private static Scanner scanner = new Scanner(System.in);

//    Вариант А. Создать программу с использованием двух типов обработки исключений,которая
//    § открывает консоль;
//    § считывает данные из консоли построчно;
//    § переводит каждую строку в число и выводит в консоль данное число и сумму корней всех ранее введенных чисел, включая введенное;
//    § если перевести ввод в число невозможно или невозможно извлечь корень, то программа обрабатывает ошибку и показывает на русском языке соответствующее сообщение в консоли;
//    § закрывается при вводе в консоль слова END.

     static void run() {
        String readString;
        Double res = 0.0 ;
        Double d;
        System.out.println("This simple program calculate a sum of the square roots from typed numbers.");
        System.out.println("To exit type END and press enter");
        while(true){
            readString = scanner.nextLine();
            if (readString.equals("END")) {
                break;
            } else {

                try {
                     d = Double.parseDouble(readString);
                    if (d < 0.0) {
                        throw new ArithmeticException();
                    }
                }catch (NumberFormatException e){
                    d = null;
                    System.out.println("Can't convert \""+ readString +"\" to Double");
                }catch (ArithmeticException e){
                    d = null;
                    System.out.println("Square root from negative numbers is not defined!");
                }
                if(d != null) {
                    res += Math.sqrt(d);
                    System.out.println("d=" + d + ", sqrt(d)=" + Math.sqrt(d) + ", res = " + res);
                }
        }
    }
}

}
