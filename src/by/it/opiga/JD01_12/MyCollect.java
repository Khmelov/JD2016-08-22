package by.it.opiga.JD01_12;

import sun.reflect.generics.tree.Tree;

import java.util.Iterator;
import java.util.TreeSet;

public class MyCollect {
    public static TreeSet<Integer> getUnion(TreeSet<Integer> a, TreeSet<Integer> b) {
        TreeSet<Integer> tmp = new TreeSet<Integer>();
        Iterator<Integer> i = a.iterator();
        while (i.hasNext()) {
            tmp.add(i.next());
        }
        i = b.iterator();
        while (i.hasNext()) {
            tmp.add(i.next());
        }
        return tmp;
    }

    public static TreeSet<Integer> getCross(TreeSet<Integer> a, TreeSet<Integer> b) {
        TreeSet<Integer> tmp = new TreeSet<Integer>();
        for (Integer k : a) {
            for (Integer p : b) {
                if (k.equals(p)) {
                    tmp.add(k);
                    break;
                }

            }
        }
        return tmp;
    }
}
