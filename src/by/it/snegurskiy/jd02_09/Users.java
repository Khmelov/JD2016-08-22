package by.it.snegurskiy.jd02_09;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

@XmlRootElement
public class Users {
    @XmlElement(name="user")
    private ArrayList<User> list = new ArrayList<User>();
    public Users() {
        super();
    }
    public void setList(ArrayList<User> list) {
        this.list = list;
    }
    public boolean add(User user) {
        return list.add(user);
    }
    @Override
    public String toString() {
        return "Students [list=" + list + "]";
    }
}

