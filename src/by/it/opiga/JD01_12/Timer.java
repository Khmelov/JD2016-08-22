package by.it.opiga.JD01_12;

import com.sun.org.apache.bcel.internal.generic.RET;

/**
 * Created by Asus on 28.09.2016.
 */
public class Timer {
    private long iniTimer;
    private Double Delta;
    public Timer(){iniTimer=System.nanoTime();}
    public String toString()
    {
        Delta=(double) (System.nanoTime()-iniTimer)/1000;
        iniTimer=System.nanoTime();
        return "прошло "+Delta.toString()+" микросекунд";
    }

}
