package by.it.prymshyts.jd02.jd02_07;

import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

class ValidXSD {
    public static void main(String[] args) {
        String language   = XMLConstants.W3C_XML_SCHEMA_NS_URI;
        String fileName   = "src/by/it/prymshyts/jd02/jd02_07/catalog+xsd.xml";
        String schemeName = "src/by/it/prymshyts/jd02/jd02_07/catalog.xsd";

        SchemaFactory factory = SchemaFactory.newInstance(language);

        File fileLocation   = new File(fileName);
        File schemeLocation = new File(schemeName);

        try {
            Source source = new StreamSource(fileLocation);
            Schema schema = factory.newSchema(schemeLocation);

            Validator validator = schema.newValidator();

            validator.validate(source);
            System.out.println("XML '" + fileName + "' валиден.");

        } catch (SAXException e) {
            System.err.println("Валидация '" + fileName + "' завершена с ошибкой:\n" + e.getMessage());
        } catch (IOException e) {
            System.err.println("XML '" + fileName + "' не валиден:\n" + e.getMessage());
        }
    }
}
