package by.it.filimonchik.jd02_07;

import jdk.internal.org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.File;
import java.io.IOException;

/**
 * Created by Raman.Filimonchyk on 19/10/2016.
 */
public class Validator {
    public static void main(String[ ] args) throws org.xml.sax.SAXException {
        String language = XMLConstants.W3C_XML_SCHEMA_NS_URI;
        String fileName =   "src/by/it/filimonchik/jd02_07/auto+xsd.xml";
        String schemaName = "src/by/it/filimonchik/jd02_07/auto.xsd";
        SchemaFactory factory = SchemaFactory.newInstance(language);
        File schemaLocation = new File(schemaName);
        try {
            // создание схемы
            Schema schema = factory.newSchema(schemaLocation);
            // создание валидатора на основе схемы
            javax.xml.validation.Validator validator = schema.newValidator();
            // проверка документа
            Source source = new StreamSource(fileName);
            validator.validate(source);
            System.out.println(fileName + " валиден.");
        } catch (IOException e) {
            System.err.print(fileName + " не валиден:"
                    + e.getMessage());
        }
    }
}