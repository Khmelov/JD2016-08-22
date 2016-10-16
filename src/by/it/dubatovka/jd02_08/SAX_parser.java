package by.it.dubatovka.jd02_08;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class SAX_parser extends DefaultHandler {

    public static void main(String[] args) {
        String fileName = "src/by/it/dubatovka/jd02_07/VulkanXSD.xml";
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser parser = factory.newSAXParser();
            SAX_parser myImplMethod = new SAX_parser();
            parser.parse(new File(fileName), myImplMethod);

        } catch (ParserConfigurationException | SAXException e) {
            System.out.println("Ошибка! " + e.toString());
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String tab = "";
    private String value;

    @Override
    public void startDocument() throws SAXException {
      //  System.out.println("Начало документа");
    }

    @Override
    public void endDocument() throws SAXException {
     //   System.out.println("Конец документа");
    }


    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        System.out.print(tab + "<" + qName);
        for (int i = 0; i < attributes.getLength(); i++) {
            String name = attributes.getLocalName(i);
            String value = attributes.getValue(i);
            System.out.print(" " + name + "=" + value);
        }
        System.out.println(">");
        tab = '\t' + tab;
        value = "";
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (!value.isEmpty()) {
            System.out.println(tab + value);}
            value = "";
            tab = tab.substring(1);
            System.out.println(tab + "</" + qName + ">");
        }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        value=value.concat(new String(ch, start,length)).trim();
    }
}
