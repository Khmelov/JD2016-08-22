package by.it.shkantau.jd02.jd02_07.homework;

import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

public class XSDValidator {
    public final static String  xmlFileName = "src/by/it/shkantau/jd02/jd02_07/homework/airportXSD.xml";

    public static void main(String[] args) {
        String language = XMLConstants.W3C_XML_SCHEMA_NS_URI;

//
        String xsdFileName = "src/by/it/shkantau/jd02/jd02_07/homework/airport.xsd";
        SchemaFactory factory = SchemaFactory.newInstance(language);
        File xsdPath = new File(xsdFileName);

        try {
            Schema schema = factory.newSchema(xsdPath);
            Validator validator = schema.newValidator();
            Source source = new StreamSource(xmlFileName);
            validator.validate(source);
            System.out.println(xmlFileName + " is valid");

        } catch (SAXException e) {
            System.out.println("Validation "+xmlFileName + " is invalid, " + e.getMessage());
        } catch (IOException e) {
            System.out.println(xmlFileName + "is invalid, " + e.getMessage());
        }
    }

}
