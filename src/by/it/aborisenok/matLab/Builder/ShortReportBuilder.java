package by.it.aborisenok.matLab.Builder;

import by.it.aborisenok.matLab.System.WorkInformation;

import java.util.ArrayList;

/**
 * Created by aborisenok on 17.10.2016.
 */
public class ShortReportBuilder extends ReportBuilder {
    @Override
    public void reportName() {
        report.setReportName("Short Report");
    }

    @Override
    public void reportStartTime() {
        report.setStartTime(WorkInformation.getStartTime());
    }

    @Override
    public void reportOperation() {
    }

    @Override
    public void reportEndTime() {
        report.setEndTime(WorkInformation.getEndTime());
    }
}
