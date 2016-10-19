package by.it.dubatovka.jd02_03;

import java.util.Random;


class Rnd {

    private static final long init = System.currentTimeMillis();
    private static final Random random = new Random(init);

    static int fromTo(int from, int to) {
        return (random.nextInt(to - from) + from + 1);
    }
}
