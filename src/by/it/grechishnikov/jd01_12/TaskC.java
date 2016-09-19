package by.it.grechishnikov.jd01_12;


import java.util.*;

/**
 * Задание С
 * @author Grechishnikov
 * @version 1.0
 */
public class TaskC {
    /**
     * Запуск задания
     */
    static void start() {
        taskC2();
        naOcenku();
    }

    /**
     * Задание С2
     * Создаем множества с неизвестными типами и выполняем задание А2
     */
    private static void taskC2() {
        Set firstSet = new HashSet<>();
        for (int i = 0; i < 10; i++) {
            String s = "y" + i;
            firstSet.add(s);
        }
        Set secondSet = new HashSet<>();
        for (int i = 5; i < 15; i++) {
            String s = "y" + i;
            secondSet.add(s);
        }
        System.out.println("Объеденыннеы множества:\n" + getUnion(firstSet, secondSet));
        System.out.println("Множество пересечения:\n" + getCross(firstSet, secondSet));
    }

    /**
     * Метод объеденения множеств с неизвестными типами
     * @param first - первое множество
     * @param last - второе множество
     * @param <T> - заранее неизвестный тип
     * @return - возвращаем объеденённое множество
     */
    private static <T> Set<T> getUnion(Set<T> first, Set<T> last) {
        Set<T> result = new HashSet<>(first);
        result.addAll(last);
        return result;
    }

    /**
     * Метод нахождения пересечений множеств с неизвестными типами
     * @param first - первое множество
     * @param last - второе множество
     * @param <T> - заранее неизвестный тип
     * @return - возвращаем множество пересечений
     */
    private static <T> Set<T> getCross(Set<T> first, Set<T> last) {
        Set<T> result = new HashSet<>(first);
        result.retainAll(last);
        return result;
    }

    /**
     * Метод на оценку
     * Создает TreeMap и HashMap и запускает тесты
     */
    private static void naOcenku() {
        Map<String, Integer> hashMap = new HashMap<>();
        Map<String, Integer> treeMap = new TreeMap<>();
        testAdd(hashMap);
        testAdd(treeMap);
        clearMap(hashMap);
        clearMap(treeMap);

    }

    /**
     * Метод тестирует скорость добавления элементов в карту
     * @param map - карта для теста
     */
    private static void testAdd(Map<String, Integer> map) {
        long start = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            String tmp = "FirstStringForTest. Value is " + i;
            map.put(tmp, i);
        }
        for (int i = 10000; i >= 0; i--) {
            String tmp = "SecondStringForTest. Value is " + i;
            map.put(tmp, i);
        }
        System.out.println("Время на добавление в " + map.getClass().getSimpleName() + " = " + (System.nanoTime() - start) + " наносекунд.");
    }

    /**
     * Метод для теста скорости очистки карты
     * @param map - карта для теста
     */
    private static void clearMap(Map<String, Integer> map) {
        long start = System.nanoTime();
        map.clear();
        System.out.println("Время на удаление в " + map.getClass().getSimpleName() + " = " + (System.nanoTime() - start) + " наносекунд.");
    }
}
