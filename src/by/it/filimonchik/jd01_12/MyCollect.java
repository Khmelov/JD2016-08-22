package by.it.filimonchik.jd01_12;

import java.util.HashSet;

/**
 * Created by Raman.Filimonchyk on 31/10/2016.
 */
public class MyCollect {

    static HashSet<Integer> getCross(HashSet<Integer> a, HashSet<Integer> b) {
        HashSet<Integer> r = new HashSet<>( a );
        r.retainAll( b );
        return r;
    }

    static HashSet<Integer> getUnion(HashSet<Integer> a, HashSet<Integer> b) {
        HashSet<Integer> r = new HashSet<>( a );
        r.addAll( b );
        return r;
    }
}