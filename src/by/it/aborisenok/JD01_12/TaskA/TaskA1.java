package by.it.aborisenok.JD01_12.TaskA;



import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Лёша on 16.09.2016.
 */
public class TaskA1 {
    //Task A
    {
        System.out.println("***Task A1");
        ArrayList<Integer> markList = Utils.randomInt(20);
        System.out.println(markList);
        ArrayList<Integer> goodMarkList = badMarkDelete(markList);
        System.out.println(goodMarkList);
    }
    //Метод удаляет неудовлетворительные оценки
    public ArrayList<Integer> badMarkDelete(ArrayList<Integer> list){
        ArrayList<Integer> newList = new ArrayList<>(list);
        Iterator<Integer> iterator = newList.iterator();
        while (iterator.hasNext()){
            if (iterator.next() < 4){
                iterator.remove();
            }
        }
        return newList;
    }
}
