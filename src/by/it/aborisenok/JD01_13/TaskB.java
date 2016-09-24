package by.it.aborisenok.JD01_13;

import java.util.AbstractList;

/**
 * Created by Лёша on 24.09.2016.
 */
public class TaskB {
    public static void run(){
        try {
            TaskB.A();
        } catch (Exception e){
            System.err.println("Поймали ошибку Exception в main");
        }
    }
    public static void A() throws Exception{
        System.err.println("A Start");
        int value = 10/(int)(Math.random()*2);
        try {
            B();
        } catch (ArithmeticException e){
            System.err.println("Ошибка деления на ноль в методе A");
        }
        System.err.println("A End");
    }

    public static void B() throws Exception{
        System.err.println("B Start");
        int value = 10/(int)(Math.random()*2);
        try {
            C();
        } catch (ArithmeticException e){
            System.err.println("Ошибка деления на ноль в методе B");
        }
        System.err.println("B End");

    }

    public static void C() throws Exception{
        System.err.println("C Start");
        int value = 10/(int)(Math.random()*2);
        try {
        } catch (ArithmeticException e){
            System.err.println("Ошибка деления на ноль в методе С");
        }
        System.err.println("C End");
    }
}
