package by.it.dubatovka.jd01_06;

import by.it.dubatovka.jd01_02.Util;

/**
 * Created by Dubatovka Sergey on 15.09.2016.
 */
public class ZadanieB3 {

    public static void taskB_3(String data) {
        System.out.println("\n//Задание B3. Отсортировать слова по убыванию количества вхождения заданного символа, а в случае равенства - по алфавиту");
        System.out.println("Введите символ:\n");
        String[] arrStr = data.split("[. ,;:-?!_\n-]+");
        int[] arrCounter = new int[arrStr.length];
        String line = Util.getLineConsole();
        char s = line.charAt(0);
        line = Integer.toString(s).toUpperCase();
        char sUpper = line.charAt(0);


       //проверим слова на вхождения заданного символа, посчитаем и запишем в массив arrCounter[] их количество
        for (int i = 0; i < arrStr.length; i++) {
            for (int j = 0; j < arrStr[i].length(); j++) {
                if (s == arrStr[i].charAt(j) || sUpper == arrStr[i].charAt(j))
                    arrCounter[i]++;
            }
        }

        String[] arrStrSort = new String[arrStr.length];
        String[] arrStrSortAlf = new String[arrStrSort.length];
        int[] arrIntSort = new int[arrStr.length];

        //ищем самое  длинное предложение и выводим его на печать.
        // Чтобы снова не найти уже выведенное макс значение, зануляем его

        for (int j = 0; j < arrCounter.length; j++) {
            int x = 0;  //индекс строки с макс количеством слов
            int max = -1;
            for (int i = 0; i < arrStr.length; i++) {
                if (max < arrCounter[i]) {
                    max = arrCounter[i];
                    x = i;
                }
            }
            arrIntSort[j] = arrCounter[x];
            arrCounter[x] = Integer.MIN_VALUE;
            arrStrSort[j] = arrStr[x];

        }
//        for (int i = 0; i < arrIntSort.length; i++) {
//            System.out.println(arrIntSort[i] + " " + arrStrSort[i]);
//        }

        //Получены сортированные массивы по количесвту вхождений
        //осталось отсортировать слова по алфавиту с одинаковым вхождением


        for (int i = 0; i < arrIntSort.length - 2; i++) {
            //если вхождений одинаковое количество среди соседних элементов, проверяем символы по алфавиту
            int k = 1;
           while (arrIntSort[i + k] == arrIntSort[i]) {
               int f = arrStrSort[i + k].compareToIgnoreCase(arrStrSort[i]);
               if (f < 0) {

                   String tmp = arrStrSort[i + k];
                   arrStrSort[i + k] = arrStrSort[i];
                   arrStrSort[i] = tmp;
                   k++;
                   if (i + k == arrIntSort.length - 1)
                       break;
               }
               k++;
               if (i + k == arrIntSort.length - 1) break;
           }
            arrStrSortAlf[i] = arrStrSort[i];
           System.out.println(arrStrSortAlf[i]);
       }
    }
    //Второй вариант вывода в алфавитном порядке
//
//
//            while (arrIntSort[i + k] == arrIntSort[i]) {
//                for (int j = 0; j < arrStrSort[i].length(); j++) {
//                    String word = arrStrSort[i].toLowerCase();
//                    String word1 = arrStrSort[i + k].toLowerCase();
//                    if (word.charAt(j) > word1.charAt(j)) {
//                        String tmp = arrStrSort[i + k];
//                        arrStrSort[i + k] = arrStrSort[i];
//                        arrStrSort[i] = tmp;
//                        k++;
//                        break;
//                    } else if (word1.charAt(j) > word.charAt(j)) {
//                        k++;
//                        break;
//                    }
//                }
//                k++;
//                if (i + k == arrIntSort.length - 1) break;
//            }
//            arrStrSortAlf[i] = arrStrSort[i];
//            System.out.println(arrStrSortAlf[i]);
//
//        }
//
//    }
}


