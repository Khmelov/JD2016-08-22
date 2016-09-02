package by.it.prymshyts.jd01_06;

public class Runner {

    public static void main(String[] args) {

        System.out.println(Data.poem);
        String result = TaskA.t1(Data.poem);
        System.out.println(result + "\n");

        TaskA.t2(Data.poem);
        TaskA.t3(Data.poem);
    }
}
