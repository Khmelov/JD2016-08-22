package by.it.voronovich.JD02_08;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.io.File;

public class SAX extends DefaultHandler {

    public static void main(String[] args) {

        String filePath = "src/by/it/voronovich/JD02_07/Structure_WebStore.xml";

        try {
            SAXParserFactory parserFactory = SAXParserFactory.newInstance();
            SAXParser parser = parserFactory.newSAXParser();
            SAX implSax = new SAX();
            parser.parse(new File(filePath), implSax);
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String tab = "";
    private String text;

    @Override
    public void startDocument() throws SAXException {
        super.startDocument();
    }

    @Override
    public void endDocument() throws SAXException {
        super.endDocument();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        System.out.print(tab + "<" + qName);
        for (int i = 0; i < attributes.getLength(); i++) {
            String name = attributes.getLocalName(i);
            String value = attributes.getValue(i);
            System.out.print(" " + name + "=" + "\"" + value + "\"");
        }
        System.out.println(">");
        tab = '\t' + tab;
        text = "";
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (!text.isEmpty()) {
            System.out.println(tab + text);
        }
        text = "";
        tab = tab.substring(1);
        System.out.println(tab + "</" + qName + ">");
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        text = text.concat(new String(ch, start, length).trim());
    }
}
