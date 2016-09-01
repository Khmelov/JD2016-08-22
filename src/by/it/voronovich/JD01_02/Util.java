package by.it.voronovich.JD01_02;

/**
 * Класс служит для ввода исходных параметров с клавиатуры
 * и для преобразования строки в массив
 *
 * @author Dmitry Voronovich
 * @version 1.0
 */

import java.io.*;

public class Util {

    /**
     * @return возвращает в метод строку чисел
     * @throws IOException
     */
    protected static String getOneLine() throws IOException {
        BufferedReader st = new BufferedReader(new InputStreamReader((System.in)));
        String line = st.readLine();
        return line;
    }

    /**
     * @param line значение строки на входе в метод
     * @return возвращает массив чисел
     */
    protected static int[] lineToArrayInt(String line) {
        String arrStr[] = line.split(" ");
        int[] arr = new int[arrStr.length];
        for (int i = 0; i < arrStr.length; i++) {
            arr[i] = Integer.parseInt(arrStr[i]);
        }
        return arr;
    }

    /**
     * @param line значение строки на входе в метод
     * @return возвращает массив строк
     */
    protected static String[] lineToArrayStr(String line) {
        String arrStr[] = line.split(" ");
        return arrStr;
    }

    /**
     * @return возвращает в метод значение k - число, задача B1
     * @throws IOException
     */
    protected static int getK() throws IOException {
        BufferedReader h1 = new BufferedReader(new InputStreamReader((System.in)));
        int k = Integer.parseInt(h1.readLine());
        return k;
    }

    /**
     * @return возвращает в метод значение n - нижняя граница промежутка, задача B1
     * @throws IOException
     */
    protected static int getN() throws IOException {
        BufferedReader h2 = new BufferedReader(new InputStreamReader((System.in)));
        int n = Integer.parseInt(h2.readLine());
        return n;
    }

    /**
     * @return возвращает в метод значение m - верхняя граница промежутка, задача B1
     * @throws IOException
     */
    protected static int getM() throws IOException {
        BufferedReader h3 = new BufferedReader(new InputStreamReader((System.in)));
        int m = Integer.parseInt(h3.readLine());
        return m;
    }

    /**
     * @return возвращает в метод значение l - размер матрицы, задача B2
     * @throws IOException
     */
    protected static int getL() throws IOException {
        BufferedReader h4 = new BufferedReader(new InputStreamReader((System.in)));
        int l = Integer.parseInt(h4.readLine());
        return l;
    }

    /**
     * @return возвращает в метод значение a - параметр квадратного уравнения, задача B3
     * @throws IOException
     */
    protected static int getА() throws IOException {
        BufferedReader h5 = new BufferedReader(new InputStreamReader((System.in)));
        int a = Integer.parseInt(h5.readLine());
        return a;
    }

    /**
     * @return возвращает в метод значение b - параметр квадратного уравнения, задача B3
     * @throws IOException
     */
    protected static int getB() throws IOException {
        BufferedReader h6 = new BufferedReader(new InputStreamReader((System.in)));
        int b = Integer.parseInt(h6.readLine());
        return b;
    }

    /**
     * @return возвращает в метод значение c - параметр квадратного уравнения, задача B3
     * @throws IOException
     */
    protected static int getC() throws IOException {
        BufferedReader h7 = new BufferedReader(new InputStreamReader((System.in)));
        int c = Integer.parseInt(h7.readLine());
        return c;
    }

    /**
     * @return возвращает в метод значение p - номер месяца, задача B4
     * @throws IOException
     */
    protected static int getP() throws IOException {
        BufferedReader h8 = new BufferedReader(new InputStreamReader((System.in)));
        int p = Integer.parseInt(h8.readLine());
        return p;
    }

    /**
     * @return возвращает в метод значение f - размер матрицы, задачи раздела С
     * @throws IOException
     */
    protected static int getF() throws IOException {
        BufferedReader h9 = new BufferedReader(new InputStreamReader((System.in)));
        int f = Integer.parseInt(h9.readLine());
        h9.close();
        return f;
    }

}
