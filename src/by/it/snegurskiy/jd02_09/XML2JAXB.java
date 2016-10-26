package by.it.snegurskiy.jd02_09;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class XML2JAXB {
    public static void main(String[ ] args) {
        try {

            JAXBContext jc = JAXBContext.newInstance(Users.class);
            Unmarshaller u = jc.createUnmarshaller();
            FileReader reader = new FileReader("src/by/it/snegurskiy/jd02_09/user+xsd.xml");
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
