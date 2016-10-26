package by.it.snegurskiy.jd02_09;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class XML2JAXB {
    public static void main(String[ ] args) {
        try {
            JAXBContext jaxbContext   = JAXBContext.newInstance(User.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

            String fileName   = "src/by/it/snegurskiy/jd02/jd02_09/user+xsd.xml";
            FileReader reader = new FileReader(fileName);

            System.out.println("XML прочитан.");
            User user = (User) unmarshaller.unmarshal(reader);

            System.out.println(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
