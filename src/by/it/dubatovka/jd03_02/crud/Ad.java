package by.it.dubatovka.jd03_02.crud;


import java.lang.*;
import java.lang.Object;

public class Ad {
    private int id;
    private String subject;
    private String description;
    private int fk_zia;
    private int fk_status;
    private int fk_user;
    private int fk_priority;

    public Ad() {
    }

    public Ad(int id, String subject, String description, int fk_zia, int fk_status, int fk_user, int fk_priority) {
        this.id = id;
        this.subject = subject;
        this.description = description;
        this.fk_zia = fk_zia;
        this.fk_status = fk_status;
        this.fk_user = fk_user;
        this.fk_priority = fk_priority;
    }

    public Ad(String subject, String description, int fk_zia, int fk_status, int fk_user, int fk_priority) {

        this.subject = subject;
        this.description = description;
        this.fk_zia = fk_zia;
        this.fk_status = fk_status;
        this.fk_user = fk_user;
        this.fk_priority = fk_priority;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getFk_zia() {
        return fk_zia;
    }

    public void setFk_zia(int fk_zia) {
        this.fk_zia = fk_zia;
    }

    public int getFk_status() {
        return fk_status;
    }

    public void setFk_status(int fk_status) {
        this.fk_status = fk_status;
    }

    public int getFk_user() {
        return fk_user;
    }

    public void setFk_user(int fk_user) {
        this.fk_user = fk_user;
    }

    public int getFk_priority() {
        return fk_priority;
    }

    public void setFk_priority(int fk_priority) {
        this.fk_priority = fk_priority;
    }

    @Override
    public String toString() {
        return "Ad{" +
                "id=" + id +
                ", subject=" + subject + '\'' +
                ", description=" + description + '\'' +
                ", fk_zia=" + fk_zia +
                ", fk_status=" + fk_status +
                ", fk_user=" + fk_user +
                ", fk_priority=" + fk_priority +
                "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ad)) return false;

        Ad ad = (Ad) o;

        if (id != ad.id) return false;
        if (fk_zia != ad.fk_zia) return false;
        if (fk_status != ad.fk_status) return false;
        if (fk_user != ad.fk_user) return false;
        if (fk_priority != ad.fk_priority) return false;
        if (!subject.equals(ad.subject)) return false;
        if (!description.equals(ad.description)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + subject.hashCode();
        result = 31 * result + description.hashCode();
        result = 31 * result + fk_zia;
        result = 31 * result + fk_status;
        result = 31 * result + fk_user;
        result = 31 * result + fk_priority;
        return result;
    }
}
