package by.it.opiga.JD_08;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

/**
 * Created by Asus on 16.10.2016.
 */
public class SAX_Parser extends DefaultHandler {

    public static void main(String[] args) {
        try {
            String fileName = "D:\\JAVA\\study\\JD2016-08-22\\src\\by\\it\\opiga\\JD_07\\xml+xsd.xml";
            //создаем фабрику и стандартный парсер
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();
            //создаем собственный вариант SAX-класса
            SAX_Parser myimplementationSax = new SAX_Parser();
            //пуск парсера
            parser.parse(new File(fileName), myimplementationSax);
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String tab="";
    private String value;
    @Override
    public void startDocument() throws SAXException {
        System.out.println("Начало обработки ");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("Конец обработки ");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        System.out.print(tab+"<"+qName);
        for (int i = 0; i < attributes.getLength(); i++) {
            String name=attributes.getLocalName(i);
            String value=attributes.getValue(i);
            System.out.print(" "+name+"="+value);
        }
        System.out.println(">");
        tab='\t'+tab;
        value="";
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if(!value.isEmpty())
            System.out.println(tab+value);
        value="";
        tab=tab.substring(1);
        System.out.println(tab+"</"+qName+">");

    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        value=value.concat(new String(ch,start,length).trim());
    }
}
