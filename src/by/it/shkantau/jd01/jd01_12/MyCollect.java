package by.it.shkantau.jd01.jd01_12;

import java.util.Set;


 class MyCollect {
//        A2. Определить два множества (A и B) на основе целых чисел. Создать отдельный класс MyCollect и
//        статические методы в нем для определения пересечения множеств getCross и объединения множеств
//        getUnion. Показать работу этих методов на примере двух множеств (A и B).
    public static <T extends Number> Set<T> getCross(Set<T> A, Set <T> B){
        A.retainAll(B);
        return  A;
    }

    public static <T extends Number> Set<T> getUnion(Set <T> A, Set <T> B){
        A.addAll(B);
        return A;
    }
}
