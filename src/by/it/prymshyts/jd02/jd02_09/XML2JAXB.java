package by.it.prymshyts.jd02.jd02_09;

import by.it.prymshyts.jd02.jd02_09.manual_pojo.Catalog;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.FileReader;

class XML2JAXB {
    public static void main(String[] args) {
        try {
            JAXBContext jaxbContext   = JAXBContext.newInstance(Catalog.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

            String fileName   = "src/by/it/prymshyts/jd02/jd02_09/catalog.xml";
            FileReader reader = new FileReader(fileName);

            System.out.println("XML прочитан.");
            Catalog catalog = (Catalog) unmarshaller.unmarshal(reader);

            System.out.println(catalog);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
