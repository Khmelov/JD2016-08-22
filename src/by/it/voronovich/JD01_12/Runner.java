package by.it.voronovich.JD01_12;

import java.io.IOException;
import java.util.*;

import static by.it.voronovich.JD01_12.Task_A.Task_A1.task_A1;
import static by.it.voronovich.JD01_12.Task_A.Task_A3.task_A3;
import static by.it.voronovich.JD01_12.Task_A.Util.getN;
import static by.it.voronovich.JD01_12.Task_A.MyCollect.getCross;
import static by.it.voronovich.JD01_12.Task_A.MyCollect.getUnion;
import static by.it.voronovich.JD01_12.Task_B.Data.getText;
import static by.it.voronovich.JD01_12.Task_B.Task_B1.task_B1;
import static by.it.voronovich.JD01_12.Task_B.Task_B2.processArray;
import static by.it.voronovich.JD01_12.Task_B.Task_B2.processLinked;
import by.it.voronovich.JD01_12.Task_C.Task_C1;

public class Runner {

    public static void main(String[] args) throws IOException {

        System.out.println("Задание А1: ");
        int size = getN();
        task_A1(size);
        System.out.println(" ");
        //-------------------------------->>>>>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<----------------------
        System.out.println("Задание А2: ");
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list1.add(i);
        }
        System.out.print("1-ое множество: ");
        System.out.println(list1);
        for (int i = 7; i < 15; i++) {
            list2.add(i);
        }
        System.out.print("2-ое множество: ");
        System.out.println(list2);
        String union = getUnion(list1, list2);
        System.out.println(union);
        String cross = getCross(list1, list2);
        System.out.println(cross);
        System.out.println(" ");
        //-------------------------------->>>>>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<----------------------
        System.out.println("Задание А3: ");
        task_A3();
        System.out.println(" ");
        //-------------------------------->>>>>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<----------------------
        System.out.println("Задание B1: ");
        task_B1(getText());
        System.out.println(" ");
        //-------------------------------->>>>>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<----------------------
        System.out.println("Задание B2: ");
        processArray();
        System.out.println(" ");
        processLinked();
        System.out.println(" ");
        //-------------------------------->>>>>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<----------------------
        System.out.println("Задание С1: ");
        TreeMap<Integer, String> a = Task_C1.Map(getText());
        System.out.println("Список1: ");
        Task_C1.printList(a);
        System.out.println(" ");
        a = Task_C1.compressedList(a);
        System.out.println("Список1 после сжатия: ");
        Task_C1.printList(a);
        System.out.println(" ");
    }
}