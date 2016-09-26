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
            System.err.println("Поймали ошибку Exception в main:" + e.getMessage());
        }
    }
    public static void A() throws Exception{
        System.err.println("A Start");
        try {
            B();
            int i = (int)(Math.random()*5);
            int value = 10/i;
        } catch (ArithmeticException e){
            System.err.println("Поймана ошибка деления на ноль. Процедура А");
        }
        System.err.println("A End");
    }

    public static void B() throws Exception{
        System.err.println("B Start");
        try {
            C();
            int i = (int)(Math.random()*5);
            if (i == 1){
                throw new IllegalArgumentException("Method B Exeption");
            } else {
                int value = 10/i;
            }
        } catch (ArithmeticException e){
            System.err.println("Поймана ошибка деления на ноль. Процедура В");
        }
        System.err.println("B End");

    }

    public static void C() throws Exception{
        System.err.println("C Start");
        int i = (int)(Math.random()*2);
        if (i == 1){
            throw new IllegalArgumentException("Method A Exeption");
        } else {
            int value = 10 / i;
        }
        try {
        } catch (ArithmeticException e){
            System.err.println("Поймана ошибка деления на ноль. Процедура С");
        }
        System.err.println("C End");
    }
}
