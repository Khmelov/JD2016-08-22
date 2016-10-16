package by.it.aborisenok.JD02_09.TaskB;

import by.it.aborisenok.JD02_09.TaskC.Ticket;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * Created by Лёша on 16.10.2016.
 */
public class FromXML {
    public static void main(String[] args) {
        try {

            JAXBContext jc = JAXBContext.newInstance(Ticket.class);
            Unmarshaller u = jc.createUnmarshaller();
            FileReader reader = new FileReader("src/by/it/aborisenok/jd02_09/XML+XSD.xml");
            System.out.println("XML-файл прочитан:");
            Ticket ticket = (Ticket) u.unmarshal(reader);
            System.out.println(ticket);

        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
