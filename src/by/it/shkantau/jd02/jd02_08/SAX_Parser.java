package by.it.shkantau.jd02.jd02_08;



import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class SAX_Parser extends DefaultHandler {

    public static void main(String[] args) {

        String fileName = "src/by/it/shkantau/jd02/jd02_07/homework/airportXSD.xml";
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();
            SAX_Parser myImplementationSAX = new SAX_Parser();
            parser.parse(new File(fileName), myImplementationSAX);

        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }

    private String tab = "";
    private StringBuilder text = new StringBuilder();

    @Override
    public void startDocument() throws SAXException {
        System.out.println("Start of the Document");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("End of the Document");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        System.out.print(tab + "[" + qName);
        for (int i = 0; i < attributes.getLength(); i++) {
            System.out.print(" " + attributes.getLocalName(i) + "=" + attributes.getValue(i));
        }
        System.out.println("]");
        tab += "\t";
        text.delete(0,text.length());
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (!text.toString().isEmpty()){
            System.out.println(tab+text);
        }
        text.delete(0,text.length());
        tab = tab.substring(1);
        System.out.println(tab + "[/"+qName+"]");
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        text.append((new String(ch, start, length)).replaceAll("[\n\r]","").trim());
    }
}


