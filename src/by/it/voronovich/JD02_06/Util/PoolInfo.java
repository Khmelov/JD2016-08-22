package by.it.voronovich.JD02_06.Util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static by.it.voronovich.JD02_04.Operation.KeyMapper.checkingName;
import static by.it.voronovich.JD02_04.Operation.KeyMapper.checkingVar;
import static by.it.voronovich.JD02_04.Parser.bracketsArrangement;
import static by.it.voronovich.JD02_04.Parser.checkingExp;

/**
 * Класс отвечает за потоки чтения информации с консоли и
 * печати информации на консоль
 *
 * @author Voronovich Dmitry
 * @version 1.0
 */
public class PoolInfo {

    /**
     * Ввод с консоли
     *
     * @return строка
     */
    public String in() throws IOException {
        BufferedReader line = new BufferedReader(new InputStreamReader(System.in));
        String out = line.readLine();
        return out;
    }

    /**
     * Вывод на консоль
     *
     * @param str строка
     */
    public void out(String str) {
        if (str != null) {
            System.out.println(str);
        } else System.out.println("The expression is not valid!");
    }

    /**
     * Проверка корректности ввода
     *
     * @return строка
     */
    public static String inspection() throws IOException {
        PoolInfo inout = new PoolInfo();
        String str = inout.in();
        if (!checkingExp(str) || !bracketsArrangement(str)) {
            System.out.println("The expression is not valid! Try again");
            str = inspection();
        }
        if (!checkingVar(str)) {
            System.out.println("The expression is not valid! Try again");
            str = inspection();
        }
        if (!checkingName(str)) {
            System.out.println("Rewrite? <YES> | <NO>:");
            String l = inout.in();
            if (l.equals("NO")) {
                str = inspection();
            } else if (!l.equals("NO") && !l.equals("YES")) {
                System.out.println(" <YES> | <NO> ");
            }
        }
        return str;
    }

    /**
     * Продолжение/завершение вычислений
     *
     * @return true/false
     */
    public static boolean checkInput(String str) throws IOException {
        PoolInfo inout = new PoolInfo();
        boolean input = false;
        label:
        while (!str.equals("YES") || !str.equals("NO")) {
            System.out.println("Finish calculate? <YES> | <NO>");
            str = inout.in();
            switch (str) {
                case "NO":
                    input = true;
                    break label;
                case "YES":
                    input = false;
                    break label;
                default:
                    System.out.println("Choose <YES> | <NO>");
                    break;
            }
        }
        return input;
    }
}