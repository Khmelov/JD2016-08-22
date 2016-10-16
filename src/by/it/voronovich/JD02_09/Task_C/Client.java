package by.it.voronovich.JD02_09.Task_C;

import javax.xml.bind.annotation.*;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "client", propOrder = {
        "name",
        "lastName"
})

public class Client {

    @XmlElement(required = true)
    private String name;
    @XmlElement(required = true)
    private String lastName;

    //конструктор без параметров
    public Client() {
    }

    public Client(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
    }

    //геттеры
    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }


    //сеттеры
    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    //преобразование в строку
    @Override
    public String toString() {
        return  "\n" + " Имя: " + name + ", Фамилия: " + lastName;
    }
}