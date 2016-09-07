package by.it.voronovich.JD01_06;

/**
 * Класс содержит тело метода для решения задачи 2 блока B
 *
 * @author Voronovich Dmitry
 * @version 1.0
 */
public class TaskB2 {

    /**
     * Метод располагает предложения по количеству слов, состовляющих его
     */
    public static void b2() {

        String text = Data.lukomorie.replace("\n", " ");

        String arr[] = text.split("[.!?]+\\s*");
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i].split(" ").length > arr[j].split(" ").length) {
                    String tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
            System.out.println(" ");
        }
    }
}
