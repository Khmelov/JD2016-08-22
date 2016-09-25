package by.it.voronovich.JD01_15;

import java.io.IOException;

public class Runner {

    public static void main(String[] args) throws IOException {

        System.out.println("Задание А1: ");
        Task_A1.task_A1();
        //_________________________________
        System.out.println("Задание B1: ");
        String filename = System.getProperty("user.dir") + "/src/by/it/voronovich/jd01_15/Task_B1.java";
        String filename_out = System.getProperty("user.dir") + "/src/by/it/voronovich/jd01_15/TaskB.txt";
        Task_B1.task_B1(filename, filename_out);
        //___________________________________________
    }
}
