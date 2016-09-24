package by.it.dubatovka.jd01_13;

/**
 * Created by Dubatovka Sergey on 23.09.2016.
 */
public class run13 {
    public static void main(String[] args) {

        TaskA_1.aException();

        //задача B
        try {
            System.out.println("\n//TaskB");
            TaskB.one();
        } catch (Exception e) {
            System.out.println("Ошибка. Поймал в main " + e.getMessage());
        }
    }
}


