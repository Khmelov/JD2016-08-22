package by.it.voronovich.JD02_10.Task_B.Converter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.xml.bind.*;
import java.io.*;

public class Converter {

    public static WebStore XML_toJAXB(String filePath) throws IOException, JAXBException {

        JAXBContext jc = JAXBContext.newInstance(WebStore.class);
        Unmarshaller u = jc.createUnmarshaller();
        FileReader reader = new FileReader(filePath);
        WebStore webStore = (WebStore) u.unmarshal(reader);
        return webStore;
    }

    public static String JAXB_toJSON(WebStore webStore) {

        GsonBuilder builder = new GsonBuilder(); //Это строитель
        builder = builder.serializeNulls();        //в нем пишем что сериализуются null
        builder = builder.setPrettyPrinting();     //и вывод будет форматированный
        Gson gson = builder.create();
        String json = gson.toJson(webStore);
        System.out.println(json);
        return json;
    }

    public static WebStore JSON_toJAXB(String json) {

        GsonBuilder builder = new GsonBuilder(); //Это строитель
        builder = builder.serializeNulls();        //в нем пишем что сериализуются null
        builder = builder.setPrettyPrinting();     //и вывод будет форматированный
        Gson gson = builder.create();
        WebStore web = gson.fromJson(json, WebStore.class);
        return web;
    }

    public static void JAXB_toXML(WebStore webStore) throws JAXBException, IOException{

        JAXBContext context = JAXBContext.newInstance(WebStore.class);
        Marshaller marshaller = context.createMarshaller();
        File file = new File("src/by/it/voronovich/JD02_10/Task_B/FromJSON_WebStore.xml");
        marshaller.marshal(webStore, new FileOutputStream(file));
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        marshaller.marshal(webStore, System.out);
    }
}