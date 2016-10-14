package by.it.prymshyts.matlab;

import java.util.ArrayList;
import java.util.Date;

abstract class ReportBuilder {

    private Report report;
    private ArrayList<String> log = new ArrayList<>();

    Report getReport() {
        return report;
    }

    void createNewReport() {
        report = new Report();
    }

    protected String getDate() {
        return new Date(System.currentTimeMillis()).toString();
    }

    protected ArrayList<String> getLog() {
        return log;
    }

    abstract void saveToLog(String s);
    abstract void addTitle();
    abstract void addStartTime();
    abstract void addOperationLog();
    abstract void addEndTime();
}
