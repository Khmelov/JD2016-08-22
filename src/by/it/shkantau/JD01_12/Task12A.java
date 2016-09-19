package by.it.shkantau.JD01_12;

import java.util.*;


/**
 * Created by user on 16.09.2016.
 */
public class Task12A {
    /**
     *
     * @param studentsCount   Number of the students
     * @param marksSeparator  marks below this value are removed from the list (include this value)
     */
//    A1. Создать список оценок учеников с помощью ArrayList, заполнить случайными оценками. Удалить
//    неудовлетворительные оценки из списка. Вывести на консоль оба варианта.
    public static void a1( int studentsCount, int marksSeparator){
       List<Integer> marks = randomNumberGenerator(10,1,15);

        System.out.println("Marks before: " + marks + "\n");

        Iterator<Integer> iterator = marks.iterator();
        while (iterator.hasNext()){
            if(iterator.next() <= marksSeparator){
                iterator.remove();
            }
        }
        System.out.println("Marks after: " + marks);
    }


//        A2. Определить два множества (A и B) на основе целых чисел. Создать отдельный класс MyCollect и
//        статические методы в нем для определения пересечения множеств getCross и объединения множеств
//        getUnion. Показать работу этих методов на примере двух множеств (A и B).
    public static void a2( ){
        Set <Integer> setIntegerA = generateSetArray(-100,100,20);
        Set <Integer> setIntegerB = generateSetArray(-100,100,20);

        System.out.println("A=" + setIntegerA + "\nB=" + setIntegerB);
        MyCollect.getCross(setIntegerA, setIntegerB);
        if(setIntegerA.size() != 0){
            System.out.println("Cross elemetn of the collections is "+ setIntegerA);
        }else{
            System.out.println("There is no crosses elemetns in this collections");
        }

        System.out.println("The union of the collections = " + MyCollect.getUnion(setIntegerA, setIntegerB));
    }

//    A3. Не используя вспомогательных объектов (т.е. без обмена местами переменных), переставить
//    отрицательные элементы произвольного списка чисел в конец, а положительные — в начало списка.
    public static void a3( ){
        Set <Integer> setOfIntegers = new TreeSet<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        setOfIntegers.addAll( generateSetArray(-100,100,20));
        System.out.println("Reverse sorted set: " + setOfIntegers);
    }

    private static Set<Integer> generateSetArray(int max, int min, int count){
            Set<Integer> randomNumbers = new HashSet<>(count);
            for (int i = 0; i < count; i++) {
                randomNumbers.add(new Integer((int) ((max - min) * Math.random() + min)));
            }
            return randomNumbers;
    }

    public   static   List <Integer> randomNumberGenerator(int max, int min, int count) {
           List<Integer> randomNumbers = new ArrayList<>(count);
           for (int i = 0; i < count; i++) {
               randomNumbers.add(new Integer((int) ((max - min) * Math.random() + min)));
           }
           return randomNumbers;
    }

//   public static  <T extends Number>   List <T> randomNumberGenerator(T max, T min, int count){
//       List<Integer> randomNumbers = new ArrayList<>(count);
//       for (int i = 0; i < count; i++) {
//           randomNumbers.add((max  - min) * Math.random() + min);
//       }
//       return (List<T>) randomNumbers;
//   }

}
