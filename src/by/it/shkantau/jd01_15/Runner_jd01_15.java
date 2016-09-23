package by.it.shkantau.jd01_15;

import java.io.IOException;

public class Runner_jd01_15 {

    public static void main(String[] args)  {

        Tasks.taskA();

        try {
            Tasks.taskC(System.getProperty("user.dir") + "/src/by/it/shkantau/");
        }catch (IOException e){
            System.out.println(e.toString());
        }
    }
}
