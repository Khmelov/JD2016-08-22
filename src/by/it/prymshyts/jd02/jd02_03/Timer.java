package by.it.prymshyts.jd02.jd02_03;

public class Timer {

    private long startTime = 0;
    private long timeLapse = 0;

    Timer(long timeLapse) {
        this.timeLapse = timeLapse;
    }

    boolean tick() {
        if (startTime == 0) {
            startTime = System.currentTimeMillis();
        }
        return ((System.currentTimeMillis() - startTime) < timeLapse);
    }

    int workingTime() {
        return (int)(System.currentTimeMillis() - startTime + 1000) / 1000;
    }

    int getCurrentSecond() {
        if (startTime == 0) {
            startTime = System.currentTimeMillis();
        }
        return (int)(((System.currentTimeMillis() - startTime + 1000) % 60000) / 1000);
    }
}
