package by.it.grechishnikov.jd02_10;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.io.StringWriter;

public class TaskB {
    private static Gson gson = new GsonBuilder().serializeNulls().setPrettyPrinting().create();

    public static void main(String[] args) {
        //Объект Person в XML
        String xml = init();
        System.out.println("Person в XML:\n" + xml);

        //XML в JSON
        Person person = xmlToObject(xml);
        String JSON = objectToJson(person);
        System.out.println("Person в JSON:\n" + JSON + "\n");

        //Обратно
        person = jsonToObject(JSON);
        xml = objectToXml(person);
        System.out.println("Person в XML:\n" + xml);

    }

    private static String init() {
        Person person = new Person();
        person.setFirstName("Evgeniy");
        person.setLastName("Grechishnikov");
        person.setAge(23);
        return objectToXml(person);
    }

    private static Person xmlToObject(String XML) {
        StringReader reader = new StringReader(XML);
        try {
            JAXBContext context = JAXBContext.newInstance(Person.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            return (Person) unmarshaller.unmarshal(reader);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static Person jsonToObject(String JSON) {
        return gson.fromJson(JSON, Person.class);
    }

    private static String objectToXml(Person person) {
        StringWriter writer = new StringWriter();
        try {
            JAXBContext jaxb = JAXBContext.newInstance(Person.class);
            Marshaller marshaller = jaxb.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(person, writer);
            return writer.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static String objectToJson(Person person) {
        return gson.toJson(person);
    }
}
