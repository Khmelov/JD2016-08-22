package by.it.voronovich.JD01_13.Task_B;

import static by.it.voronovich.JD01_13.Task_B.Task_B1.firstMethod;
import static by.it.voronovich.JD01_13.Task_B.Task_B1.secondMethod;
import static by.it.voronovich.JD01_13.Task_B.Task_B1.thirdMethod;

public class Runner {

    public static void main(String[] args) {
        try {
            firstMethod();  // замените firstMethod на secondMethod и thirdMethod и убедитесь в корректности проброса ошибки
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}