package by.it.grechishnikov.matLab.model.report;

abstract class ReportBuilder {
    static String result;
    static String request;

    public abstract void printOperation();

    void setRequest(String message) {
        request = message;
    }

    void setResult(String message) {
        result = message;
    }
}
