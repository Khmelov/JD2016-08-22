package by.it.grechishnikov.matLab.model.report;

public class Reporter {
    private SmallReport smallReporter;
    private BigReport bigReporter;

    public void setReports(SmallReport small, BigReport big) {
        this.smallReporter = small;
        this.bigReporter = big;
    }

    public void addRequest(String request) {
        smallReporter.setRequest(request);
    }

    public void addResult(String result) {
        bigReporter.setResult(result);
    }

    public void printSmallReport() {
        smallReporter.printOperation();
    }

    public void printBigReport() {
        bigReporter.printOperation();
    }
}
