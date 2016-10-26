package by.it.snegurskiy.jd02_09.generate;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * Created by Acer on 26.10.2016.
 */
public class JAXB {
    public static void main(String[ ] args) {
        try {

            JAXBContext jc = JAXBContext.newInstance(Users.class);
            Unmarshaller u = jc.createUnmarshaller();
            FileReader reader = new FileReader("src/by/it/snegurskiy/jd02_09/generate/user+xsd.xml");
            System.out.println("XML-файл прочитан:");
            Users user = (Users) u.unmarshal(reader);
            System.out.println(user);

        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
