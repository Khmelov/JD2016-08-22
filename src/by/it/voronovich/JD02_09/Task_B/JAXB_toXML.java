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
        //creating Room objects
        ArrayList<Client> list = new ArrayList<>();
        Client client = new Client("Derek", "Serx");
        list.add(client);
        client = new Client("Stan", "Marshal");
        list.add(client);
        client = new Client("Coni", "Demiko");
        list.add(client);
        //creating Rooms object
        Clients clients = new Clients();
        clients.setList(list);
        //creating Hotel object
        WebStore webStore = new WebStore();
        webStore.setClients(clients);

        try {
            // create JAXB context and initializing Marshaller
            JAXBContext context = JAXBContext.newInstance(WebStore.class);
            Marshaller marshaller = context.createMarshaller();
            //specify the location and name of xml file to be created
            File file = new File("src/by/it/voronovich/JD02_09/Task_B/WebStore.xml");
            // writing to XML file
            marshaller.marshal(webStore, new FileOutputStream(file));
            System.out.println("XML-файл создан");
            // writing to console
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(webStore, System.out);
        } catch (FileNotFoundException e) {
            System.out.println("XML-файл не может быть создан: " + e);
        } catch (JAXBException e) {
            System.out.println("JAXB-контекст ошибочен " + e);
        }
    }
}