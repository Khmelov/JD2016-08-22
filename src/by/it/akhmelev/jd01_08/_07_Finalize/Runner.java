package by.it.akhmelev.jd01_08._07_Finalize;

import java.util.Objects;

public class Runner {
    public static void main(String[] args) {
        Manager d1 = new Manager(1);
        d1 = null;
        Manager d2 = new Manager(2);
        Object d3 = d2; // 1
        // Object d3 = new Manager (3); // 2
        d2 = d1;
        // просьба выполнить "сборку мусора"
        System.gc();
        goHeap(" "); //такой метод "угробит" heap.
        goStack(0);  //а вот такой метод "угробит" стек.
    }

    static void goHeap(String s) {
        while(true) s=s+s;
    }

    static void goStack(int level) {
        goStack(level);
    }
}