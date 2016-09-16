package by.it.akhmelev.jd01_12;

import java.util.*;

public class SetWithComparator {
    public static void main(String[] args) {
        Set<Integer> hashset=new HashSet<>();
        Set<Integer> linkedset=new LinkedHashSet<>();
        Set<Integer> treeset=new TreeSet<>(
                new Comparator<Integer>() {
                    @Override
                    public int compare(Integer o1, Integer o2) {
                        return 0; //заменим штатный Integer.compare(o1,o2);
                    }
                }
        );
        treeset.add(5); hashset.add(5); linkedset.add(5);
        treeset.add(4); hashset.add(4); linkedset.add(4);
        treeset.add(3); hashset.add(3); linkedset.add(3);
        treeset.add(2); hashset.add(2); linkedset.add(2);
        treeset.add(1); hashset.add(1); linkedset.add(1);

        System.out.println("linkedset="+linkedset);
        System.out.println("hashset="+hashset);
        System.out.println("treeset="+treeset);
    }
}
