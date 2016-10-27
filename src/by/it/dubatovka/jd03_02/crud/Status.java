package by.it.dubatovka.jd03_02.crud;

public class Status {

    private int idStatus;
    private String statusName;

    public Status() {
    }

    public Status(int idStatus, String statusName) {
        this.idStatus = idStatus;
        this.statusName = statusName;
    }

    public Status(String statusName) {
        this.statusName = statusName;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public int getIdStatus() {
        return idStatus;
    }

    public void setIdStatus(int idStatus) {
        this.idStatus = idStatus;
    }

    @Override
    public String toString() {
        return "Status{" +
                "idStatus=" + idStatus +
                ", statusName='" + statusName + '\'' +
                '}';
    }

   }
