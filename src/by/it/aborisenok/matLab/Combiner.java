package by.it.aborisenok.matLab;

import by.it.aborisenok.matLab.System.HashMapper;
import by.it.aborisenok.matLab.System.Parser;
import by.it.aborisenok.matLab.System.ValueCash;
import by.it.aborisenok.matLab.Vars.Var;

import java.util.Scanner;

/**
 * Created by aborisenok on 06.10.2016.
 */
public class Combiner {
    public static void start(){
        Scanner scanner=new Scanner(System.in);
        String line;
        Parser parser=new Parser();
        ValueCash.readCashFromFile();
        while ((line=scanner.nextLine())!=null) {
            if (line.toLowerCase().equals("exit"))
                System.exit(0);
            if (line.toLowerCase().equals("print")) {
                System.out.println(HashMapper.getHashMap());
                System.exit(0);
            }
            Var var = parser.doCalc(line);
            System.out.println(var);
            ValueCash.writeCashInFile(HashMapper.getHashMap());
        }
    }
}
