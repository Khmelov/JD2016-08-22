package by.it.dubatovka.project_helpdesk.java.beans;

public class Status {

    private int ID;
    private String statusName;

    public Status() {
    }

    public Status(int ID, String statusName) {
        this.ID = ID;
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

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    @Override
    public String toString() {
        return "Status{" +
                "ID=" + ID +
                ", statusName='" + statusName + '\'' +
                '}';
    }

   }
