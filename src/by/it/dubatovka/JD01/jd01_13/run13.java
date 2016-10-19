package by.it.dubatovka.JD01.jd01_13;

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


