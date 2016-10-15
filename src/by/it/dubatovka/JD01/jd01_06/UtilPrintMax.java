package by.it.dubatovka.JD01.jd01_06;

/**
 * Created by Dubatovka Sergey on 15.09.2016.
 */
public class UtilPrintMax {

    public static void print (String [] arrStr, int [] arrLenOfStr){
        System.out.println();

        //ищем самое  длинное предложение и выводим его на печать.
        // Чтобы снова не найти уже выведенное макс значение, зануляем его
        for (int j = 0; j < arrLenOfStr.length; j++) {
            int x = 0;  //индекс строки с макс количеством слов
            int max = -1;
            for (int i = 0; i < arrStr.length; i++) {
                if (max < arrLenOfStr[i]) {
                    max = arrLenOfStr[i];
                    x = i;
                }
            }
            arrLenOfStr[x] = Integer.MIN_VALUE;
            System.out.println(arrStr[x]);
        }
    }

//    public static void printAlf (String [] arrStr, int [] arrLenOfStr){
//        System.out.println();
//
//        //ищем самое  длинное предложение и выводим его на печать.
//        // Чтобы снова не найти уже выведенное макс значение, зануляем его
//
//            int max = Integer.MIN_VALUE;
//            for (int i :arrLenOfStr)
//                if (max<i) max=i;
//
//            while (max>0){
//                for (int i = 0; i < arrLenOfStr.length; i++) {
//                   int x=-1;
//                    int y=-1;
//                    if (arrLenOfStr[i]==max){
//                        if (-1==x) x=i;
//                        else if (-1==y) y=i;
//                        else
//
//
//
//
//                    }
//
//                }
//                max--;
//
//
//
//
//            for (int i = 0; i < arrStr.length; i++) {
//                if (max < arrLenOfStr[i]) {
//                    max = arrLenOfStr[i];
//                    x = i;
//                }
//            }
//            arrLenOfStr[x] = Integer.MIN_VALUE;
//            System.out.println(arrStr[x]);
//        }
//    }

}
