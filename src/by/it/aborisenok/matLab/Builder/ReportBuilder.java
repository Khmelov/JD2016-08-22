package by.it.aborisenok.matLab.Builder;

/**
 * Created by aborisenok on 17.10.2016.
 */
public abstract class ReportBuilder {
    Report report;

    public Report getReport(){
        return report;
    }
    void createNewReport(){
        report = new Report();
    }

    public abstract void reportName();
    public abstract void reportStartTime();
    public abstract void reportOperation();
    public abstract void reportEndTime();


}
