package by.it.voronovich.JD02_06.BuilderReport;

import java.io.PrintWriter;

public abstract class BuilderReport {

    protected PrintWriter printWriter = Action.getInstance();

    public void buildHeader(String header){
        printWriter.println(header);
    }

    void start (){  }

    void end(){ }

    void action(String operation){  }

}