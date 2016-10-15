package by.it.dubatovka.jd02_02;

import java.util.Random;


class Rnd {
   static int fromTo(int from, int to) {
        Random random = new Random();
        return (random.nextInt(to - from) + from + 1);
    }
}
