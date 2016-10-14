package by.it.prymshyts.matlab;

class Report {

    private String title;
    private String startTime;
    private String endTime;
    private String operationLog;

    void setTitle(String title) {
        this.title = title;
    }

    void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    void setOperationLog(String operationLog) {
        this.operationLog = operationLog;
    }

    String getTitle() {
        return title;
    }

    String getStartTime() {
        return startTime;
    }

    String getEndTime() {
        return endTime;
    }

    String getOperationLog() {
        return operationLog;
    }
}
