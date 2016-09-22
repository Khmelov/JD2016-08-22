package by.it.filimonchik.jd01_08;

/**
 * Created by Raman.Filimonchyk on 21/09/2016.
 */
abstract public class Printer implements IPrinter {
    boolean state = true;
    @Override
    public void on() {
        state = true;

    }

    @Override
    public void off() {
        state = false;

    }

    @Override
    public void print() {

    }
    public  boolean isState(){
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }
    public abstract void showState();
}
