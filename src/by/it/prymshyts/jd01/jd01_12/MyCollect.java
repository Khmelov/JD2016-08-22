package by.it.prymshyts.jd01.jd01_12;

import java.util.Collection;
import java.util.ArrayList;

public class MyCollect {

    static <E> Collection<E> getCross(Collection<E> collectionOne, Collection<E> collectionTwo) {
        Collection<E> cross = new ArrayList<>(collectionOne);
        cross.retainAll(collectionTwo);
        return cross;
    }

    static <E> Collection<E> getUnion(Collection<E> collectionOne, Collection<E> collectionTwo) {
        Collection<E> union = new ArrayList<>(collectionOne);
        union.addAll(collectionTwo);
        return union;
    }
}