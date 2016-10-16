package by.it.prymshyts.jd02.jd02_10.Task2;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;

class JSON2XML {
    public static void main(String[] args) {
        try {
            String JSONFile   = "src/by/it/prymshyts/jd02/jd02_10/Task2/catalog.json";
            FileReader reader = new FileReader(JSONFile);

            Gson GSON       = new GsonBuilder().create();
            Catalog catalog = GSON.fromJson(reader, Catalog.class);

            System.out.println("JSON прочитан.");

            JAXBContext context   = JAXBContext.newInstance(Catalog.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            String fileName = "src/by/it/prymshyts/jd02/jd02_10/Task2/catalogFromJSON.xml";
            marshaller.marshal(catalog, new FileOutputStream(fileName));

            System.out.println("XML создан.");

        } catch (FileNotFoundException e) {
            System.err.println("XML не может быть создан.");
        } catch (JAXBException e) {
            System.err.println("JAXB-контекст ошибочен.");
        }
    }
}
