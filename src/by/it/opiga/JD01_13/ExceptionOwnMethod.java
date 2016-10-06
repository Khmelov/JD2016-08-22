package by.it.opiga.JD01_13;

import java.util.ArrayList;
import java.util.Scanner;

public class ExceptionOwnMethod {
    public static void main(String[] arg) {
        //задание А
        ArrayList<Integer> arr = new ArrayList<>();
        Scanner scan = new Scanner(System.in);
        String tmp = scan.nextLine();
        double sum = 0;
        int num = 0;
        while (!tmp.equals("END")) {
            try {
                num = Integer.parseInt(tmp);
                arr.add(num);
                sum += Math.sqrt(num);
                System.out.println("Число: " + num + "\nсумма корней ранее введеных чисел: " + sum);

            } catch (NumberFormatException e) {
                System.out.print("недопустимое преобразование строки в число  ");
                System.out.println(e.getMessage());
            }
            finally {
                if (tmp.equals("END")) scan.close();
                else
                    tmp = scan.nextLine();
            }
        }
        System.out.println(arr);
    }
}
