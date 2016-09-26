package by.it.prymshyts.jd02.jd02_03;

import by.it.prymshyts.jd01.jd01_02.Util;

public class Good {
    private String name = "Товар №" + Util.getRandomNum(1, 50);
    private int cost = Util.getRandomNum(1, 1000);

    String getName() {
        return name;
    }

    int getCost() {
        return cost;
    }
}
