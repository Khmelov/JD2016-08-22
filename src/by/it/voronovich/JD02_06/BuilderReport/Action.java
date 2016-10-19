package by.it.voronovich.JD02_06.BuilderReport;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Action {

    private Action() {}

    private static PrintWriter instance = null;

    public static PrintWriter getInstance (){
        if (instance == null){
            String path = System.getProperty("user.dir") + "/src/by/it/voronovich/" + "JD02_06/BuilderReport/builderReport.txt";
            try {
                instance = new PrintWriter(new FileWriter(new File(path),true));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return instance;
    }
}