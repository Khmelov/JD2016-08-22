package by.it.voronovich.JD02_10.Task_B.Converter;

import javax.xml.bind.annotation.*;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "webStore", propOrder = {
        "clients"
})

public class WebStore {

    @XmlElement(required = true)
    private Clients clients = new Clients();

    //конструктор без параметров
    public WebStore() {
    }

    public WebStore(Clients clients) {
        this.clients = clients;
    }

    public Clients getClients() {
        return clients;
    }

    public void setClients(Clients clients) {
        this.clients = clients;
    }
    //преобразование в строку
    @Override
    public String toString() {
        return "Список клиентов" + clients;
    }

    //сравнение
    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    //хэшкод
    @Override
    public int hashCode() {
        return super.hashCode();
    }
}