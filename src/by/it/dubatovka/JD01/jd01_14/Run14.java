package by.it.dubatovka.JD01.jd01_14;

import java.io.IOException;

public class Run14 {

    public static void main(String[] args) throws IOException {

        try {
            TaskA.taskA();
            System.out.println();
            TaskB.taskB();
        } catch (IOException e) {
            System.out.println("Ошибка файла " +e);
        }
    }
}
