package by.it.dubatovka.JD01.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Dubatovka Sergey on 15.09.2016.
 */
public class ZadanieB2 {

    public static void taskB_2(String data) {
        System.out.println("\n//Задание B2. Вывести предложения в порядке возрастания количества слов в каждом. Убрать переносы строк");
        System.out.println("");
        // массив содержащий предложения
        String[] arrStr = data.split("[.!?]+");
        //массив будет содержать кол-во слов в каждом предложении
        int[] arrLenOfStr = new int[arrStr.length];

        Pattern p = Pattern.compile("[а-яА-ЯёЁ]+");
        for (int i = 0; i < arrStr.length; i++) {
            Matcher m = p.matcher(arrStr[i]);
            int counter = 0;
            while (m.find()) counter++;
            // массив содержащий количество слов в предложениях
            arrLenOfStr[i] = counter;
        }

        for (int i = 0; i < arrLenOfStr.length; i++) {
            System.out.println("Количество слов в предложении " + (i + 1) + ": " + arrLenOfStr[i]);
        }
        //пилим текст на предложения, записывем снова в массив
        Pattern prelozheniya = Pattern.compile("([а-яА-ЯёЁ, ;:\n-]+)([.!?]+)");
        Matcher m1 = prelozheniya.matcher(data);
        int x = 0;
        while (m1.find()) {
            arrStr[x] = m1.group().replace('\n', ' ').trim();
            x++;
        }

        UtilPrintMax.print(arrStr, arrLenOfStr);
    }
}
