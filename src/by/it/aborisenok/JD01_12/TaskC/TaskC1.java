package by.it.aborisenok.JD01_12.TaskC;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by Лёша on 20.09.2016.
 */
public class TaskC1 {

    {
        System.out.println("***TaskC1");
        listZIP();
    }
    /**
     * Метод служит для создания списка объектов с уникальными шифрами
     * @param list входное выражение типа String
     */
    public  static TreeMap<String, String> orderListCreation(String list){
        //создали массив из строки
        String[] array = list.split(",");
        TreeMap<String, String> objectList = new TreeMap<>();
        // заполнили список ключами и объектами
        for (String element : array){
            String code = getUniqueCode();
            String object = element.trim();
            objectList.put(code, object);
        }
        System.out.println("Начальный список объектов: " + objectList);
        return objectList;
    }
    /**
     * Метод служит для удаления из карты ключей с повторяющимися объектами
     */
    public static void listZIP(){
        // создали список объектов
        TreeMap<String, String> objectList = orderListCreation(TextForTask.carsList);
        HashMap<String, String> zipList = new HashMap<>();
        // заносим значения в новый список, меняя местами пару ключ-значение, тем самым удалим дублирующиеся зачения
        for (Map.Entry<String, String> pair : objectList.entrySet())
        {
            String code = pair.getKey();
            String object = pair.getValue();
            zipList.put(object, code);
        }
        //очищаем первоначальный список, что бы не создавать новый
        objectList.clear();
        // зполняем его парами, поменяв их местами как было первоначально
        for (Map.Entry<String, String> pair : zipList.entrySet())
        {
            String object = pair.getKey();
            String code = pair.getValue();
            objectList.put(code, object);
        }
        System.out.println("Сжатый список объектов: " + objectList);
    }
    /**
     * Метод служит для создания уникального(до поры до времени) шифра
     */
    public static String getUniqueCode(){
        int code = (int) (Math.random()*10000);
        String uniqueCode = String.valueOf(code);
        return uniqueCode;
    }

}
