package by.it.prymshyts.matlab;

class BriefReportBuilder extends ReportBuilder {

    @Override
    void saveToLog(String s) {
        getLog().add(s);
    }

    @Override
    void addTitle() {
        getReport().setTitle("\n-----Краткий отчёт-----");
    }

    @Override
    void addStartTime() {
        getReport().setStartTime("Начало работы: " + getDate() + "\n");
    }

    @Override
    void addEndTime() {
        getReport().setEndTime("Конец работы: " + getDate());
    }

    @Override
    void addOperationLog() {
        StringBuilder sb = new StringBuilder();

        for (String log: getLog()) {
            sb.append(log).append(System.lineSeparator());
        }

        getReport().setOperationLog(sb.toString());
    }
}
