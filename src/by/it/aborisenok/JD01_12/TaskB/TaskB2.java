package by.it.aborisenok.JD01_12.TaskB;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Лёша on 19.09.2016.
 */
public class TaskB2 {

    {
        System.out.println("***TaskB2");
        ArrayList<Integer> arrayList = new ArrayList<>();
        LinkedList<Integer> linkedList = new LinkedList<>();
        Timer timer = new Timer();
        TaskB2.listCreating(arrayList, 1000);
        System.out.println("Заполнение ArrayList элементами." + timer);
        TaskB2.listCreating(linkedList, 1000);
        System.out.println("Заполнение LinkedList элементами." + timer);
        TaskB2.processArray(arrayList);
        System.out.println("Удаление элементов из ArrayList." + timer);
        TaskB2.prоcessLinked(linkedList);
        System.out.println("Удаление элементов из LinkedList." + timer);
    }

    public static void listCreating(List<Integer> list, int elemAmount){
        for (int i = 0; i < elemAmount; i++){
            list.add(i + 1);
        }
    }
    public static void processArray(ArrayList<Integer> arrayList){
        boolean count = true;
        while (arrayList.size() != 1){
            Iterator<Integer> iterator = arrayList.iterator();
            while (iterator.hasNext()) {
                iterator.next();
                if (count == true) {
                    count = false;
                } else {
                    count = true;
                    iterator.remove();
                }
            }
            //   System.out.println(arrayList); //возможность выводить состояние списка чисел после каждого круга
        }
    }

    public static void prоcessLinked(LinkedList<Integer> linkedList){
        boolean count = true;
        while (linkedList.size() != 1){
            Iterator<Integer> iterator = linkedList.iterator();
            while (iterator.hasNext()) {
                iterator.next();
                if (count == true) {
                    count = false;
                } else {
                    count = true;
                    iterator.remove();
                }
            }
            //   System.out.println(linkedList); //возможность выводить состояние списка чисел после каждого круга
        }
    }
}
