package by.it.shkantau.mathlab.util.printer;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.Scanner;

/**
 * Created by Aliaksei on 12.09.2016.
 */
public class ConsolePrinter implements PrinterScanner {
    private static final String calcMessage1 = "Type the expression or exit \"\\q\" : ";
    private InputStream inputStream;
    private Scanner scanner = new Scanner(System.in);

    public ConsolePrinter(InputStream inputStream) {
        this.inputStream = inputStream;
        scanner = new Scanner(this.inputStream);
    }

    @Override
    public void print(String str){
        System.out.println(str);
    }

    @Override
    public String read() {
        print(calcMessage1);
        return scanner.nextLine().replaceAll("\\s+","");
    }

}
