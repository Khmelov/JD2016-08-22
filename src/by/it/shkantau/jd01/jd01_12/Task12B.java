package by.it.shkantau.jd01.jd01_12;

import by.it.shkantau.jd01.jd01_06.Regexes;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

 class Task12B {
    private static Pattern pattern;
    private static Matcher matcher;
    private static Iterator<Integer> iterator;


//    B1. Задать текст на английском языке (100 и более слов). Вывести все различные слова. Для каждого слова
//    подсчитать частоту его встречаемости. Слова, отличающиеся регистром букв, считать различными.
//    Использовать класс HashMap.
    public static void b1 (String text){
        System.out.println("\nTaskB1");
        List<String > words = new ArrayList<>(100);
        pattern = Pattern.compile(Regexes.regexEnglishWord);
        matcher = pattern.matcher(text);

        while (matcher.find()){
            words.add(matcher.group());
        }
        Set<String> unique = new HashSet<>(words);
        for (String key : unique) {
            System.out.println(key + ": " + Collections.frequency(words, key));
        }
    }

//    B2. В кругу стоят N человек, пронумерованных от 1 до N. При ведении счета по кругу вычеркивается каждый
//    второй человек, пока не останется один. Составить два метода processArray и prоcessLinked
//    моделирующие процесс. Первый должен использовать класс ArrayList, а второй — LinkedList. Какой из
//    двух методов работает быстрее? Почему? Докажите. (см. пример на слайдах).
    public static void b2 (int peopleCount){
        Integer [] arrOrInteger = generateArrayOfIntegers(peopleCount);
        System.out.println("Process time to ArrayList = " + processList( new ArrayList<>(Arrays.asList(arrOrInteger))) + " usec");
        System.out.println("Process time to LinkedList = " + processList( new LinkedList<>(Arrays.asList(arrOrInteger))) + " usec");
    }


// Private functions
    /**
     * Returns a time in milliseconds needed to remove every second
     * element in a while loop until the size of the collections is equal one;
     */
    private static long processList(List<Integer> list){
        int deletedIndex;
        long taskStarted = System.nanoTime();

        while (list.size() > 1){
            deletedIndex = 0;
            iterator = list.iterator();
            while (iterator.hasNext()) {
                deletedIndex++;
                iterator.next();
                if (deletedIndex%2 == 0) {
                    iterator.remove();
                }
            }
        }
        return (System.nanoTime() - taskStarted)/1000;

    }

    private static Integer[] generateArrayOfIntegers(int count){
        Integer [] array = new Integer[count];
        for (int i = 0; i < count; i++) {
            array[i] = i + 1;
        }
        return array;
    }

}
