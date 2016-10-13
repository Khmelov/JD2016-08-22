package by.it.grechishnikov.jd02_08;


import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.*;
import java.io.File;

class SAX extends DefaultHandler {
    private static String tab = "";
    private static StringBuilder text = new StringBuilder("");

    public static void run(String path) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();
            SAX sax = new SAX();
            parser.parse(new File(path), sax);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void startDocument() throws SAXException {
        System.out.println("Начинаем парсить через SAX");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("Заканчиваем парсить через SAX");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes atts) throws SAXException {
        System.out.print(tab + "[" + qName);
        for (int i = 0; i < atts.getLength(); i++) {
            String name = atts.getLocalName(i);
            String value = atts.getValue(i);
            System.out.print(" " + name + " = " + "\"" + value + "\"");
        }
        System.out.println("]");
        tab += "\t";
        text.delete(0, text.length());
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if(text.length() != 0) {
            System.out.println(tab + text);
        }
        text.delete(0, text.length());
        tab = tab.substring(1);
        System.out.println(tab + "[/" + qName + "]");
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        text.append(new String(ch, start, length).trim());
    }
}