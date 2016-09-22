package by.it.filimonchik.jd01_08;

/**
 * Created by Raman.Filimonchyk on 21/09/2016.
 */
public class Main {
    public static void main (String [] args){
        BlackPrinter blackPrinter=new BlackPrinter();
        blackPrinter.on();
        blackPrinter.showState();
        blackPrinter.print();
        blackPrinter.setLevel(101);
        blackPrinter.showState();
        blackPrinter.off();
        blackPrinter.showState();

    }
}
