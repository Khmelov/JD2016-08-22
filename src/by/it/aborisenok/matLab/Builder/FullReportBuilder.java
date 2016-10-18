package by.it.aborisenok.matLab.Builder;

import by.it.aborisenok.matLab.System.WorkInformation;

/**
 * Created by aborisenok on 17.10.2016.
 */
public class FullReportBuilder extends ReportBuilder {
    @Override
    public void reportName() {
        report.setReportName("Full Report");
    }

    @Override
    public void reportStartTime() {
        report.setStartTime(WorkInformation.getStartTime());
    }

    @Override
    public void reportOperation() {
        report.setOperation(WorkInformation.getFullOperation());
    }

    @Override
    public void reportEndTime() {
        report.setEndTime(WorkInformation.getEndTime());
    }
}
