package by.it.akhmelev.project.java;

import java.io.PrintStream;

public class test {
    public static void main(String[] args) {
        PrintStream out=System.out;
        Integer count=45;
        int step=10;
        String url="?start=";
        out.println("PAGE:");
        for (int i = 0; i < count/step; i++) {
            out.println(String.format("&nbsp<a href='%s=%d'>%d</a>",url,i*step,i));

        }
    }
}
