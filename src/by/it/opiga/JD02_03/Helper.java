package by.it.opiga.JD02_03;

/**
 * Created by Asus on 30.09.2016.
 */
public class Helper {

    static int random(int from,int to)
    { int res=from+(int)Math.round(Math.random()*(to-from));
        return res;
    }
}
