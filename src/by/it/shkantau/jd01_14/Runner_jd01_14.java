package by.it.shkantau.jd01_14;

import java.io.IOException;
import java.util.Arrays;

public class Runner_jd01_14 {

    public static void main(String[] args) {

//        System.out.println(Arrays.toString(System.getProperties().entrySet().toArray()));

        try {
            Tasks14.taskA();
            Tasks14.taskB();


        } catch (IOException e) {
            System.out.println(e.toString());
        }

        Tasks14.taskC();



    }

}
