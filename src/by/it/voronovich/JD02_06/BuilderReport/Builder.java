package by.it.voronovich.JD02_06.BuilderReport;

public class Builder {

    private BuilderReport builderReport;

    public void setBuilderReport (BuilderReport builderReport) {
        this.builderReport = builderReport;
    }

    public void builder (String header, String action) {
        builderReport.buildHeader(header);
        builderReport.start();
        builderReport.action(action);
        builderReport.end();
    }
}