package by.it.aborisenok.matLab.Builder;

/**
 * Created by aborisenok on 17.10.2016.
 */
public class ReportDirector {
    private ReportBuilder reportBuilder;

    public void setReportBuilder(ReportBuilder rb) {
        reportBuilder = rb;
    }
    public Report getReport() { return reportBuilder.getReport(); }

    public void constructReport() {
        reportBuilder.createNewReport();
        reportBuilder.reportName();
        reportBuilder.reportStartTime();
        reportBuilder.reportOperation();
        reportBuilder.reportEndTime();
    }
}
