package by.it.snegurskiy.jd02_01;

/**
 * Created by snegurskiy.nn on 26.09.2016.
 */
public class TimeHelper {
    static int random(int from, int to){
        int res=from+(int)Math.round(Math.random()*(to-from));
        return res;
    }
}
