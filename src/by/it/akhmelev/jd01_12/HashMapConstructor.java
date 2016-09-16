package by.it.akhmelev.jd01_12;

import java.util.*;

public class HashMapConstructor {
    public static void main(String[] args) {
        LinkedHashMap<Integer,String> hashMap=new LinkedHashMap<Integer, String>(10,0.75f,true){
            @Override
            protected boolean
                 removeEldestEntry(Map.Entry<Integer,String> eldest) {
                //тут можно сравнить с capacity
                return super.removeEldestEntry(eldest);
            }
        };
        hashMap.put(1,"a");
        hashMap.put(2,"a");
        hashMap.put(3,"a");
        System.out.println(hashMap);

        hashMap.get(1);
        System.out.println(hashMap);

        hashMap.get(2);
        hashMap.get(1);
        System.out.println(hashMap);
    }
}
