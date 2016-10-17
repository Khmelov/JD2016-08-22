package by.it.prymshyts.jd02.jd02_10.Task2;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.FileReader;
import java.io.FileWriter;

class XML2JSON {
    public static void main(String[] args) {
        try {
            JAXBContext jaxbContext   = JAXBContext.newInstance(Catalog.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

            String fileName   = "src/by/it/prymshyts/jd02/jd02_10/Task2/catalog.xml";
            FileReader reader = new FileReader(fileName);
            Catalog catalog   = (Catalog) unmarshaller.unmarshal(reader);
            reader.close();

            System.out.println("XML прочитан.");

            Gson GSON   = new GsonBuilder().serializeNulls().setPrettyPrinting().create();
            String JSON = GSON.toJson(catalog);

            System.out.println("XML переведён в JSON");

            String JSONFile = "src/by/it/prymshyts/jd02/jd02_10/Task2/catalog.json";
            FileWriter writer = new FileWriter(JSONFile);
            writer.write(JSON);
            writer.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
