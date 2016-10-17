package by.it.grechishnikov.jd02_09.taskB;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement
public class Store {
    private Admin admin;
    private List<User> user;

    public Store() {
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public List<User> getUser() {
        return user;
    }

    public void setUser(List<User> users) {
        this.user = users;
    }

    @Override
    public String toString() {
        return "admin : " + admin + "\nusers : " + user;
    }
}
