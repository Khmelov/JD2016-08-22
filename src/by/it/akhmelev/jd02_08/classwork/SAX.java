package by.it.akhmelev.jd02_08.classwork;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class SAX extends DefaultHandler {

    public static void main(String[] args) {
        String filepath="D:\\students\\agh\\JD2016-08-22\\src\\by\\it\\akhmelev\\jd02_07\\04+XSD.xml";
        try {
            SAXParserFactory saxParserFactory=SAXParserFactory.newInstance();
            SAXParser saxParser=saxParserFactory.newSAXParser();
            SAX sax=new SAX();
            File file=new File(filepath);
                saxParser.parse(file,sax);
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    String tab="";
    StringBuilder text=new StringBuilder();

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
        String attr="";
        System.out.print(tab+"<"+qName);
        for (int i = 0; i < attributes.getLength(); i++) {
            System.out.print(" "+attributes.getLocalName(i)+"=");
            System.out.print(attributes.getValue(i));
        }
        System.out.println(">");
        tab=tab.concat("\t");
        text.delete(0,text.length());
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (text.length()>0)
            System.out.println(tab+text.toString());
        tab=tab.substring(1);
        System.out.println(tab+"</"+qName+">");
        text.delete(0,text.length());
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        text.append(new String(ch,start,length).trim());
    }
}
