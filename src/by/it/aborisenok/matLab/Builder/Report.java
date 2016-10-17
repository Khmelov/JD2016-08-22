package by.it.aborisenok.matLab.Builder;

import java.sql.Time;
import java.util.ArrayList;

/**
 * Created by aborisenok on 17.10.2016.
 */
public class Report {
    private String reportName;
    private Time startTime;
    private Time endTime;
    private ArrayList<String> operation = new ArrayList<>();

    public String getReportName() {
        return reportName;
    }

    public void setReportName(String reportName) {
        this.reportName = reportName;
    }

    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public Time getEndTime() {
        return endTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }

    public ArrayList<String> getOperation() {
        return operation;
    }

    public void setOperation(ArrayList<String> operation) {
        this.operation = operation;
    }

    public void printReport(){
        System.out.println("--------------------------");
        System.out.println(getReportName());
        System.out.println("--------------------------");
        System.out.println("Start time : " + getStartTime());
        System.out.println("--------------------------");
        System.out.println("End time : " + getEndTime());
        System.out.println("--------------------------");
        for (String oper : getOperation()){
            System.out.println("Executed operation : " + oper);
        }
        System.out.println("--------------------------");

    }



}
