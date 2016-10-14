package by.it.prymshyts.matlab;

class Reporter {

    private ReportBuilder reportBuilder;

    void saveToReport(String s) {
        reportBuilder.saveToLog(s);
    }

    void setReportBuilder(ReportBuilder reportBuilder) {
        this.reportBuilder = reportBuilder;
    }

    Report getReport() {
        return reportBuilder.getReport();
    }

    void constructReport() {
        reportBuilder.createNewReport();
        reportBuilder.addTitle();
        reportBuilder.addStartTime();
        reportBuilder.addOperationLog();
        reportBuilder.addEndTime();
    }

    void printReport() {
        this.constructReport();
        Console.println(reportBuilder.getReport().getTitle());
        Console.println(reportBuilder.getReport().getStartTime());
        Console.println(reportBuilder.getReport().getOperationLog());
        Console.println(reportBuilder.getReport().getEndTime());
    }
}
