package by.it.dubatovka.jd02_01;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

 enum Good {
    Молоко, Хлеб, Сыр, Яблоки, Шоколад, Кофе;

    private static final List<Good> VALUES = Arrays.asList(values());
    private static final int SIZE = VALUES.size();
    private static Random RANDOM = new Random();

    public static Good random() {
        return VALUES.get(RANDOM.nextInt(SIZE));
    }
}