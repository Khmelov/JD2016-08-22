package by.it.shkantau.mathlab.util;

import by.it.shkantau.mathlab.calc.Equation;
import by.it.shkantau.mathlab.calc.Operand.Var;
import by.it.shkantau.mathlab.calc.exceptions.MathLabException;

import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ResultLoaderSaver {

    public static Map<String, Var> load(String fileName) throws IOException, MathLabException {
        Map<String, Var> result = new HashMap<>();
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        String line;
        while ((line=br.readLine())!=null){
            line = line.replaceAll("\\s","");
            if (!line.isEmpty()) {
                Equation equation = new Equation(line);
                equation.calc();
                result.put(equation.getResultName(), equation.getResult());
            }
        }
        br.close();
        return result;
    }

    public static void  save(Map<String, Var> map , String fileName) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
        Iterator iterator = map.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry entry = (Map.Entry)iterator.next();
            bw.write(entry.getKey() + "=" + entry.getValue() + "\n");
        }
        bw.flush();
        bw.close();
    }

}
