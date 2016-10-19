package by.it.snegurskiy.jd02_07.xml_class;

import by.it.opiga.JD_08.SAX_Parser;
import com.sun.xml.internal.fastinfoset.tools.FI_DOM_Or_XML_DOM_SAX_SAXEvent;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

class SAX extends DefaultHandler{



    public static void main(String[] args) {

        try {
            String filename ="src/by/it/snegurskiy/jd02_07/xml_class/ad.xml";
            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = saxParserFactory.newSAXParser();
            SAX myImplementationSax =new SAX();

            saxParser.parse(new File(filename),myImplementationSax);

        }catch (ParserConfigurationException e){
            e.printStackTrace();
        } catch (SAXException e) {
        e.printStackTrace();} catch (IOException e) {
            e.printStackTrace();
        }
    }
    private String tab   = "";
    private String value = "";

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
        for (int i = 0; i <attributes.getLength() ; i++) {
            System.out.println(" "+attributes.getLocalName(i)+" ");
            System.out.println(attributes.getValue(i));

        }
        System.out.println(tab+"<"+qName+">");
        tab=tab+"\t";
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        tab=tab.substring(1);
        System.out.println("\n"+tab+"<"+qName+">");
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        System.out.println(tab+new String(ch,start,length).trim());
    }
}
