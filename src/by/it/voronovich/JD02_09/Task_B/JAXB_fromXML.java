package by.it.voronovich.JD02_09.Task_B;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class JAXB_fromXML {
    public static void main(String[] args) {
        try {

            JAXBContext jc = JAXBContext.newInstance(WebStore.class);
            Unmarshaller u = jc.createUnmarshaller();
            FileReader reader = new FileReader("src/by/it/voronovich/JD02_09/Task_B/WebStore.xml");
            System.out.println("XML-файл прочитан:");
            WebStore webStore = (WebStore) u.unmarshal(reader);
            System.out.println(webStore);

        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}