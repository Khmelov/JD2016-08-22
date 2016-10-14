package by.it.prymshyts.jd02.jd02_08;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

class SAX extends DefaultHandler {

    private String tab   = "";
    private String value = "";

    void parse(String fileName) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser         = factory.newSAXParser();

            parser.parse(new File(fileName), this);
        } catch (Exception e) {
            System.err.println("Ошибка:" + e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        System.out.print(tab + "<" + qName);

        for (int i = 0; i < attributes.getLength(); i++) {
            System.out.print(" " + attributes.getLocalName(i) + "=\"" + attributes.getValue(i) + "\"");
        }

        System.out.println(">");
        tab += '\t';
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (!value.isEmpty()) {
            System.out.println(tab + value);
        }
        value = "";
        tab = tab.substring(1);
        System.out.println(tab + "</" + qName + '>');
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        value = value.concat(new String(ch, start, length).trim());
    }
}
