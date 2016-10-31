package by.it.snegurskiy.jd02_10;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.io.StringWriter;

public class B {
    private static Gson gson = new GsonBuilder().serializeNulls().setPrettyPrinting().create();

    public static void main(String[] args) {
        String xml = init();
        System.out.println("User в XML:\n" + xml);

        //XML в JSON
        User user = xmlToObject(xml);
        String JSON = objectToJson(user);
        System.out.println("User в JSON:\n" + JSON + "\n");

        //Обратно
        user = jsonToObject(JSON);
        xml = objectToXml(user);
        System.out.println("User в XML:\n" + xml);

    }

    private static String init() {
        User user = new User();
        user.setSurname("Ivanov");
        user.setName("Ivan");
        user.setLogin("Ivan9");
        return objectToXml(user);
    }

    private static User xmlToObject(String XML) {
        StringReader reader = new StringReader(XML);
        try {
            JAXBContext context = JAXBContext.newInstance(User.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            return (User) unmarshaller.unmarshal(reader);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static User jsonToObject(String JSON) {
        return gson.fromJson(JSON, User.class);
    }

    private static String objectToXml(User user) {
        StringWriter writer = new StringWriter();
        try {
            JAXBContext jaxb = JAXBContext.newInstance(User.class);
            Marshaller marshaller = jaxb.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(user, writer);
            return writer.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static String objectToJson(User user) {
        return gson.toJson(user);
    }
}
