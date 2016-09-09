package by.it.aborisenok.JD01_05;

import java.util.ArrayList;

/**
 * Created by Лёша on 08.09.2016.
 */
public class Task6 {
    public static void solution(){

        System.out.println("Task 6");

        int count = 0;
        // определим число будущих элементов массива при выбранном
        // разбении в заданом интервале

        for (double x = 0; x < 8; x+=0.25) {
            count++;
        }

        double[] array = new double[count];
        //заполенние массива значениями функции
        double x = 0;
        for (int i = 0; i < array.length; i++) {
            array[i] = Math.log(Math.abs(x-12));
            x+=0.25;
        }

        // вывод массива в консоль
        int columnCount = (int) Math.round(Math.sqrt(array.length));
        int j = columnCount;
        System.out.println("Массив из значений функции.");
        for (int i = 0; i < array.length; i++) {

                System.out.printf("%s%s%-2d%s = %.3f ", "M" ,"[", i, "]", array[i]);
                j--;
                if (j == 0 ){
                    System.out.println();
                    j = columnCount;
                }
        }
        System.out.println();
        // вывод среднего арифметического последних 10 элементов
        double sum = 0;
        for (int i = 0; i < array.length; i++){
            if (array.length - i <= 10){
               sum += array[i];
            }
        }
        // вывод среднего арифметического значения
        System.out.printf("Среднее арифметическое последних 10 элементов равна - %.3f \n", sum/10);

        // сформируем новый массив из элементов кпатных 3
        // p.s. насколько я понял имеется в виду кратность индекса элемента
        // т.к. значения у нас никак не могут быть кратны 3

        // т.к. мы не знаем сколько элементов кратных 3 будет
        // то облегчим задачу воспользовавшись коллекциями
        ArrayList<Double> arrayList = new ArrayList<>();

        for (int i = 0; i < array.length; i++) {
            if (i%3 == 0 && i != 0){
             arrayList.add(array[i]);
            }
        }

        double[] newArray = new double[arrayList.size()];

        // перенесем все из ArrayList в массив примитивных типов
        for (int i = 0; i < arrayList.size(); i++) {
            newArray[i] = arrayList.get(i);
        }
        // выводим массив в консоль
        System.out.println("Массив из элементов чьи индексы были кратны 3");
        for (int i = 0; i < newArray.length; i++) {
            System.out.printf("%s%s%-2d%s = %.3f ", "M" ,"[", i, "]", newArray[i]);
        }
    }
}
