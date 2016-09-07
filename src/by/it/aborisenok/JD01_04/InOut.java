package by.it.aborisenok.JD01_04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Лёша on 06.09.2016.
 */
public class InOut {
    /**
     * Метод служит для ввода одномерного массива с консоли
     */
    public static double[] inputLineArray() throws IOException {
        System.out.println("Введите строку чисел");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = reader.readLine();
        reader.close();
        double[] array  = lineToArray(line);
        return array;
    }

    /**
     * Метод служит для ввода двухмерного массива с консоли
     */
    public static double[][] inputDoubleArray() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите количество строк");
        int countLine = Integer.parseInt(reader.readLine());
        System.out.println("Введите количество столбцов");
        int countColumns = Integer.parseInt(reader.readLine());
        // инициализируем массив заданного размера
        double[][] doubleArray = new double[countLine][countLine];
        // заполняем массив
        for (int i = 0; i < countLine; i++) {
            String line = reader.readLine();
            doubleArray = lineToDoubleArray(doubleArray, line, i);
        }
        reader.close();
        return doubleArray;
    }

    /**
     * Метод служит для преобразование строки в одномерный массив
     *
     * @param line срока двухмерного массива
     */
    private static double[] lineToArray(String line){
        //деление строки на элементы массива по пробелам
        String[] strArray = line.split(" ");
        //создаем и заполняем массив чисел
        double[] array = new double[strArray.length];
        for(int j = 0; j < strArray.length; j++)
        {
            array[j] = Double.parseDouble(strArray[j]);
        }
        return array;
    }

    /**
     * Метод служит для преобразование строк в двухмерный массив
     *
     * @param doubleArray входной двухмерный  массив
     * @param line срока двухмерного массива
     * @param i номер передаваемой строки
     */
    private static double[][] lineToDoubleArray(double[][] doubleArray, String line, int i){
        //деление строки на элементы массива по пробелам
        String[] strArray = line.split(" ");
        //создаем и заполняем массив чисел
        double[] array = new double[strArray.length];
        // заполняем i-ую строку массива числами
        for(int j = 0; j < strArray.length; j++)
        {
            array[j] = Double.parseDouble(strArray[j]);
            doubleArray[i][j] = array[j];
        }
        return doubleArray;
    }
    /**
     * Метод служит для вывода на консоль одномерного массива
     *
     * @param array входной одномерный массив
     * @param name имя массива
     */
    public static void printLineArray(double[] array, String name) {
        for (int i = 0; i < array.length; i++) {
            System.out.printf("%s[% -3d]=%-4.2f ", name, i, array[i]);
        }
        System.out.println();
    }
    /**
     * Метод служит для вывода на консоль двухмерного массива
     *
     * @param array входной одномерный массив
     * @param name имя массива
     */
    public static void printDoubleArray(double[][] array, String name) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++){
                System.out.printf("%s[%- 3d, %- 3d]=%-4.2f ", name, i, j, array[i][j]);
            }
            System.out.println();
        }
    }
}
