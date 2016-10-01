package by.it.grechishnikov.jd02_03;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ThreadLocalRandom;

class Good {
    private static CopyOnWriteArrayList<Good> goods = new CopyOnWriteArrayList<>();
    private String name;
    private double price;

    static {
        goods.add(new Good("сыр", 5.99));
        goods.add(new Good("молоко", 2.0));
        goods.add(new Good("мясо", 10.45));
        goods.add(new Good("водка", 5.79));
        goods.add(new Good("хлеб", 1.1));
        goods.add(new Good("сахар", 2.5));
        goods.add(new Good("кортофель", 2.33));
    }

    private Good(String name, double price) {
        this.name = name;
        this.price = price;
    }

    static Good getRandomGood() {
        int index = ThreadLocalRandom.current().nextInt(0, goods.size());
        return goods.get(index);
    }

    public String getName() {
        return name;
    }

    double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return getName();
    }
}