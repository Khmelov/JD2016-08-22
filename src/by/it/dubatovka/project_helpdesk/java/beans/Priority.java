package by.it.dubatovka.project_helpdesk.java.beans;

public class Priority {
    private int ID;
    private String priorityName;

    public Priority() {
    }

    public Priority(int ID, String priorityName) {
        this.ID = ID;
        this.priorityName = priorityName;
    }

    public Priority(String priorityName) {
        this.priorityName = priorityName;
    }

    public String getPriorityName() {
        return priorityName;
    }

    public void setPriorityName(String priorityName) {
        this.priorityName = priorityName;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    @Override
    public String toString() {
        return "Priority{" +
                "ID=" + ID +
                ", priorityName='" + priorityName + '\'' +
                '}';
    }

}
