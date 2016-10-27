package by.it.dubatovka.jd03_02.crud;

public class Status {

    private int idStatus;
    private String status;

    public Status() {
    }

    public Status(int idStatus, String status) {
        this.idStatus = idStatus;
        this.status = status;
    }

    public Status(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getIdStatus() {
        return idStatus;
    }

    @Override
    public String toString() {
        return "Status{" +
                "idStatus=" + idStatus +
                ", status='" + status + '\'' +
                '}';
    }

   }
