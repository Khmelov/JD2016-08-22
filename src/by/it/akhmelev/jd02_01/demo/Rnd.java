package by.it.akhmelev.jd02_01.demo;

import java.util.Random;

class Rnd {
    static final long init=System.currentTimeMillis();
    static final Random random = new Random(init);

    static int fromTo(int from, int to) {
        //вычислим время ожидания
        int delta=to-from+1;
        int msWait=from+random.nextInt(delta);
        return msWait;
    }
}
