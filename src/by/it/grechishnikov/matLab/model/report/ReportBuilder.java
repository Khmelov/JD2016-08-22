package by.it.grechishnikov.matLab.model.report;

public abstract class ReportBuilder {
    static String result;
    static String request;

    public abstract void printOperation();

    public void setRequest(String request) {
        this.request = request;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
