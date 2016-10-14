package by.it.prymshyts.matlab;

class FullReportBuilder extends ReportBuilder {

    @Override
    void saveToLog(String s) {
        getLog().add(s);
    }

    @Override
    void addTitle() {
        getReport().setTitle("\n-----Полный отчёт-----");
    }

    @Override
    void addStartTime() {
        getReport().setStartTime("Начало работы: " + getDate());
    }

    @Override
    void addEndTime() {
        getReport().setEndTime("\nКонец работы: " + getDate());
    }

    @Override
    void addOperationLog() {
        StringBuilder sb = new StringBuilder();

        for (String log: getLog()) {
            sb.append(System.lineSeparator()).append("Время выполнения: ").append(getDate()).append(System.lineSeparator());
            sb.append(log);
        }

        getReport().setOperationLog(sb.toString());
    }
}
