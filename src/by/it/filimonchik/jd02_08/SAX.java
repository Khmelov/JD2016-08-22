package by.it.filimonchik.jd02_08;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

/**
 * Created by Raman.Filimonchyk on 21/10/2016.
 */
public class SAX extends DefaultHandler {
    public static void Task_A_SAX() throws SAXException, EnumConstantNotPresentException{
        try {
            String fileName = "src/by/it/filimonchik/jd02_07/auto+xsd.xml";
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();
            SAX myImplementationSax = new SAX();
            parser.parse( new File( fileName ), myImplementationSax );
        } catch (Exception e) {
            System.out.println( "Error " + e.toString() );
        }
    }

    private String tab = "";
    private String value;

    @Override
    public void startDocument() throws SAXException {
        System.out.println( "Начало обработки" );
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println( "Конец обработки" );
    }

    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        {

            System.out.print( tab + "[" + qName );
            for (int i = 0; i < attributes.getLength(); i++) {
                String name = attributes.getLocalName( i );
                String value = attributes.getValue( i );
                System.out.print( " " + name + "=" + value );
            }
            System.out.println( "]" );
            tab = '\t' + tab;
            value = "";
        }
    }
    @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
        if(!value.isEmpty())
            System.out.println(tab+value);
        value="";
        tab=tab.substring( 1 );
        System.out.println(tab + "[/" + qName+ "]");
    }

    @Override
    public void characters (char[] ch, int start, int length) throws SAXException {
        value=value.concat( new String( ch, start, length ).trim() );
    }
}
