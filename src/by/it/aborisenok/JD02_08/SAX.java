package by.it.aborisenok.JD02_08;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;


/**
 * Created by Лёша on 12.10.2016.
 */
public class SAX extends DefaultHandler {



    public static void main(String[] args) {
            String filePass = "D:\\JavaProjects\\JD2016-08-22\\src\\by\\it\\aborisenok\\JD02_07\\xml_classwork\\ad+xsd.xml";
        try {

            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = saxParserFactory.newSAXParser();
            SAX sax = new SAX();
            File file = new File(filePass);
            saxParser.parse(file, sax);

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public  String tab = "";
    StringBuilder text = new StringBuilder();

    @Override
    public void startDocument() throws SAXException {
        System.out.println("Start document");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("End document");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        String atr = "";
        System.out.print(tab + "<" + qName);
        for (int i = 0; i < attributes.getLength(); i++){
            System.out.print(" " + attributes.getLocalName(i) + "=");
            System.out.print(" " + attributes.getValue(i));
        }
        System.out.println(">");
        tab = tab.concat("\t");
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {

        if (text.length() > 0)
            System.out.println(tab + text.toString());
        tab = tab.substring(1);
        System.out.println(tab + "</" + qName + ">");
        text.delete(0, text.length());
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        text.append(new String(ch, start, length).trim());
    }
}
