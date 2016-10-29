package by.it.filimonchik.jd02_10.Task_B;

import javax.xml.bind.annotation.*;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "diller", propOrder = {
        "name",
        "nickname"
})

public class Diller {

    @XmlElement(required = true)
    private String name;
    @XmlElement(required = true)
    private String nickname;

    public Diller() {
    }
    public Diller(String name, String nickname) {
        this.name = name;
        this.nickname = nickname;
    }
    public String getName() {
        return name;
    }
    public String getLastName() {
        return nickname;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setLastName(String nickname) {
        this.nickname = nickname;
    }
    @Override
    public String toString() {
        return   "Name: " + name + ", AutoModel: " + nickname;
    }
}



