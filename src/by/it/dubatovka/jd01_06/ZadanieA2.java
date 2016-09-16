package by.it.dubatovka.jd01_06;

/**
 * Created by Dubatovka Sergey on 13.09.2016.
 */
public class ZadanieA2 {

    //поиск повтора слов, рабочий метод. Быстрый вариант.

//    public static void povtorSlov(String data) {
// System.out.println("\n//Задание А2. Подсчет повторов слов");
//        String[] arrtext = data.split("[^а-яА-ЯёЁ]+");
//        for (int i = 0; i < arrtext.length - 1; i++) {
//            if (arrtext[i].length() > 0) {
//               // int[] povtorenie = new int[arrtext.length];
//                int povtorenie = 1;
//                for (int j = i + 1; j < arrtext.length; j++) {
//                    if (arrtext[i].equalsIgnoreCase(arrtext[j])) {
//                        arrtext[j] = "";
//                              povtorenie++;
//                    }
//                }
//                System.out.printf("%-28s%12s%-1s%3d", "Количество повторений слова", arrtext[i], ":", povtorenie);
//                System.out.println();
//            }
//        }
//    }

    //метод усложнил искусственно, чтобы потренироваться. (для практики). Выше закомментированный метод такой же  :)
    public static void povtorSlov(String data) {
        System.out.println("\n//Задание А2. Подсчет повторов слов");

        String[] arrtext = data.split("[^а-яА-ЯёЁ]+");
        int[] povtor= new int[arrtext.length];  //массив с числом повторений для каждого слова
        int max = 0;                            //максимальное число повторений

        for (int i = 0; i < arrtext.length; i++) {  //считаем повторы, определяем max кол-во повторов, заносим в массив
            if (arrtext[i].length() > 0) {
                int count = 1;
                for (int j = i + 1; j < arrtext.length; j++) {
                    if (arrtext[i].equalsIgnoreCase(arrtext[j])) {
                        arrtext[j] = "";
                        count++;
                    }
                }
                if (max < count) max = count;
                povtor[i] = count;
            }
        }
        for (int i = max; i > 0; i--) {         //выводим слова, начиная с максимального количества повторов
            int counter = 0;                    //флаг печати заголовка, только при значении 1
            int flag = 0;                       //флаг перехода на новую строку, после печати 8 слов
            for (int j = 0; j < povtor.length; j++) {
                if (povtor[j] == i) {
                    counter++;

                    if (1 == counter) {System.out.printf("%2d%-23s", i, " раз повторяются слова:");
                        System.out.println();}
                    System.out.printf("%-12s", arrtext[j]);
                    flag++;
                    if (8 == flag) {
                        System.out.println();
                        flag = 0;
                    }
                }
            }
            if (counter != 0) {
                System.out.println();
                System.out.println();

            }
        }
    }
}
