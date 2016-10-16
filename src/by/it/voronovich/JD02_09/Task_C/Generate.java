package by.it.voronovich.JD02_09.Task_C;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Generate {
    public static void main(String[] args) {
        try {

            JAXBContext jc = JAXBContext.newInstance(WebStore.class);
            Unmarshaller u = jc.createUnmarshaller();
            FileReader reader = new FileReader("src/by/it/voronovich/jd02_09/Task_C/WebStore.xml");
            System.out.println("XML-файл прочитан:");
            WebStore hotel = (WebStore) u.unmarshal(reader);
            System.out.println(hotel);

        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}