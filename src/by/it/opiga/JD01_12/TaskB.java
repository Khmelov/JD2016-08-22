package by.it.opiga.JD01_12;

import java.io.*;
import java.util.*;

public class TaskB {
    public static void main(String[] arg) {

//        //Задание В1
        String srcFile = System.getProperty("user.dir");
        String textfile = srcFile + "\\src\\by\\it\\opiga\\JD01_12\\text.txt";
        File tFile = new File(textfile);
        HashMap<String, Integer> hm = new HashMap<>();
        Integer i;
        try {
            BufferedReader text = new BufferedReader(new InputStreamReader(new FileInputStream(tFile), "utf-8"));
            while (text.ready()) {
                String s = text.readLine();
                String[] words = s.split("[^A-Za-z']+");
                for (String k : words) {
                    //System.out.println(k);
                    if (!k.isEmpty()) {
                        if (!hm.containsKey(k))
                            hm.put(k, 1);
                        else {
                            i = hm.get(k);
                            i++;
                            hm.put(k, i);
                        }
                    }
                }
            }
            text.close();
        } catch (IOException e) {
            System.out.println("Конец файла " + e.getMessage());
        }
        Set<Map.Entry<String, Integer>> sethm = hm.entrySet();
        //System.out.println(sethm);
        Iterator<Map.Entry<String, Integer>> iset = sethm.iterator();
        while (iset.hasNext()) {
            Map.Entry<String, Integer> me = iset.next();
            System.out.println(me.getKey() + " : " + me.getValue());
        }
        //Задание В2
        int n = 10;
        Integer[] circle = {1,2,3,4,5,6,7,8,9,10};
        List<Integer>base=Arrays.asList(circle);
        ProcessArray.processArray(base,n);
        ProcessLinked.processLinked(base,n);


    }
}
