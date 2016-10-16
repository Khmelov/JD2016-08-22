package by.it.voronovich.JD02_10.Task_C;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Clients", propOrder = {
        "client"
})

public class Clients {

    @XmlElement(required = true)

    private ArrayList<Client> client = new ArrayList<Client>();

    //конструктор без параметров
    public Clients() {
    }

    public Clients(ArrayList<Client> client) {
        this.client = client;
    }

    //сеттер
    public void setList(ArrayList<Client> client) {
        this.client = client;
    }

    //геттер
    public ArrayList<Client> getList() {
        return client;
    }

    public boolean add(Client value) {
        return client.add(value);
    }

    @Override
    public String toString() {
        return String.valueOf(client);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}