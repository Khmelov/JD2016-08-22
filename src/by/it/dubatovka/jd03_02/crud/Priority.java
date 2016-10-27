package by.it.dubatovka.jd03_02.crud;

public class Priority {
    private int idPriority;
    private String priorityName;

    public Priority() {
    }

    public Priority(int idPriority, String priorityName) {
        this.idPriority = idPriority;
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

    public int getIdPriority() {
        return idPriority;
    }

    public void setIdPriority(int idPriority) {
        this.idPriority = idPriority;
    }

    @Override
    public String toString() {
        return "Priority{" +
                "idPriority=" + idPriority +
                ", priorityName='" + priorityName + '\'' +
                '}';
    }

}
