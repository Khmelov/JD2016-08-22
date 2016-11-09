package by.it.snegurskiy.Project.java.Bean;

public class Userstatus {
    private int id;
    private String status;

    public Userstatus() {
    }

    public Userstatus(int id, String status) {

        this.id = id;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Status{" +
                "id=" + id +
                ", status='" + status + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Userstatus)) return false;

        Userstatus role1 = (Userstatus) o;

        return id == role1.id && !(status != null ? !status.equals(role1.status) : role1.status != null);

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }
}