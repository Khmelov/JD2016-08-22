package by.it.aborisenok.matLab.System;

import by.it.aborisenok.matLab.System.HashMapper;
import by.it.aborisenok.matLab.System.OneVarParser;
import by.it.aborisenok.matLab.Vars.*;

import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by aborisenok on 06.10.2016.
 */
public class ValueCash {

    private static String src = System.getProperty("user.dir") + "\\src\\by\\it\\aborisenok\\matLab\\ValueCash.txt";

    public static void writeCashInFile(HashMap<String, Var> hashMap){
        try( BufferedWriter writer = new BufferedWriter(new FileWriter(src, true))) {
            Iterator<Map.Entry<String, Var>> iterator = hashMap.entrySet().iterator();
            while (iterator.hasNext())
            {
                Map.Entry<String, Var> pair = iterator.next();
                String key = pair.getKey();
                Var var = pair.getValue();
                writer.write(key + "=" + var.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("File not find");
        }
    }

    public static void readCashFromFile(){
        try(BufferedReader reader = new BufferedReader(new FileReader(src))) {
            String line;
            while ((line = reader.readLine()) != null){
                String[] arr = line.split("=");
                String key = arr[0];
                Var var = OneVarParser.parseOneVar(arr[1]);
                HashMapper.setVeriable(key, var);
            }
        } catch (IOException e){
            System.err.println("File not find");
        }
    }
}
