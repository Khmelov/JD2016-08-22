package by.it.opiga.JD03_02.CRUD;

/**
 * Created by Asus on 25.10.2016.
 */
public class GetTime {
    private static long unixTime;
    public static long getCurrentTime() {
        unixTime = System.currentTimeMillis();
        return unixTime;
    }
    public static long getTimeLeave() {
        long timeleave = unixTime + 15552000 * 20;
        return timeleave;
    }



}
