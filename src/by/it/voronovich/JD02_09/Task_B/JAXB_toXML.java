package by.it.voronovich.JD02_09.Task_B;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;

public class JAXB_toXML {
    public static void main(String[] args) {

        ArrayList<Client> list = new ArrayList<>();
        Client client = new Client("Derek", "Serx");
        list.add(client);
        client = new Client("Stan", "Marshal");
        list.add(client);
        client = new Client("Coni", "Demiko");
        list.add(client);

        Clients clients = new Clients();
        clients.setList(list);

        WebStore webStore = new WebStore();
        webStore.setClients(clients);

        try {
            JAXBContext context = JAXBContext.newInstance(WebStore.class);
            Marshaller marshaller = context.createMarshaller();
            File file = new File("src/by/it/voronovich/JD02_09/Task_B/WebStore.xml");
            marshaller.marshal(webStore, new FileOutputStream(file));
            System.out.println("XML-файл создан");
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(webStore, System.out);
        } catch (FileNotFoundException e) {
            System.out.println("XML-файл не может быть создан: " + e);
        } catch (JAXBException e) {
            System.out.println("JAXB-контекст ошибочен " + e);
        }
    }
}