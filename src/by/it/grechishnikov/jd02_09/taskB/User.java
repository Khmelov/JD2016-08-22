package by.it.grechishnikov.jd02_09.taskB;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlType(name = "User")
public class User {
    @XmlAttribute(name = "nickname", required = true)
    private String nickname;
    @XmlAttribute(name = "password", required = true)
    private String password;
    private String email;
    private List<Goods> order = new ArrayList<>();

    public User() {
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Goods> getOrder() {
        return order;
    }

    public void setOrder(List<Goods> order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "user : " + nickname + ", email : " + email + "\norder : " + order;
    }
}
